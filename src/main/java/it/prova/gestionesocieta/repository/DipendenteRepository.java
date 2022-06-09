package it.prova.gestionesocieta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.gestionesocieta.model.Dipendente;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long> {

	@Query(value = "SELECT * from dipendente left join societa on dipendente.societa_id=societa.id"
			+ " having societa.datafondazione < '1990-01-01' and MIN(dataassunzione)",nativeQuery = true)
	Dipendente olderInCompanyAfter1990();
	
}
