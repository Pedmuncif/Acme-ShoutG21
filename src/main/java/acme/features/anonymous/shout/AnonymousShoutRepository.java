package acme.features.anonymous.shout;

import java.util.Collection;
import acme.entities.shouts;

import org.springframework.data.jpa.repository.Query;

import acme.framework.repositories.AbstractRepository;

public interface AnonymousShoutRepository extends AbstractRepository{
	
	@Query("select s from Shout s")
	Collection<Shout> findMany();

}

