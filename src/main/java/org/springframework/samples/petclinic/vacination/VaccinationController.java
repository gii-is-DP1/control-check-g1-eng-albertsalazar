package org.springframework.samples.petclinic.vacination;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vaccination")
public class VaccinationController {
    @Autowired
    VaccinationService vaccinationService;
    @Autowired
    PetService petService;
    @GetMapping(path="/create")
    public String creaFormulario(ModelMap modelMap) {
    	modelMap.addAttribute("vaccine",new Vaccination());
    	modelMap.addAttribute("pets", petService.findAllPets());
    	modelMap.addAttribute("vaccines", vaccinationService.getAllVaccines());
    	return "vaccination/createOrUpdateVaccinationForm";
    }
    @PostMapping(path="/create")
    public String creaVacuna(ModelMap modelMap, @Valid Vaccination v, BindingResult result) throws UnfeasibleVaccinationException {
    	if(result.hasErrors()) {
    		modelMap.addAttribute("vaccine",new Vaccination());
        	modelMap.addAttribute("pets", petService.findAllPets());
        	modelMap.addAttribute("vaccines", vaccinationService.getAllVaccines());
        	modelMap.addAttribute("message", "Error al crear la vacunacion, rellene correctamente los campos");
        	return "vaccination/createOrUpdateVaccinationForm";
    	}else {
    		modelMap.addAttribute("message", "Vacuna guardada correctamente");
    		vaccinationService.save(v);
    		return "welcome";
    	}
    	
    }
    
}
