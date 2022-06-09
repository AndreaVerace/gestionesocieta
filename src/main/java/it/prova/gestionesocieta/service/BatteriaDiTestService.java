package it.prova.gestionesocieta.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionesocieta.model.Dipendente;
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
	
	
	public void testInserisciNuovoDipendente() {
		try {
			Date dataFondazione = new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-12");
			Societa solvingTeam = new Societa("Solving Team","Via Mosca 52",dataFondazione);
			
			if(solvingTeam.getId() != null)
				throw new RuntimeException("testInserisciNuovaSocieta...failed: transient object con id valorizzato");
			
			societaService.inserisciNuovo(solvingTeam);
			
			
			Date dataAssunzione = new SimpleDateFormat("yyyy-MM-dd").parse("2000-08-08");
			Dipendente dipendenteSolvingTeam = new Dipendente("Jack","Bonaventura",dataAssunzione,50000,solvingTeam);
			
			if(dipendenteSolvingTeam.getId() != null)
				throw new RuntimeException("testInserisciNuovoDipendente...failed: transient object con id valorizzato");

			dipendenteService.inserisciNuovo(dipendenteSolvingTeam);
			
			if(dipendenteSolvingTeam.getId() == null || dipendenteSolvingTeam.getId() < 1)
				throw new RuntimeException("testInserisciNuovoDipendente...failed: inserimento fallito");

			System.out.println(dipendenteSolvingTeam);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testAggiornaDipendente() {
		try {
			Date dataFondazione = new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-12");
			Societa solvingTeam = new Societa("Solving Team","Via Mosca 52",dataFondazione);
			
			if(solvingTeam.getId() != null)
				throw new RuntimeException("testInserisciNuovaSocieta...failed: transient object con id valorizzato");
			
			societaService.inserisciNuovo(solvingTeam);
			
			
			Date dataAssunzione = new SimpleDateFormat("yyyy-MM-dd").parse("2000-08-08");
			Dipendente dipendenteSolvingTeam = new Dipendente("Jack","Bonaventura",dataAssunzione,50000,solvingTeam);
			
			if(dipendenteSolvingTeam.getId() != null)
				throw new RuntimeException("testInserisciNuovoDipendente...failed: transient object con id valorizzato");

			dipendenteService.inserisciNuovo(dipendenteSolvingTeam);
			
			System.out.println(dipendenteSolvingTeam);
			
			dipendenteSolvingTeam.setNome("Jack dopo modifica");
			dipendenteSolvingTeam.setCognome("Bonaventura dopo modifica");
			dipendenteSolvingTeam.setRedditoAnnuoLordo(100000);
			
			dipendenteService.aggiorna(dipendenteSolvingTeam);
			
			System.out.println(dipendenteSolvingTeam);
			
		}  catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testDipendentePiuAnziano() {
		try {
			Date dataFondazione = new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-12");
			Societa solvingTeam = new Societa("Solving Team","Via Mosca 52",dataFondazione);
			societaService.inserisciNuovo(solvingTeam);
			
			Date dataAssunzione = new SimpleDateFormat("yyyy-MM-dd").parse("2000-08-08");
			Dipendente dipendenteSolvingTeam = new Dipendente("Jack","Bonaventura",dataAssunzione,50000,solvingTeam);
			dipendenteService.inserisciNuovo(dipendenteSolvingTeam);
			
			Date dataFondazioneDue = new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-12");
			Societa illianoGroup = new Societa("Illiano s.r.l.","Via Prati 152",dataFondazioneDue);
			societaService.inserisciNuovo(solvingTeam);
			societaService.inserisciNuovo(illianoGroup);
			
			Date dataAssunzioneDue = new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-08");
			Dipendente dipendenteIllianoGroup = new Dipendente("Marco","Frollini",dataAssunzioneDue,50000,illianoGroup);
			dipendenteService.inserisciNuovo(dipendenteIllianoGroup);
			
			
			Dipendente result = dipendenteService.piuAnzianoDelleSocietaDopo1990();
			System.out.println(result.getNome() + " " + result.getCognome() 
			+ " " + result.getRedditoAnnuoLordo() + " " + result.getDataAssunzione());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testSocietaConDipendenteRAL() {
		try {
			Date dataFondazione = new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-12");
			Societa solvingTeam = new Societa("Solving Team","Via Mosca 52",dataFondazione);
			societaService.inserisciNuovo(solvingTeam);
			
			Date dataAssunzione = new SimpleDateFormat("yyyy-MM-dd").parse("2000-08-08");
			Dipendente dipendenteSolvingTeam = new Dipendente("Jack","Bonaventura",dataAssunzione,50000,solvingTeam);
			dipendenteService.inserisciNuovo(dipendenteSolvingTeam);
			
			Date dataFondazioneDue = new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-12");
			Societa illianoGroup = new Societa("Illiano s.r.l.","Via Prati 152",dataFondazioneDue);
			societaService.inserisciNuovo(solvingTeam);
			societaService.inserisciNuovo(illianoGroup);
			
			Date dataAssunzioneDue = new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-08");
			Dipendente dipendenteIllianoGroup = new Dipendente("Marco","Frollini",dataAssunzioneDue,50000,illianoGroup);
			dipendenteService.inserisciNuovo(dipendenteIllianoGroup);
			
			// inserisco dipendente di una terza società con RAL < 30.000
			Date dataFondazioneTre = new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-12");
			Societa macari = new Societa("Macari","Via Berlino 02",dataFondazioneTre);
			societaService.inserisciNuovo(macari);
			
			Date dataAssunzioneTre = new SimpleDateFormat("yyyy-MM-dd").parse("2000-08-08");
			Dipendente dipendenteMacari = new Dipendente("fabio","Macari",dataAssunzioneTre,10000,macari);
			dipendenteService.inserisciNuovo(dipendenteMacari);
			
			List<Societa> result = societaService.almenoUnDipendenteConRAL();
			
			for(Societa societa : result)
				System.out.println(societa.getRagioneSociale() + " "
						+ societa.getIndirizzo() + " "
						+ societa.getDataFondazione());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
