package pt.link.sc.transaction.api.common.util;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import pt.link.sc.transaction.api.business.exceptions.InvalidOperationException;
import pt.link.sc.transaction.api.common.enums.InvalidOperationCode;
import pt.link.sc.transaction.api.resources.model.ReloadTransaction;
import pt.link.sc.transaction.api.resources.model.Transaction;
import pt.link.sc.transaction.api.resources.model.ValidationTransaction;

public class CsvUtil {

    private static Logger log = LoggerFactory.getLogger(CsvUtil.class);
    private static final SimpleDateFormat CSV_TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final SimpleDateFormat CSV_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Transaction processCsv(String csv, String correlationId, String locationDescription) {

        try {
            CSVParser parser = CSVFormat.EXCEL.withDelimiter(';').parse(new InputStreamReader(new ByteArrayInputStream(csv.getBytes())));
            final CSVRecord record = parser.getRecords()
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new InvalidOperationException(InvalidOperationCode.INVALID_CSV_TRANSACTION_RECORD_ONE_ARG, new Object[]{csv}));

            Integer transactionType = Integer.valueOf(record.get(0));
            
            switch (transactionType) {
                case 1:
                    ReloadTransaction reloadDTO = new ReloadTransaction();
                    reloadDTO.setCorrTransactionID(correlationId);
                    if (StringUtils.isNoneBlank(locationDescription)) {
                    	reloadDTO.setLocationDescription(locationDescription);
                    }
                    reloadDTO.setCsv(csv);
                	//Load data for VivaCards
                    processLoadCsvRecord(reloadDTO, record);
                    return reloadDTO;
                case 2:
                    ValidationTransaction validationDTO = new ValidationTransaction();
                    
                    if (StringUtils.isNoneBlank(locationDescription)) {
                    	validationDTO.setLocationDescription(locationDescription);
                    }
                    validationDTO.setCsv(csv);
                	//Validation transactions
                    processValidationCsvRecord(validationDTO, record);
                    return validationDTO;
                default:
                    throw new RuntimeException("Unknow transaction type. Could not process");
            }
        } catch (Exception e) {
            log.error("Error in csv parser", e);
            throw new InvalidOperationException(InvalidOperationCode.INVALID_CSV_TRANSACTION_RECORD_ONE_ARG, new Object[]{csv});
        }
    }
    
    private static void processValidationCsvRecord(ValidationTransaction transaction, CSVRecord record) throws ParseException {
        int index = 0;
        
        Integer transactionType = integerValue(record, index);
    	transaction.setTransactionType(transactionType);
    	
        String transactionVersion = stringValue(record, index += 1);
        transaction.setTransactionVersion(transactionVersion);
        
        String transactionId = stringValue(record, index += 1);
        transaction.setTransactionId(transactionId);
        
        String groupId = stringValue(record, index += 1);
    	transaction.setGroupId(groupId);

        Date transactionDate = dateValueTimestamp(record, index += 1);
    	transaction.setTransactionDate(transactionDate);

        Integer loadOper = integerValue(record, index += 1);
    	transaction.setEventOper(loadOper);
    	
    	Integer eventSuccessCode = integerValue(record, index += 1);
    	transaction.setEventSuccessCode(eventSuccessCode);

        Integer eventType = integerValue(record, index += 1);
    	transaction.setEventType(eventType);
    	
        Integer eventMachineCode = integerValue(record, index += 1);
    	transaction.setEventMachineCode(eventMachineCode);
        
        Date eventFirstDatetimeEntrance = dateValue(record, index += 1);
        transaction.setEventFirstDatetimeEntrance(eventFirstDatetimeEntrance);
        
        Integer eventContLocation = integerValue(record, index += 1);
        transaction.setEventContLocation(eventContLocation);

        Integer eventStopIndex = integerValue(record, index += 1);
        transaction.setEventStopIndex(eventStopIndex);
        
        Integer eventStopSubIndex = integerValue(record, index += 1);
        transaction.setEventStopSubIndex(eventStopSubIndex);
        
        Integer eventRunCode = integerValue(record, index += 1);
    	transaction.setEventRunCode(eventRunCode);

        Integer eventRouteCode = integerValue(record, index += 1);
    	transaction.setEventRouteCode(eventRouteCode);

        Integer cardDataModel = integerValue(record, index += 1); 
        transaction.setCardDataModel(cardDataModel);
        
        Integer cardPhysicalType = integerValue(record, index += 1); 
        transaction.setCardPhysicalType(cardPhysicalType);
        
        Integer cardIssuer = integerValue(record, index += 1);
        transaction.setCardIssuer(cardIssuer);

        BigInteger cardNumb = bigIntegerValue(record, index += 1); 
        transaction.setCardNumb(cardNumb);
        
        BigInteger cardSerialNumberHigh = bigIntegerValue(record, index += 1);
        BigInteger cardSerialNumberLow = bigIntegerValue(record, index += 1);
        Assert.notNull(cardSerialNumberHigh, "cardSerialNumberHigh cannot be null");
        Assert.notNull(cardSerialNumberLow, "cardSerialNumberHigh cannot be null");
        String cardSerialNumber = buildCardSerialNumber(cardSerialNumberHigh, cardSerialNumberLow);
        transaction.setCardSerialNumberHexString(cardSerialNumber);

        Integer cardCalypsoChipRef = integerValue(record, index += 1);
        transaction.setCardCalypsoChipRef(cardCalypsoChipRef);
        
        Integer cardCalypsoApplType = integerValue(record, index += 1);
        transaction.setCardCalypsoApplType(cardCalypsoApplType);
        
        Integer cardCalypsoApplSubType = integerValue(record, index += 1);
        transaction.setCardCalypsoApplSubType(cardCalypsoApplSubType);
        
        Integer cardCalypsoApplIssu = integerValue(record, index += 1);
        transaction.setCardCalypsoApplIssu(cardCalypsoApplIssu);
        
        String eventBinary = stringValue(record, index += 1);
    	transaction.setEventBinary(eventBinary);
    	
    	String validationBinary = stringValue(record, index += 1);
		transaction.setValidationBinary(validationBinary);
		
		Integer originIndexCode = integerValue(record, index += 1);
		transaction.setOriginIndexCode(originIndexCode);
		
		Integer originSubIndexCode = integerValue(record, index += 1);
		transaction.setOriginSubIndexCode(originSubIndexCode);
        
        Integer destinationIndexcode = integerValue(record, index += 1);
    	transaction.setDestinationIndexcode(destinationIndexcode);

        Integer destinationSubIndexcode = integerValue(record, index += 1);
        transaction.setDestinationSubIndexcode(destinationSubIndexcode);
        
        String mac = stringValue(record, index += 1);
        transaction.setMac(mac);
        
        Integer prof1Code = integerValue(record, index += 1);
        transaction.setProf1Code(prof1Code);
        
        Integer prof1ExpDate = integerValue(record, index += 1);
        transaction.setProf1ExpDate(prof1ExpDate);

        Integer prof2Code = integerValue(record, index += 1);
        transaction.setProf2Code(prof2Code);

        Integer prof2ExpDate = integerValue(record, index += 1);
        transaction.setProf2ExpDate(prof2ExpDate);
        
        Integer prof3Code = integerValue(record, index += 1);
        transaction.setProf3Code(prof3Code);

        Integer prof3ExpDate = integerValue(record, index += 1);
        transaction.setProf3ExpDate(prof3ExpDate);
    	
    }

    private static void processLoadCsvRecord(ReloadTransaction transaction, CSVRecord record) throws ParseException {
        int index = 0;
        
        Integer transactionType = integerValue(record, index);
    	transaction.setTransactionType(transactionType);

        Integer loadingTransactionType = integerValue(record, index += 1);
        transaction.setLoadingTransactionType(loadingTransactionType);
        
        String transactionVersion = stringValue(record, index += 1);
        transaction.setTransactionVersion(transactionVersion);
        
        String transactionId = stringValue(record, index += 1);
        transaction.setTransactionId(transactionId);
        
        String groupId = stringValue(record, index += 1);
    	transaction.setGroupId(groupId);

        Date transactionDate = dateValueTimestamp(record, index += 1);
    	transaction.setTransactionDate(transactionDate);

        Integer loadOper = integerValue(record, index += 1);
    	transaction.setLoadOper(loadOper);
    	
        Date tickReloDate = dateValue(record, index += 1);
    	transaction.setTickReloDate(tickReloDate);

        Integer tickReloMachCode = integerValue(record, index += 1);
    	transaction.setTickReloMachCode(tickReloMachCode);
    	
        Integer tickReloNumbDaily = integerValue(record, index += 1);
    	transaction.setTickReloNumbDaily(tickReloNumbDaily);

        String corrTransactionID = stringValue(record, index += 1);
        transaction.setCorrTransactionID(corrTransactionID);
        
        Date corrTickReloDate = dateValue(record, index += 1);
        transaction.setCorrTickReloDate(corrTickReloDate);
        
        Integer corrTickReloMachCode = integerValue(record, index += 1);
        transaction.setCorrTickReloMachCode(corrTickReloMachCode);
        
        Integer corrTickReloNumbDaily = integerValue(record, index += 1);
        transaction.setCorrTickReloNumbDaily(corrTickReloNumbDaily);

        Integer corrCardDataModel = integerValue(record, index += 1);
        transaction.setCorrCardDataModel(corrCardDataModel);

        BigInteger vinhSeriNumb = bigIntegerValue(record, index += 1);
        transaction.setVinhSeriNumb(vinhSeriNumb);
        
        Integer loadedQuantity = integerValue(record, index += 1);
    	transaction.setLoadedQuantity(loadedQuantity);

        Integer productQuantity = integerValue(record, index += 1);
    	transaction.setProductQuantity(productQuantity);

        String posId = stringValue(record, index += 1);
    	transaction.setPosId(posId);

        BigInteger fiscalNr = bigIntegerValue(record, index += 1);
    	transaction.setFiscalNr(fiscalNr);

        String invoiceNr = stringValue(record, index += 1);
        transaction.setInvoiceNr(invoiceNr);
        
        Integer cardDataModel = integerValue(record, index += 1); 
        transaction.setCardDataModel(cardDataModel);
        
        Integer cardPhysicalType = integerValue(record, index += 1); 
        transaction.setCardPhysicalType(cardPhysicalType);
        
        Integer cardIssuer = integerValue(record, index += 1);
        transaction.setCardIssuer(cardIssuer);

        BigInteger cardNumb = bigIntegerValue(record, index += 1); 
        transaction.setCardNumb(cardNumb);
        
        BigInteger cardSerialNumberHigh = bigIntegerValue(record, index += 1);
        BigInteger cardSerialNumberLow = bigIntegerValue(record, index += 1);
        Assert.notNull(cardSerialNumberHigh, "cardSerialNumberHigh cannot be null");
        Assert.notNull(cardSerialNumberLow, "cardSerialNumberHigh cannot be null");
        String cardSerialNumber = buildCardSerialNumber(cardSerialNumberHigh, cardSerialNumberLow);
        transaction.setCardSerialNumberHexString(cardSerialNumber);

        Integer cardCalypsoChipRef = integerValue(record, index += 1);
        transaction.setCardCalypsoChipRef(cardCalypsoChipRef);
        
        Integer cardCalypsoApplType = integerValue(record, index += 1);
        transaction.setCardCalypsoApplType(cardCalypsoApplType);
        
        Integer cardCalypsoApplSubType = integerValue(record, index += 1);
        transaction.setCardCalypsoApplSubType(cardCalypsoApplSubType);
        
        Integer cardCalypsoApplIssu = integerValue(record, index += 1);
        transaction.setCardCalypsoApplIssu(cardCalypsoApplIssu);
        
    	Integer profCompOper = integerValue(record, index += 1);
    	transaction.setProfCompOper(profCompOper);
    	
		Integer custProf = integerValue(record, index += 1);
		transaction.setCustProf(custProf);
		
		Integer custProf2 = integerValue(record, index += 1);
		transaction.setCustProf2(custProf2);
		
		Integer custProf3 = integerValue(record, index += 1);
		transaction.setCustProf3(custProf3);
        
        Integer entity = integerValue(record, index += 1);
    	transaction.setEntity(entity);

        BigInteger corrCardIssuer = bigIntegerValue(record, index += 1);
        transaction.setCorrCardIssuer(corrCardIssuer);
        
        Integer corrCardNumber = integerValue(record, index += 1);
    	transaction.setCorrCardNumber(corrCardNumber);

        BigInteger corrCardSeriNumbHigh = bigIntegerValue(record, index += 1);
        BigInteger corrCardSeriNumbLow = bigIntegerValue(record, index += 1);
        String corrCardSerialNumber = buildCardSerialNumber(corrCardSeriNumbHigh, corrCardSeriNumbLow);
        transaction.setCorrCardSerialNumberHexString(corrCardSerialNumber);

        Integer tickOperCode = integerValue(record, index += 1);
    	transaction.setTickOperCode(tickOperCode);

        Integer tickCode = integerValue(record, index += 1);
    	transaction.setTickCode(tickCode);

        String loadContract = stringValue(record, index += 1);
    	transaction.setLoadContract(loadContract);
    	
        Integer contractIndex = integerValue(record, index += 1);
    	transaction.setContractIndex(contractIndex);

        String greenListCounter = stringValue(record, index += 1);
        transaction.setGreenListCounter(greenListCounter);
        
        String previousContract = stringValue(record, index += 1);
    	transaction.setPreviousContract(previousContract);

        Date firstDateTimeEntrance = dateValueTimestamp(record, index += 1);
    	transaction.setFirstDateTimeEntrance(firstDateTimeEntrance);

        Integer corrTickOperCode = integerValue(record, index += 1);
    	transaction.setCorrTickOperCode(corrTickOperCode);

        Integer corrTickCode = integerValue(record, index += 1);
    	transaction.setCorrTickCode(corrTickCode);

        Integer price = integerValue(record, index += 1);
    	transaction.setPrice(price);

        Integer corrPrice = integerValue(record, index += 1);
    	transaction.setCorrPrice(corrPrice);

        Integer paymMean = integerValue(record, index += 1);
    	transaction.setPaymMean(paymMean);

        String paymAccount = stringValue(record, index += 1);
        transaction.setPaymAccount(paymAccount);
        
        Integer comission = integerValue(record, index += 1);
    	transaction.setComission(comission);

        Integer reduction = integerValue(record, index += 1);
        transaction.setReduction(reduction);
        
        Date pricingDate = dateValue(record, index += 1);
        transaction.setPricingDate(pricingDate);

        String pinBlock = stringValue(record, index += 1);
    	transaction.setPinBlock(pinBlock);

        String mac = stringValue(record, index += 1);
        transaction.setMac(mac);
        
        Integer paymentPriceDecimalDigits = integerValue(record, index += 1);
        transaction.setPaymentPriceDecimalDigits(paymentPriceDecimalDigits);
        
        Integer hasSubMachineCode = integerValue(record, index += 1);
        transaction.setHasSubMachineCode(hasSubMachineCode);
        
        Integer prof1Code = integerValue(record, index += 1);
        transaction.setProf1Code(prof1Code);
        
        Integer prof1ExpDate = integerValue(record, index += 1);
        transaction.setProf1ExpDate(prof1ExpDate);

        Integer prof2Code = integerValue(record, index += 1);
        transaction.setProf2Code(prof2Code);

        Integer prof2ExpDate = integerValue(record, index += 1);
        transaction.setProf2ExpDate(prof2ExpDate);
        
        Integer prof3Code = integerValue(record, index += 1);
        transaction.setProf3Code(prof3Code);

        Integer prof3ExpDate = integerValue(record, index += 1);
        transaction.setProf3ExpDate(prof3ExpDate);
    	
    }

    public static String buildCardSerialNumber(BigInteger cardSerialNumberHigh, BigInteger cardSerialNumberLow) {
        String hex = cardSerialNumberHigh.toString(16) + StringUtils.leftPad(cardSerialNumberLow.toString(16), 8, "0");
        return StringUtils.leftPad(hex, 16, "0").toUpperCase();
    }

    public static String buildCardSerialNumber(Long cardSerialNumberHigh, Long cardSerialNumberLow) {
        return buildCardSerialNumber(BigInteger.valueOf(cardSerialNumberHigh), BigInteger.valueOf(cardSerialNumberLow));
    }


    private static String stringValue(CSVRecord record, int index) {
        String val = record.get(index);
        if (StringUtils.isBlank(val)) {
            log.info("stringValue: " + null + " record: " + record + " index: " + index);
            return null;
        }
        log.info("stringValue: " + val.trim() + " record: " + record + " index: " + index);
        return val.trim();
    }

    private static Integer integerValue(CSVRecord record, int index) {
        String stringValue = stringValue(record, index);
        if (stringValue != null) {
            log.info("integerValue: " + Integer.valueOf(stringValue.trim()) + " record: " + record + " index: " + index);
            return Integer.valueOf(stringValue.trim());
        }
        log.info("integerValue: " + null + " record: " + record + " index: " + index);
        return null;
    }

    private static Long longValue(CSVRecord record, int index) {
        String stringValue = stringValue(record, index);
        if (stringValue != null) {
            log.info("longValue: " + Long.valueOf(stringValue) + " record: " + record + " index: " + index);
            return Long.valueOf(stringValue);
        }
        log.info("longValue: " + null + " record: " + record + " index: " + index);
        return null;
    }

    private static BigInteger bigIntegerValue(CSVRecord record, int index) {
        String stringValue = stringValue(record, index);
        if (stringValue != null) {
            log.info("bigIntegerValue: " + new BigInteger(stringValue) + " record: " + record + " index: " + index);
            return new BigInteger(stringValue);
        }
        log.info("bigIntegerValue: " + null + " record: " + record + " index: " + index);
        return null;
    }

    private static Date dateValueTimestamp(CSVRecord record, int index) throws ParseException {
        String stringValue = stringValue(record, index);
        if (StringUtils.isNotBlank(stringValue)) {
        	stringValue = stringValue.replace("T", " ");
            return CSV_TIMESTAMP_FORMAT.parse(stringValue);
        }
        return null;
    }

    private static Date dateValue(CSVRecord record, int index) throws ParseException {
        String stringValue = stringValue(record, index);
        if (StringUtils.isNotBlank(stringValue)) {
            return CSV_DATE_FORMAT.parse(stringValue);
        }
        return null;
    }
}
