package com.jaden.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.jaden.dojosandninjas.models.Ninja;
import com.jaden.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
 
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}

	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
	    	return optionalNinja.get();
	    }
		else {
	    	return null;
	    }
	}
	
	public void deleteNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			ninjaRepository.deleteById(id);
	    }
	}
	
	public Ninja updateNinja(@Valid Ninja ninja) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(ninja.getId());
		if(optionalNinja.isPresent()) {
	    	Ninja newNinja = optionalNinja.get();
	    	newNinja.setFirstName(ninja.getFirstName());
	    	newNinja.setLastName(ninja.getLastName());
	    	newNinja.setAge(ninja.getAge());
	    	newNinja.setDojo(ninja.getDojo());
	    	return ninjaRepository.save(newNinja);
	    }
		else {
	    	return null;
	    }
	}
}

