package it.prova.gestionesocieta.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.DipendenteRepository;

@Service
public class DipendenteServiceImpl implements DipendenteService {

	@Autowired
	private DipendenteRepository dipendenteRepository;

	@Transactional
	public void aggiorna(Societa abitanteInstance) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void inserisciNuovo(Societa abitanteInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dipendente> piuAnzianoDelleSocietaDopo1990() {
		// TODO Auto-generated method stub
		return null;
	}
	
}