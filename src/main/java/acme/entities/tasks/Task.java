package acme.entities.tasks;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task extends DomainEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Length(max=80)
	protected String title;
	
	@NotBlank
	@Length(max=500)
	protected String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date startMoment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finishMoment;
	
	@NotNull
	@Digits(integer=3,fraction=2)
	protected Double workload;
	
	@URL
	protected String link;
	
	@NotNull
	protected Boolean status;
}
