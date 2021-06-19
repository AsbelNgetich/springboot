package com.assignments.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.dojosAndNinjas.models.Ninja;
import com.assignments.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;

	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	//return all ninjas
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	//create a ninja
	public Ninja createNinja(Ninja ninja) {
        return ninjaRepo.save(ninja);
    }
	
	// retrieves a Ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
	
	//update ninja through languages controller
    public Ninja updateLanguage(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
    
    // Deletes a Language by using language id
    public void deleteNinja(Long id) {
    	ninjaRepo.deleteById(id);
    	
    }
    
    
	
	

}