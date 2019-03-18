package it.prova.gescaresa.service.contribuente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gescaresa.dao.contribuente.ContribuenteDAO;
import it.prova.gescaresa.model.Contribuente;

@Component
public class ContribuenteServiceImpl implements ContribuenteService {

	@Autowired
	private ContribuenteDAO contribuenteDAO;

	@Transactional(readOnly = true)
	public List<Contribuente> listAllContribuenti() {

		return contribuenteDAO.list();
	}

	@Transactional(readOnly = true)
	public List<Contribuente> listAllContribuentiConCartelleEsattoriali() {
		return contribuenteDAO.listNotLazy();
	}

	@Transactional(readOnly = true)
	public Contribuente caricaSingoloContribuente(long id) {
		return contribuenteDAO.get(id);
	}

	@Transactional(readOnly = true)
	public Contribuente caricaSingoloContribuenteConCartelleEsattoriali(long id) {
		return contribuenteDAO.getNotLazy(id);
	}

	@Transactional
	public void aggiorna(Contribuente contribuenteInstance) {
		contribuenteDAO.update(contribuenteInstance);
	}

	@Transactional
	public void inserisciNuovo(Contribuente contribuenteInstance) {
		contribuenteDAO.insert(contribuenteInstance);
	}

	@Transactional
	public void rimuovi(Contribuente contribuenteInstance) {
		contribuenteDAO.delete(contribuenteInstance);
	}

	@Transactional(readOnly = true)
	public List<Contribuente> findByExample(Contribuente example) {
		return contribuenteDAO.findByExample(example);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contribuente> trovaAllByAttribute(Contribuente contribuenteInstance, String etaInput) {
			return contribuenteDAO.findByAllByAttribute( contribuenteInstance, etaInput);
	}

//	@Override
//	public List<Contribuente> cercaAbitantiInMunicipio(Long idMunicipio) {
//			return contribuenteDAO.findAllByMunicipio(idMunicipio);
//	}

}
