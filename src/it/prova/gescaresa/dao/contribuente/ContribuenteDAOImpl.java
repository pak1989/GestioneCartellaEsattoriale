package it.prova.gescaresa.dao.contribuente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.prova.gescaresa.model.Contribuente;

@Component
public class ContribuenteDAOImpl implements ContribuenteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Contribuente> list() {
		return entityManager.createQuery("from Contribuente").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contribuente> listNotLazy() {
		return entityManager.createQuery("from Contribuente con JOIN FETCH con.cartelleEsattoriali").getResultList();
	}

	@Override
	public Contribuente get(long id) {
		return (Contribuente) entityManager.find(Contribuente.class, id);
	}

	@Override
	public Contribuente getNotLazy(long id) {
		return (Contribuente) entityManager
				.createQuery("from Contribuente con LEFT JOIN FETCH con.cartelleEsattoriali WHERE con.id = :id")
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public void update(Contribuente contribuenteInstance) {
		contribuenteInstance = entityManager.merge(contribuenteInstance);
	}

	@Override
	public void insert(Contribuente contribuenteInstance) {
		entityManager.persist(contribuenteInstance);
	}

	@Override
	public void delete(Contribuente contribuenteInstance) {
		entityManager.remove(entityManager.merge(contribuenteInstance));
	}

	// @SuppressWarnings("unchecked")
	@Override
	public List<Contribuente> findByExample(Contribuente contribuenteInstance) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contribuente> findByAllByAttribute(Contribuente contribuenteInstance, String etaInput) {

		String query = "SELECT con FROM Contribuente con WHERE 1 = 1";

		int eta = 0;

		if (!(contribuenteInstance.getNome().equals("")) && contribuenteInstance.getNome() != null) {
			query += " AND con.nome like '" + contribuenteInstance.getNome() + "'";
		}
		if (!(contribuenteInstance.getCognome().equals("")) && contribuenteInstance.getCognome() != null) {
			query += " AND con.cognome like '" + contribuenteInstance.getCognome() + "'";
		}
		if (!(etaInput.equals("")) && etaInput != null) {
			try {
				eta = Integer.parseInt(etaInput);
			} catch (NumberFormatException e) {

			}
			query += " AND con.eta= " + eta;
		}
		if (!(contribuenteInstance.getResidenza().equals("")) && contribuenteInstance.getResidenza() != null) {
			query += " AND con.residenza like '" + contribuenteInstance.getResidenza() + "'";
		}

		return (List<Contribuente>) entityManager.createQuery(query).getResultList();
	}

}
