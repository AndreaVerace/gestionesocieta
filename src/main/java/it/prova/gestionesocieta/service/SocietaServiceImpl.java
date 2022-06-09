package it.prova.gestionesocieta.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionesocieta.exception.SocietaConDipendentiException;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.SocietaRepository;

@Service
public class SocietaServiceImpl implements SocietaService {

	@Autowired
	private SocietaRepository societaRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void inserisciNuovo(Societa societaInstance) {
		societaRepository.save(societaInstance);
		
	}
	
	@Transactional
	public void rimuovi(Societa societaInstance) {
		if(!societaInstance.getDipendenti().isEmpty()) {
			throw new SocietaConDipendentiException("Impossibile eliminare società con dipendenti a carico");
		}
		else {
			societaRepository.delete(societaInstance);
		}
	}
	/*
	@Transactional(readOnly = true)
	public List<Societa> findByExample(Societa example) {
		String query = "select s from Societa s where s.id=s.id";
		
		if (StringUtils.isNotEmpty(example.getRagioneSociale())){
			query += " and s.ragionesociale like '%" + example.getRagioneSociale() + "%' ";
		}
		if(StringUtils.isNotEmpty(example.getIndirizzo())) {
			query += " and s.indirizzo like '%" + example.getIndirizzo() + "%' ";
		}
		if(example.getDataFondazione() != null) {
			query += " and s.datafondazione = '" + example.getDataFondazione() + "'";  
		}
		
		return entityManager.createQuery(query, Societa.class).getResultList();
		
	}

	

	@Override
	public List<Societa> almenoUnDipendenteConRAL() {
		return societaRepository.atLeastAnEmployeeWithRAL();
	}
	*/
}
