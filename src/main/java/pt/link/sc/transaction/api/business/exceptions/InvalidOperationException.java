package pt.link.sc.transaction.api.business.exceptions;

import java.util.Arrays;

import pt.link.sc.transaction.api.common.enums.InvalidOperationCode;

public class InvalidOperationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4855515904612172313L;
	
	private InvalidOperationCode invalidOperationCode;
	private Object[] args;

	public InvalidOperationException(InvalidOperationCode invalidOperationCode, Object[] args) {
		super();
		this.invalidOperationCode = invalidOperationCode;
		this.args = args;
	}

	public InvalidOperationCode getInvalidOperationCode() {
		return invalidOperationCode;
	}

	public void setInvalidOperationCode(InvalidOperationCode invalidOperationCode) {
		this.invalidOperationCode = invalidOperationCode;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "InvalidOperationException [invalidOperationCode=" + invalidOperationCode + ", args=" + Arrays.toString(args) + "]";
	}

}