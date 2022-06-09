package it.prova.gestionesocieta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.gestionesocieta.model.Societa;

public interface SocietaRepository extends CrudRepository<Societa, Long> {
	/*
	@Query("select distinct s from Societa s left join s.dipendenti d where d.reddito_annuo_lordo"
			+ " >= 30000")
	List<Societa> atLeastAnEmployeeWithRAL();
	*/
}
