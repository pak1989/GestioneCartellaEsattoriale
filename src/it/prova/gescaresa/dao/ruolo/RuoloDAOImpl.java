package it.prova.gescaresa.dao.ruolo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.prova.gescaresa.model.Ruolo;

@Component
public class RuoloDAOImpl implements RuoloDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ruolo> list() {
		return entityManager.createQuery("from Ruolo").getResultList();
	}

	@Override
	public Ruolo get(long id) {
		Ruolo result = (Ruolo) entityManager.find(Ruolo.class, id);
		return result;
	}

	@Override
	public void update(Ruolo ruoloInstance) {
		ruoloInstance = entityManager.merge(ruoloInstance);

	}

	@Override
	public void insert(Ruolo ruoloInstance) {
		entityManager.persist(ruoloInstance);
	}

	@Override
	public void delete(Ruolo ruoloInstance) {
		entityManager.remove(entityManager.merge(ruoloInstance));
	}

	@Override
	public List<Ruolo> findByExample(Ruolo ruoloInstance) {
		// TODO Auto-generated method stub
		return null;
	}

}
