package com.jaden.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.jaden.dojosandninjas.models.Dojo;
import com.jaden.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
 
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
	    	return optionalDojo.get();
	    }
		else {
	    	return null;
	    }
	}
	
	public void deleteDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			dojoRepository.deleteById(id);
	    }
	}
	
	public Dojo updateDojo(@Valid Dojo dojo) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(dojo.getId());
		if(optionalDojo.isPresent()) {
	    	Dojo newDojo = optionalDojo.get();
	    	newDojo.setName(dojo.getName());
	    	newDojo.setLocation(dojo.getLocation());
	    	return dojoRepository.save(newDojo);
	    }
		else {
	    	return null;
	    }
	}
}
