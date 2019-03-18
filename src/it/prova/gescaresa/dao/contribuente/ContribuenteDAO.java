package it.prova.gescaresa.dao.contribuente;

import java.util.List;

import it.prova.gescaresa.dao.IBaseDAO;
import it.prova.gescaresa.model.Contribuente;

public interface ContribuenteDAO extends IBaseDAO<Contribuente> {
	
	public List<Contribuente> listNotLazy();
	
	public Contribuente getNotLazy(long id);
	
	public List<Contribuente> findByAllByAttribute(Contribuente contribuenteInstance, String etaInput);
	
//	public List<Contribuente> findAllByMunicipio(Long idMunicipio);

}
