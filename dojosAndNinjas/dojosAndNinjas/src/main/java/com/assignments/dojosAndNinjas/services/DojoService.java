package com.assignments.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.dojosAndNinjas.models.Dojo;
import com.assignments.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}

	//return all dojos
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	//create a dojo
	public Dojo createDojo(Dojo dojo) {
        return dojoRepo.save(dojo);
    }
	
	// retrieves a Dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
	
	//update dojo through languages controller
    public Dojo updateLanguage(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
    
    // Deletes a Language by using language id
    public void deleteDojo(Long id) {
    	dojoRepo.deleteById(id);
    	
    }
    
    
	
	

}