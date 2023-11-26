package com.bank.agency.entities;

import java.io.Serializable;
import java.util.Objects;

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
