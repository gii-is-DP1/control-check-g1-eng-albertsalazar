package org.springframework.samples.petclinic.vacination;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vaccination extends BaseEntity  {
	@Id
	Integer id;
	@NotNull
	@Column(name = "vaccination_date") 
	@DateTimeFormat(pattern = "yyyy/MM/dd")
    LocalDate date;
	
    @NotNull
    @ManyToOne
    @JoinColumn(name="vaccinated_pet_id")
    Pet vaccinatedPet;   
    
    @ManyToOne
    @JoinColumn(name="vaccine_id")
    Vaccine vaccine; 
    
}
