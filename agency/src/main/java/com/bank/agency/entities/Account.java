package com.bank.agency.entities;

import java.io.Serializable;
import java.util.Objects;

import com.bank.agency.exceptions.AmountException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_accounts")
public abstract class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String agency;
	private Double balance;
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Holder holder;
	
	public Account() {}
	
	public Account (String agency, Holder holder) {
		this.agency = agency;
		this.holder = holder;
		this.balance = 0.0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Holder getHolder() {
		return holder;
	}

	public void setHolder(Holder holder) {
		this.holder = holder;
	}
	
	public abstract void withdraw(Double amount) throws AmountException;

	public abstract void deposit(Double amount) throws AmountException;

	public void transfer(Double amount, Account favored) throws AmountException {
		if (this.balance >= amount && favored != null) {
			this.balance -= amount;
			favored.deposit(amount);
		} else {
			throw new AmountException("transferencia não concluida");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}
	
}
