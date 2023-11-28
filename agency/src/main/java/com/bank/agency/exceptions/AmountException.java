package com.bank.agency.exceptions;

public class AmountException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AmountException(String msg) {
		super(msg);
	}

}
