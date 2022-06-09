package it.prova.gestionesocieta.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	public void testRimuoviSocieta() {
		try {
			Date dataFondazione = new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-12");
			Societa solvingTeamDaRimuovere = new Societa("Solving Team","Via Mosca 52",dataFondazione);
			
			if(solvingTeamDaRimuovere.getId() != null)
				throw new RuntimeException("testInserisciNuovaSocieta...failed: transient object con id valorizzato");
			
			societaService.inserisciNuovo(solvingTeamDaRimuovere);
			if(solvingTeamDaRimuovere.getId() != null) {
				System.out.println("Inserimento effettuato");
			}
			
			societaService.rimuovi(solvingTeamDaRimuovere);
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public void testFindByExampleSocieta() {
		try {
			Date dataFondazione = new SimpleDateFormat("yyyy-MM-dd").parse("1980-11-11");
			Societa illianoGroup = new Societa("Illiano Group","Via Piotti 52",dataFondazione);
			
			if(illianoGroup.getId() != null)
				throw new RuntimeException("testInserisciNuovaSocieta...failed: transient object con id valorizzato");
			
			societaService.inserisciNuovo(illianoGroup);
			
			Date dataFondazioneDue = new SimpleDateFormat("yyyy-MM-dd").parse("1980-11-11");
			Societa illianoGroupDaCercare = new Societa("liano","Pio",dataFondazioneDue);
			List<Societa> result = societaService.findByExample(illianoGroupDaCercare);
			
			for(Societa societa : result) {
				System.out.println(societa.getRagioneSociale() + " " + societa.getIndirizzo());			
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
}
