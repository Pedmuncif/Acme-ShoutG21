package acme.entities.tasks;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(max=80)
	protected String title;
	
	@NotBlank
	@Size(max=500)
	protected String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected Date startMoment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected Date finishMoment;
	
	@NotNull
	@Digits(integer=3,fraction=2)
	protected Double workload;
	
	@URL
	protected String link;
	
	@NotNull
	protected TaskStatus status;
}
