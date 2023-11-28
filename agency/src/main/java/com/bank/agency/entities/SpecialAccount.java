package com.bank.agency.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class SpecialAccount extends CurrentAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public SpecialAccount() {}
	
	public SpecialAccount(String agency, Holder holder) {
		super.setAgency(agency);
		super.setHolder(holder);
		super.setBalance(0.0);
		super.setLimite(5000.0);
		super.setFee(0.25);
	}
	
	public void update(Double rate) {
		Double aux = super.getBalance();
		aux += (aux * (rate/100));
		super.setBalance(aux);
	}

}
