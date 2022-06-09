package it.prova.gestionesocieta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.SocietaRepository;

@Service
public class SocietaServiceImpl implements SocietaService {

	@Autowired
	private SocietaRepository societaRepository;

	@Transactional
	public void inserisciNuovo(Societa societaInstance) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void rimuovi(Societa societaInstance) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(readOnly = true)
	public List<Societa> findByExample(Societa example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Societa> almenoUnDipendenteConRAL() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
