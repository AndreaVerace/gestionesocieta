package it.prova.gestionesocieta.service;

import java.util.List;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;

public interface DipendenteService {
	
	public void aggiorna(Dipendente dipendenteInstance);
	
	public void inserisciNuovo(Dipendente dipendenteInstance);
	
	public Dipendente piuAnzianoDelleSocietaDopo1990();
	
}
