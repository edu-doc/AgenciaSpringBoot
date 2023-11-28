package com.bank.agency.entities;

import java.io.Serializable;

import com.bank.agency.exceptions.AmountException;

import jakarta.persistence.Entity;

@Entity
public class SavingAccount extends Account implements Serializable{

	private static final long serialVersionUID = 1L;

	public SavingAccount() {}
	
	public SavingAccount(String agency, Holder holder) {
		super.setAgency(agency);
		super.setHolder(holder);
		super.setBalance(0.0);
	}

	@Override
	public void withdraw(Double amount) throws AmountException {
		if (super.getBalance() < amount) {
			throw new AmountException("você não tem saldo com limite suficiente para saque.");
		}

		if (amount < 0.0) {
			throw new AmountException("você digitou quantidade de saque errado.");
		}
		
		Double aux = super.getBalance();
		aux -= amount;
		super.setBalance(aux);
		
	}

	@Override
	public void deposit(Double amount) throws AmountException {
		if (amount > 0) {
			Double aux = super.getBalance();
			aux += amount;
			super.setBalance(aux);
		} else {
			throw new AmountException("você digitou quantidade de deposito errado.");
		}
		
	}
	
	
	
	
}
