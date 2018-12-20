package pt.link.sc.transaction.api.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;


public class CryptoUtil {

    private static final IvParameterSpec ZERO_IV = new IvParameterSpec(new byte[16]);
    private static final byte CONSTANT = (byte) 0x87;

    public static byte[] calculateHmac(byte[] key, byte[] iv, byte[] data) throws NoSuchAlgorithmException {
        byte[] diversifiedKey = new byte[key.length];
        System.arraycopy(key, 0, diversifiedKey, 0, key.length);

        if (iv != null) {
            if (iv.length > key.length) {
                throw new RuntimeException("IV is greater than key");
            }
            for (int i = 0; i < iv.length; i++) {
                diversifiedKey[i] = (byte) (key[i] ^ iv[i]);
            }
        } else {
            diversifiedKey = key;
        }

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] blockToSign = digest.digest(data);


        HMac hmac = new HMac(new SHA256Digest());
        byte[] resBuf = new byte[hmac.getMacSize()];

        hmac.init(new KeyParameter(diversifiedKey));
        hmac.update(blockToSign, 0, blockToSign.length);
        hmac.doFinal(resBuf, 0);

        return resBuf;
    }
    
    public static String bigIntegerToHexString(BigInteger value) {
        if (value == null) {
            return StringUtils.EMPTY;
        }
        return StringUtils.leftPad(Hex.toHexString(value.toByteArray()), 16, "0").toUpperCase();
    }

    public static BigInteger hexStringToBigInteger(String value) {
        if (value == null) {
            return null;
        }
        return new BigInteger(value, 16);
    }

    public static BigInteger toCardSerialNumber(String value) {
        if (value == null) {
            return null;
        }
        value = value.length() > 16 ? value.substring(value.length() - 16) : value;
        return new BigInteger(value, 16);
    }

    private static Optional<Integer> deriveCardTechTypeFromHexCardSerialNumber(String value) {
        if (value == null || value.length() <= 16) {
            return Optional.empty();
        }
        int charForTechType = value.length() - 16;
        return Optional.of(new BigInteger(value.substring(0, charForTechType), 16).intValue());
    }

    public static CardId fromCardIdentifier(String value) {
        if (value == null) {
            return null;
        }
        final Integer cardTechType = deriveCardTechTypeFromHexCardSerialNumber(value).orElse(null);
        BigInteger cardSerialNumber = toCardSerialNumber(value);
        return new CardId(cardSerialNumber, cardTechType);
    }

    public static String toCardIdentifier(BigInteger cardSerialNumber, Integer cardTechType) {
        if (cardSerialNumber == null) {
            return null;
        }
        final String cardTechTypeHexString = Optional.ofNullable(cardTechType).map(ctt -> StringUtils.leftPad(Integer.toHexString(ctt), 2, "0")).orElse("");
        return cardTechTypeHexString + bigIntegerToHexString(cardSerialNumber);
    }

    public static String toCardIdentifier(CardId cardId) {
        if (cardId == null) {
            return null;
        }
        return toCardIdentifier(cardId.getCardSerialNumber(),cardId.getCardTechType());
    }
}
