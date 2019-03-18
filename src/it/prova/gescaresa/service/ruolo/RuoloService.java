package it.prova.gescaresa.service.ruolo;

import java.util.List;

import it.prova.gescaresa.model.Ruolo;

public interface RuoloService {
	
	public List<Ruolo> listAllRuoli() ;

	public Ruolo caricaSingoloRuolo(long id);

	public void aggiorna(Ruolo utenteInstance);

	public void inserisciNuovo(Ruolo utenteInstance);

	public void rimuovi(Ruolo utenteInstance);

	public List<Ruolo> findByExample(Ruolo example);
	
}
