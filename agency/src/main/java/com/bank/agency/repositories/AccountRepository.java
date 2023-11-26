package com.bank.agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.agency.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
