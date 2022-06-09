package it.prova.gestionesocieta.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionesocieta.model.Societa;

@Service
public class BatteriaDiTestService {

	@Autowired
	private SocietaService societaService;
	
	@Autowired
	private DipendenteService dipendenteService;
	
	public void testInserisciNuovaSocieta() {
		try {
			Date dataFondazione = new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-12");
			Societa solvingTeam = new Societa("Solving Team","Via Mosca 52",dataFondazione);
			
			if(solvingTeam.getId() != null)
				throw new RuntimeException("testInserisciNuovaSocieta...failed: transient object con id valorizzato");
			
			societaService.inserisciNuovo(solvingTeam);
			
			if(solvingTeam.getId() == null || solvingTeam.getId() < 1)
				throw new RuntimeException("testInserisciNuovaSocieta...failed: inserimento fallito");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
}
