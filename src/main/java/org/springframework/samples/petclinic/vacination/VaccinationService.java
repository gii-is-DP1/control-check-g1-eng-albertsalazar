package org.springframework.samples.petclinic.vacination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VaccinationService {
	@Autowired
	VaccinationRepository vaccinationRepo;
    public List<Vaccination> getAll(){
        return vaccinationRepo.findAll();
    }

    public List<Vaccine> getAllVaccines(){
        return null;
    }

    public Vaccine getVaccine(String typeName) {
        return vaccinationRepo.findVaccineByName(typeName);
    }

    public Vaccination save(Vaccination p) throws UnfeasibleVaccinationException {
        if(p.getVaccinatedPet().getId() != p.getVaccine().getId()) {
        	throw new UnfeasibleVaccinationException();
        }else {
        	return vaccinationRepo.save(p);
        }
    	
    }
    
    
}
