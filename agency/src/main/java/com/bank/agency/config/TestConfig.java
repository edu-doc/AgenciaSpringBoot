package com.bank.agency.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bank.agency.entities.Account;
import com.bank.agency.entities.CurrentAccount;
import com.bank.agency.entities.Holder;
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
		
		Account cr1 = new CurrentAccount("0001", h1);
		Account cr2 = new CurrentAccount("0001", h2);
		
		cr1.setHolder(h1);
		cr2.setHolder(h2);
		
		h1.setAccount(cr1);
		h2.setAccount(cr2);
		
		accountRepository.saveAll(Arrays.asList(cr1,cr2));
		
		
	}
	
	
}
