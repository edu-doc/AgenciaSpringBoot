package com.bank.agency.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.agency.entities.Holder;
import com.bank.agency.services.HolderService;

@RestController
@RequestMapping(value = "/holders")
public class HolderResource {
	
	@Autowired
	private HolderService service;
	
	@GetMapping
	public ResponseEntity<List<Holder>> findAll(){
		List<Holder> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Holder> findById(@PathVariable Long id){
		Holder obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
