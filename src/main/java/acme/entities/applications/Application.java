package acme.entities.applications;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import acme.entities.jobs.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends DomainEntity {
	
	//Serialisation identifier
	
		protected static final long serialVersionUID = 1L;
		
		//Attributes
		@Column(unique=true)
		@NotBlank
		@Length(min = 5, max = 10)
		protected String reference;
		
		@NotBlank
		protected String statement;
		
		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		@Past
		protected Date moment;
		
		@NotNull
		protected ApplicationStatus status;
		
		@NotBlank		
		protected String skills;
		
		@NotBlank
		protected String qualifications;
	

		//Relationships
		@NotNull
		@Valid
		@ManyToOne(optional = false)
		protected Job job;
		
		@NotNull
		@Valid
		@ManyToOne(optional = false)
		protected Worker worker;
		
	}



