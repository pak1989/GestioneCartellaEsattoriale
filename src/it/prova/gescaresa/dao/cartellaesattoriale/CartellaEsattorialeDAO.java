package it.prova.gescaresa.dao.cartellaesattoriale;

import java.util.List;

import it.prova.gescaresa.dao.IBaseDAO;
import it.prova.gescaresa.model.CartellaEsattoriale;

public interface CartellaEsattorialeDAO extends IBaseDAO<CartellaEsattoriale> {

	public List<CartellaEsattoriale> findAllByDescrizioneILike(String term);
	
	public List<CartellaEsattoriale> findByAllByAttribute(CartellaEsattoriale cartellaInstance, String importoInput);

}
