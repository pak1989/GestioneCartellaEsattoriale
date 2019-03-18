package it.prova.gescaresa.dao.utente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import it.prova.gescaresa.model.Ruolo;
import it.prova.gescaresa.model.Utente;

@Component
public class UtenteDAOImpl implements UtenteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> list() {
		return entityManager.createQuery("from Utente").getResultList();
	}

	@Override
	public Utente get(long id) {
		Utente result = (Utente) entityManager.find(Utente.class, id);
		return result;
	}

	@Override
	public void update(Utente utenteInstance) {
		utenteInstance = entityManager.merge(utenteInstance);
	}

	@Override
	public void insert(Utente utenteInstance) {
		entityManager.persist(utenteInstance);
	}

	@Override
	public void delete(Utente utenteInstance) {
		entityManager.remove(entityManager.merge(utenteInstance));
	}

	@Override
	public List<Utente> findByExample(Utente utenteInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente executeLogin(String username, String password) {
		Query query = entityManager
				.createQuery("SELECT u FROM Utente u WHERE u.username = :usernameParam and u.password= :passwordParam");
		query.setParameter("usernameParam", username);
		query.setParameter("passwordParam", password);

		return query.getResultList().isEmpty() ? null : (Utente) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> findByAllByAttribute(Utente utenteInstance) {
		Query query;
		String domandaAlDb = "SELECT DISTINCT u FROM Utente u JOIN u.ruoli r WHERE u.id = u.id";

		if (StringUtils.isNotEmpty(utenteInstance.getNome())) {
			domandaAlDb += " AND u.nome like '" + utenteInstance.getNome() + "'";
		}
		if (StringUtils.isNotEmpty(utenteInstance.getCognome())) {
			domandaAlDb += " AND u.cognome like '" + utenteInstance.getCognome() + "'";
		}
		if (StringUtils.isNotEmpty(utenteInstance.getUsername())) {
			domandaAlDb += " AND u.username like '" + utenteInstance.getUsername() + "'";
		}
//		if (StringUtils.isNotEmpty(utenteInstance.getPassword())) {
//			domandaAlDb += " AND u.password like '" + utenteInstance.getPassword() + "'";
//		}
		System.out.println("SONO QUA");
		System.out.println(utenteInstance.getDataRegistrazione());
		if (utenteInstance.getDataRegistrazione() != null) {
			domandaAlDb += (" AND u.dataRegistrazione > '" + new java.sql.Date(utenteInstance.getDataRegistrazione().getTime()) + "'");
		}
		List<Long> ids = new ArrayList<Long>();
		if(!utenteInstance.getRuoli().isEmpty()) {
			for (Ruolo ruoloItem : utenteInstance.getRuoli()) {
				ids.add(ruoloItem.getId());
			}
			domandaAlDb += " AND r.id IN :idRuoli ";
		}
		query = entityManager.createQuery(domandaAlDb);
		
		if(!ids.isEmpty())
			query.setParameter("idRuoli", ids);
		
		return (List<Utente>) query.getResultList();
	}

}
