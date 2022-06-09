package it.prova.gestionesocieta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.gestionesocieta.model.Societa;

public interface SocietaRepository extends CrudRepository<Societa, Long> {
	
	@Query(value = "select distinct * from societa s left join dipendente d "
			+ "on s.id = d.societa_id where d.reddito_annuo_lordo > 30000",nativeQuery = true)
	List<Societa> atLeastAnEmployeeWithRAL();
	
}
