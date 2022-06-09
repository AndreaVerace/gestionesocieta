package it.prova.gestionesocieta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.gestionesocieta.model.Dipendente;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long> {
	/*
	@Query("select  d from Dipendente d left join d.societa s where s.datafondazione"
			+ " > '1990-01-01' and d.data")
	List<Dipendente> olderInCompanyAfter1990();
	*/
}
