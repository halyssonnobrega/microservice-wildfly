package pt.link.sc.transaction.api.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.primitives.Ints;

import pt.link.sc.transaction.api.resources.model.ReloadTransaction;

public class MacUtil {

    private static Logger log = LoggerFactory.getLogger(MacUtil.class);

    private static final int macSignatureByteSize = 8;
    private static final LocalDateTime baseDate = java.time.LocalDateTime.of(2012, 1, 1, 0, 0, 0);

    private static boolean performMacValidation(ReloadTransaction t, String keyHexString) {
        try {
            return performMacValidation(new BigInteger(t.getCardSerialNumberHexString(), 16), t.getCardPhysicalType(), t.getCardDataModel(), t.getTransactionDate(), t.getLoadContract(), t.getMac(), keyHexString);
        } catch (NoSuchAlgorithmException | IllegalStateException | IOException e) {
            log.error("Could not perform mac Validation.", e);
            return false;
        }
    }

    /**
     * Card counter is 4 byte Its the 4 bytes starting from the 3rd position of the
     * mac byte array
     * <p>
     * The counter begins on the Integer max value and is decreased. In order for
     * the counter to start on 0 mac card counter is subtracted from
     * Integer.MAX_VALUE
     */
    public static Long getSequentialTransactionNumber(String macBase64) {
        byte[] mac = Base64.getDecoder().decode(macBase64);
        byte[] cardCounter = new byte[4];

        System.arraycopy(mac, 2, cardCounter, 0, cardCounter.length);
        return new Integer(Integer.MAX_VALUE - Ints.fromByteArray(cardCounter)).longValue();
    }

    /**
     * MacKeyRef is 2 byte
     */
    public static Integer getMacKeyRef(String macBase64) {
        byte[] mac = Base64.getDecoder().decode(macBase64);
        byte[] macKeyRef = new byte[2];

        System.arraycopy(mac, 16, macKeyRef, 0, macKeyRef.length);
        return new BigInteger(macKeyRef).intValue();
    }

    private static boolean performMacValidation(BigInteger cardSerialNumber, Integer cardPhysicalType, Integer cardDataModel, Date timestamp, String transactionBinaryBase64, String macBase64, String keyHexString)
            throws IOException, NoSuchAlgorithmException, IllegalStateException {

        LocalDateTime timestampLocalDateTime = LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
        Long secondsBetween = ChronoUnit.SECONDS.between(baseDate, timestampLocalDateTime);

        byte[] cardSerialNumberByte = new byte[8];
        System.arraycopy(cardSerialNumber.toByteArray(), 0, cardSerialNumberByte, 8 - cardSerialNumber.toByteArray().length, cardSerialNumber.toByteArray().length);

        byte[] mac = Base64.getDecoder().decode(macBase64);
        byte[] macVersion = new byte[1];
        byte[] interruptedFlag = new byte[1];
        byte[] cardCounter = new byte[4];
        byte[] samModal = new byte[1];
        byte[] samVersion = new byte[1];
        byte[] macSignature = new byte[macSignatureByteSize];
        byte[] macKeyRef = new byte[2];
        byte[] samSerial = new byte[8];
        byte[] transactionData = Base64.getDecoder().decode(transactionBinaryBase64);


        System.arraycopy(mac, 0, macVersion, 0, macVersion.length);
        System.arraycopy(mac, 1, interruptedFlag, 0, interruptedFlag.length);
        System.arraycopy(mac, 2, cardCounter, 0, cardCounter.length);
        System.arraycopy(mac, 6, samModal, 0, samModal.length);
        System.arraycopy(mac, 7, samVersion, 0, samVersion.length);
        System.arraycopy(mac, 8, macSignature, 0, macSignature.length);
        System.arraycopy(mac, 16, macKeyRef, 0, macKeyRef.length);
        System.arraycopy(mac, 18, samSerial, 0, samSerial.length);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        /*
          Common fields
         */
        outputStream.write(cardSerialNumberByte);
        outputStream.write(cardPhysicalType.byteValue());
        outputStream.write(cardDataModel.byteValue());
        outputStream.write(Ints.toByteArray(secondsBetween.intValue()));

        /*
          Transaction binary data
         */
        outputStream.write(transactionData);
        /*
          MAC static data
         */
        outputStream.write(macVersion);
        outputStream.write(interruptedFlag);
        outputStream.write(cardCounter);
        outputStream.write(samSerial);

        byte[] block = outputStream.toByteArray();
        byte[] resBuf = CryptoUtil.calculateHmac(Hex.decode(keyHexString), cardSerialNumberByte, block);

        // Ensure that result is the same size as macSignature
        byte[] result = new byte[macSignatureByteSize];
        System.arraycopy(resBuf, 0, result, 0, macSignatureByteSize);
        return Arrays.equals(result, macSignature);

    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        //LOAD
    	ReloadTransaction processCsv = (ReloadTransaction) CsvUtil.processCsv(
                "1;3;2.0;5AFADF93-0000-0100-0100-31525B8122C6;;2018-05-15 14:24:34;0;275269;2329235840;20;23;1;57;2;;;;0;0;0;0;;;;1;1;2;Stored Value;3;1;5002;13;0;0;500;0;1;3000;500;0;0;0;;;;1;BJCAAJIsEAABOKAAABEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAK3EAAAnE;BJCAAJIsEAABOKAAANEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAu3EAAAu4;;;;;;2018-05-15 14:24:34;AQMBLASCRZsARRCAAATiggAB9AALuAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHiBMASQgACSLBAAATigAAARBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACtxAAAJxDAEkIAAkiwQAAE4oAAA0QQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC7cQAAC7g=;AQB///7XAAAnodncNYGS1yABAAAAAAAAAAA=;;",
                null, null);
        System.out.println("LOAD: " + performMacValidation(processCsv, "FF6A0336812BD68DBCCF644CEDD464C6897D43293927E774B969A24CB8BE4613"));
    }
}
