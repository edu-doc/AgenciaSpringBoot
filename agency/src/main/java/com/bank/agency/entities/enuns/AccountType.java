package com.bank.agency.entities.enuns;

public enum AccountType {

	CURRENT(1),
	SAVING(2),
	SPECIAL(3);
	
	private int code;
	
	private AccountType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static AccountType valueOf(int code) {
		for (AccountType value : AccountType.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid AccountType code");
	}
	
}
