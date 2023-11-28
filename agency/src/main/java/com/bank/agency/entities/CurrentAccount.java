package com.bank.agency.entities;

import java.io.Serializable;
import java.util.Objects;

import com.bank.agency.exceptions.AmountException;

import jakarta.persistence.Entity;

@Entity
public class CurrentAccount extends Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double fee;
	private Double limite;
	
	public CurrentAccount() {
		this.fee = 0.5;
		this.limite = 1000.0;
	}

	public CurrentAccount(String agency, Holder holder) {
		super.setAgency(agency);
		super.setHolder(holder);
		super.setBalance(0.0);
		this.fee = 0.5;
		this.limite = 1000.0;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	@Override
	public void withdraw(Double amount) throws AmountException {
		if ((super.getBalance() + getLimite()) < amount) {
			throw new AmountException("você não tem saldo com limite suficiente para saque.");
		}

		if (amount < 0.0) {
			throw new AmountException("você digitou quantidade de saque errado.");
		}
		
		Double aux = super.getBalance();
		aux -= (amount + this.fee);
		super.setBalance(aux);
		
	}

	@Override
	public void deposit(Double amount) throws AmountException {
		if (amount > 0) {
			Double aux = super.getBalance();
			aux += (amount - this.fee);
			super.setBalance(aux);
		} else {
			throw new AmountException("você digitou quantidade de deposito errado.");
		}
		
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(super.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CurrentAccount that = (CurrentAccount) obj;
        return Objects.equals(super.getId(), that.getId());
    }

}
