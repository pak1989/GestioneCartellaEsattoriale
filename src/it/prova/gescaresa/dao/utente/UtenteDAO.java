package it.prova.gescaresa.dao.utente;

import java.util.List;

import it.prova.gescaresa.dao.IBaseDAO;
import it.prova.gescaresa.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	public Utente executeLogin(String username,String password);
	
	public List<Utente> findByAllByAttribute(Utente utenteInstance);
}
