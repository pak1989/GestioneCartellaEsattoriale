package it.prova.gescaresa.service.contribuente;

import java.util.List;

import it.prova.gescaresa.model.Contribuente;

public interface ContribuenteService {
	
	public List<Contribuente> listAllContribuenti();

	public List<Contribuente> listAllContribuentiConCartelleEsattoriali();

	public Contribuente caricaSingoloContribuente(long id);

	public Contribuente caricaSingoloContribuenteConCartelleEsattoriali(long id);

	public void aggiorna(Contribuente contribuenteInstance);

	public void inserisciNuovo(Contribuente contribuenteInstance);

	public void rimuovi(Contribuente contribuenteInstance);

	public List<Contribuente> findByExample(Contribuente example);
	
	public List<Contribuente> trovaAllByAttribute(Contribuente contribuenteInstance, String etaInput);
	
//	public List<Contribuente> cercaAbitantiInMunicipio(Long idMunicipio);
	
}
