package it.prova.gescaresa.service.cartellaesattoriale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gescaresa.dao.cartellaesattoriale.CartellaEsattorialeDAO;
import it.prova.gescaresa.model.CartellaEsattoriale;

@Component
public class CartellaEsattorialeServiceImpl implements CartellaEsattorialeService {

	@Autowired
	private CartellaEsattorialeDAO cartellaEsattorialeDAO;

	@Transactional(readOnly=true)
	public List<CartellaEsattoriale> listAllCartelleEsattoriali() {
			return cartellaEsattorialeDAO.list();
	}

	@Transactional(readOnly=true)
	public CartellaEsattoriale caricaSingolaCartellaEsattoriale(long id) {
			return cartellaEsattorialeDAO.get(id);
	}

	@Transactional
	public void aggiorna(CartellaEsattoriale cartellaEsattorialeInstance) {
			cartellaEsattorialeDAO.update(cartellaEsattorialeInstance);
	}

	@Transactional
	public void inserisciNuova(CartellaEsattoriale cartellaEsattorialeInstance) {
			cartellaEsattorialeDAO.insert(cartellaEsattorialeInstance);
	}

	@Transactional
	public void rimuovi(CartellaEsattoriale cartellaEsattorialeInstance) {
			cartellaEsattorialeDAO.delete(cartellaEsattorialeInstance);
	}

	@Transactional(readOnly=true)
	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale example) {
			return cartellaEsattorialeDAO.findByExample(example);
	}

	@Transactional(readOnly=true)
	public List<CartellaEsattoriale> cercaByDescrizioneILike(String term) {
		return cartellaEsattorialeDAO.findAllByDescrizioneILike(term);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CartellaEsattoriale> trovaByAllByAttribute(CartellaEsattoriale cartellaInstance, String importoInput) {
		return cartellaEsattorialeDAO.findByAllByAttribute(cartellaInstance, importoInput);
	}

}
