package com.perl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.perl.demo.model.Champ;
import com.perl.demo.repository.champRepository;

public class champService {
	@Autowired
	champRepository champrepository;

	

	public Object save(Champ abcd) {		
		return champRepository.save() ;
	}

	public Object findById() {
		// TODO Auto-generated method stub
		 return champRepository.findById();
	}

}
