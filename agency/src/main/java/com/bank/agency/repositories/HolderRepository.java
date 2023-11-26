package com.bank.agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.agency.entities.Holder;

public interface HolderRepository extends JpaRepository<Holder, Long> {

}
