package pt.link.sc.transaction.api.common.enums;

import javax.ws.rs.core.Response.Status;

/**
 * List of API error codes and their corresponding HTTP status codes.
 * <p/>
 * Default messages for the error codes are defined in the 'messages' resource bundle.
 *
 * @author mario.macarico
 */
public enum InvalidOperationCode {
    AUTHENTICATION__TOKEN_VERIFICATION_ERROR                (0, Status.UNAUTHORIZED),
	UNEXPECTED_ERROR										(1, Status.INTERNAL_SERVER_ERROR),
	VALIDATION_ERROR										(2, Status.BAD_REQUEST),
	CONTRACT_TYPE_IS_REQUIRED								(3, Status.BAD_REQUEST),
	UNNEXPECTED_CHANNEL_TYPE__ONE_ARG						(4, Status.BAD_REQUEST),
	UNNEXPECTED_OPERATION__ONE_ARG							(5, Status.BAD_REQUEST),
	AMOUNT_IS_REQUIRED										(6, Status.BAD_REQUEST),
	AUTHORIZATION_NOT_FOUND__ONE_ARG						(7, Status.NOT_FOUND),
	INVALID_CARD_STATUS__TWO_ARGS							(8, Status.CONFLICT),
	EXPIRED_CARD__ONE_ARG									(9, Status.CONFLICT),
	INVALID_DISTRIBUTION_POINT								(10, Status.CONFLICT),
	CARD_NOT_FOUND__TWO_ARGS								(11, Status.NOT_FOUND),
	CARD_LOT_ALREADY_EXISTS_WITH_SERIAL_NUMBERS__THREE_ARGS	(12, Status.CONFLICT),
	CARD_AMOUNT_NOT_AVAILABLE_FOR_DISTRIBUTION__ONE_ARG		(13, Status.CONFLICT),
	CURRENCY_IS_REQUIRED									(14, Status.BAD_REQUEST),
	CARD_LOGICAL_NOT_FOUND__ONE_ARG							(15, Status.NOT_FOUND),
	CARD_NUMBER_IS_REQUIRED									(16, Status.BAD_REQUEST),
	CARD_LOT_DISTRIBUTION_POINT_NOT_FOUND					(17, Status.INTERNAL_SERVER_ERROR),
	INVALID_TRANSACTION_TYPE__ONE_ARG						(18, Status.BAD_REQUEST),
	UNNEXPECTED_TRANSACTION_TYPE__ONE_ARG					(19, Status.BAD_REQUEST),
	INVALID_MAPPING__ONE_ARG								(20, Status.BAD_REQUEST),
	BLACKLISTED_CARD__TWO_ARGS								(21, Status.CONFLICT),
	CARD_NUMBER_NOT_FOUND__ONE_ARGS							(22, Status.NOT_FOUND),
	MUST_ONLY_HAVE_TRANSACTION_OF_TYPE__ONE_ARG				(23, Status.CONFLICT),
	CANNOT_HAVE_TRANSACTIONS								(24, Status.CONFLICT),
	TRANSACTIONS_FOR_OTHER_CARD__THREE_ARG					(25, Status.CONFLICT),
	TRANSACTIONS_CONTRACT_DIFFERENT__TWO_ARGS 				(26, Status.CONFLICT),
	TRANSACTIONS_AMOUNT_DIFFERENT__TWO_ARGS 				(27, Status.CONFLICT),
	AUTHORIZATION_ALREADY_PERFORMED							(28, Status.CONFLICT),
	MUST_HAVE_TRANSACTION__ONE_ARG							(29, Status.CONFLICT),
	UNEXPECTED_CURRENCY__ONE_ARG							(30, Status.CONFLICT),
	MAXIMUN_ALLOWED_EXCEEDED__TWO_ARGS						(31, Status.CONFLICT),
	REFUND_LIMIT_DATE_HAS_BEEN_REACHED___ONE_ARG			(32, Status.CONFLICT),
	REQUEST_SIZE_TOO_BIG__TWO_ARGS							(33, Status.BAD_REQUEST),
	NOT_FOUND												(34, Status.NOT_FOUND),
	UNEXPECTED_ERROR_ONE_ARG								(35, Status.INTERNAL_SERVER_ERROR),
	INVALID_CSV_TRANSACTION_RECORD_ONE_ARG					(36, Status.BAD_REQUEST),
	DISTRIBUTION_FOR_CARD_AND_CHANNEL_NOT_FOUND__THREE_ARGS	(37, Status.CONFLICT),
	UNKNOW_CARD_PHYSICAL_TYPE_ONE_ARGS						(38, Status.BAD_REQUEST),
	;


	private String code;
	private Integer httpCode;


	InvalidOperationCode(Integer code, Status status) {
		this.code = String.valueOf(code);;
		this.httpCode = status.getStatusCode();
	}

	public String getCode() {
		return code;
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}

	public void setCode(String code) {
		this.code = code;
	}



}
