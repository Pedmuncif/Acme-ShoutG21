package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employer extends UserRole {
	
	//Serialisation identifier -------------------------------------
	
	protected static final long serialVersionUID = 1L;
	
	//Atributes ----------------------------------------------------
	
	@NotBlank
	protected String company;
	
	@NotBlank
	protected String sector;
	
	//Derived attributes -------------------------------------------
	
	//Relationships ------------------------------------------------
	
	

}
