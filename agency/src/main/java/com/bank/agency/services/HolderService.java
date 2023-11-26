package com.bank.agency.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.agency.entities.Holder;
import com.bank.agency.repositories.HolderRepository;

@Service
public class HolderService {

	@Autowired
	private HolderRepository repository;
	
	public List<Holder> findAll(){
		return repository.findAll();
		}
	
	public Holder findById(Long id) {
		Optional<Holder> obj = repository.findById(id);
		return obj.get();
	}
}
