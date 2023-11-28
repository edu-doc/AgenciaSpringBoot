package com.bank.agency.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bank.agency.entities.Account;
import com.bank.agency.entities.CurrentAccount;
import com.bank.agency.entities.Holder;
import com.bank.agency.entities.SavingAccount;
import com.bank.agency.entities.SpecialAccount;
import com.bank.agency.repositories.AccountRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Holder h1 = new Holder("Eduardo", "111.222.333-44");
		Holder h2 = new Holder("Maria", "222.333.444-55");
		Holder h3 = new Holder("Joao", "333.444.555-66");
		
		Account cr1 = new CurrentAccount("0001", h1);
		Account cr2 = new SavingAccount("0001", h2);
		Account cr3 = new SpecialAccount("0001", h3);
		
		cr1.setHolder(h1);
		cr2.setHolder(h2);
		cr3.setHolder(h3);
		
		h1.setAccount(cr1);
		h2.setAccount(cr2);
		h3.setAccount(cr3);
		
		cr1.deposit(2000.0);
		
		accountRepository.saveAll(Arrays.asList(cr1,cr2,cr3));
		
		
	}
	
	
}
