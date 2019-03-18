package it.prova.gescaresa.dao.cartellaesattoriale;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.prova.gescaresa.model.CartellaEsattoriale;

@Component
public class CartellaEsattorialeDAOImpl implements CartellaEsattorialeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> list() {
		return entityManager.createQuery("from CartellaEsattoriale").getResultList();
	}

	@Override
	public CartellaEsattoriale get(long id) {
		CartellaEsattoriale result = (CartellaEsattoriale) entityManager.find(CartellaEsattoriale.class, id);
		return result;
	}

	@Override
	public void update(CartellaEsattoriale cartellaEsattorialeInstance) {
		cartellaEsattorialeInstance = entityManager.merge(cartellaEsattorialeInstance);
	}

	@Override
	public void insert(CartellaEsattoriale cartellaEsattorialeInstance) {
		entityManager.persist(cartellaEsattorialeInstance);
	}

	@Override
	public void delete(CartellaEsattoriale cartellaEsattorialeInstance) {
		entityManager.remove(entityManager.merge(cartellaEsattorialeInstance));
		System.out.println("Cartella eliminata");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale cartellaEsattorialeInstance) {
		Session session = (Session) entityManager.getDelegate();
		Example cartellaEsattorialeExample = Example.create(cartellaEsattorialeInstance).excludeZeroes();
		Criteria criteria = session.createCriteria(CartellaEsattoriale.class).add(cartellaEsattorialeExample);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> findAllByDescrizioneILike(String term) {
		term = term != null ? term.toLowerCase() : "";
		Query query = entityManager.createQuery(
				"select caresa FROM CartellaEsattoriale caresa where lower(caresa.descrizione) like :termInput ");
		query.setParameter("termInput", '%' + term + '%');

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> findByAllByAttribute(CartellaEsattoriale cartellaInstance, String importoInput) {

		String query = "SELECT car FROM CartellaEsattoriale car JOIN car.contribuente con WHERE 1 = 1";

		int importo = 0;
		
		if (cartellaInstance.getContribuente() != null && cartellaInstance.getContribuente().getId() > 0) {
			query += " AND con.id='" + cartellaInstance.getContribuente().getId() + "'";
		}
		if (!(cartellaInstance.getDenominazione().equals("")) && cartellaInstance.getDenominazione() != null) {
			query += " AND car.denominazione LIKE '" + cartellaInstance.getDenominazione() + "'";
		}
		if (!(cartellaInstance.getDescrizione().equals("")) && cartellaInstance.getDescrizione() != null) {
			query += " AND car.descrizione LIKE '%" + cartellaInstance.getDescrizione() + "%'";
		}
		if (!(importoInput.equals("")) && importoInput != null) {
			try {
				importo = Integer.parseInt(importoInput);
			} catch (NumberFormatException e) {
				
			}
			query += " AND car.importo= " + importo;
		}

		return (List<CartellaEsattoriale>) entityManager.createQuery(query).getResultList();
	}

}
