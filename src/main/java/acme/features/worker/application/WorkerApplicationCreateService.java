package acme.features.worker.application;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application>{
	
	//Internal State
	
	protected WorkerApplicationRepository repository;
	
	//AbstractCreateService<Worker, Application> interface
	
	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		
		boolean result;
		int jobId;
		Job job;
		Date currentDate;
		
		jobId = request.getModel().getInteger("jobId");
		job = this.repository.findOneJobById(jobId);
		currentDate = new Date();
		result = job != null && job.isFinalMode() && job.getDeadline().after(currentDate);
		
		return result;
		
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors);
	}
	
	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "reference", "moment", "status", "statement", "skills", "qualifications");
		model.setAttribute("jobId", entity.getJob().getId());
	}
	
	@Override
	public Application instantiate(final Request<Application> request) {
		assert request !=null;
		
		Application result; Worker worker;
		Job job;			String reference;
		Date moment;		Calendar calendar;
		
		worker = this.repository.findWorkerById(request.getPrincipal().getActiveRoleId());
		job = this.repository.findOneJobById(request.getModel().getInteger("jobId"));
		reference = UUID.randomUUID().toString();
		
		moment = new Date();
		calendar = Calendar.getInstance();
		calendar.setTime(moment); calendar.add(Calendar.SECOND, -1);
		moment.getTime();
		
		result = new Application();
		result.setReference(reference); result.setMoment(moment);
		result.setStatus(ApplicationStatus.PENDING);
		result.setStatement(""); result.setSkills(worker.getSkills());
		result.setQualifications(worker.getQualifications()); result.setJob(job);
		result.setWorker(worker);
		
		return result;
	}
	
	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}
	
	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;
		
		Date moment;
		Calendar calendar;
		
		moment=new Date();
		calendar = Calendar.getInstance();
		calendar.setTime(moment);
		calendar.add(Calendar.SECOND, -1);
		moment=calendar.getTime();
		
		entity.setMoment(moment);
		this.repository.save(entity);
	}
	
}
