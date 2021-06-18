package com.assignments.languages.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.assignments.languages.models.Language;
import com.assignments.languages.repositories.*;

@Service                                                                                    
public class LanguageService {                                                              
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	// returns all the Languages
    public List<Language> allLanguages() {
        return languageRepo.findAll();    
    }
    
    // creates a language
    public Language createLanguage(Language lang) {
        return languageRepo.save(lang);
    }
    
    // retrieves a Language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepo.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    // Deletes a Language by using language id
    public void deleteLanguage(Long id) {
    	languageRepo.deleteById(id);
    	
    }
    
    //update language using Api
    public Language updateLanguageApi(Long id, String name, String creator, Double currentVersion) {
    	
    	Language language;
    	
    	Optional<Language> optionalLanguage = languageRepo.findById(id);
        if(optionalLanguage.isPresent()) {
            language = optionalLanguage.get();
        } else {
            return null;
        }
        
        language.setName(name);
        language.setCreator(creator);
        language.setCurrentVersion(currentVersion);
        languageRepo.save(language);      
        
        return language;   
        
    }
    
    //update language through languages controller
    public Language updateLanguage(Language language) {
		return languageRepo.save(language);
	}
    
    
}
