package it.prova.gescaresa.service.cartellaesattoriale;

import java.util.List;

import it.prova.gescaresa.model.CartellaEsattoriale;

public interface CartellaEsattorialeService {
	
	public List<CartellaEsattoriale> listAllCartelleEsattoriali() ;

	public CartellaEsattoriale caricaSingolaCartellaEsattoriale(long id);

	public void aggiorna(CartellaEsattoriale cartellaEsattorialeInstance);

	public void inserisciNuova(CartellaEsattoriale cartellaEsattorialeInstance);

	public void rimuovi(CartellaEsattoriale cartellaEsattorialeInstance);

	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale example);
	
	public List<CartellaEsattoriale> cercaByDescrizioneILike(String term);
	
	public List<CartellaEsattoriale> trovaByAllByAttribute(CartellaEsattoriale cartellaInstance, String importoInput);

}
