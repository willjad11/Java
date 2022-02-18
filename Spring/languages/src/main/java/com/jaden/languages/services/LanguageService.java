package com.jaden.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.jaden.languages.models.Language;
import com.jaden.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
 
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}

	public Language createLanguage(Language b) {
		return languageRepository.save(b);
	}

	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
	    	return optionalLanguage.get();
	    }
		else {
	    	return null;
	    }
	}
	
	public void deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			languageRepository.deleteById(id);
	    }
	}
	
	public Language updateLanguage(@Valid Language language) {
		Optional<Language> optionalLanguage = languageRepository.findById(language.getId());
		if(optionalLanguage.isPresent()) {
	    	Language newLanguage = optionalLanguage.get();
	    	newLanguage.setName(language.getName());
	    	newLanguage.setName(language.getName());
	    	newLanguage.setCreator(language.getCreator());
	    	newLanguage.setVersion(language.getVersion());
	    	return languageRepository.save(newLanguage);
	    }
		else {
	    	return null;
	    }
	}
}

