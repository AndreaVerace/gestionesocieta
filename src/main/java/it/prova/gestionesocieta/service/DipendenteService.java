package it.prova.gestionesocieta.service;

import java.util.List;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;

public interface DipendenteService {

	public void aggiorna(Societa abitanteInstance);

	public void inserisciNuovo(Societa abitanteInstance);
	
	public List<Dipendente> piuAnzianoDelleSocietaDopo1990();
	
}
