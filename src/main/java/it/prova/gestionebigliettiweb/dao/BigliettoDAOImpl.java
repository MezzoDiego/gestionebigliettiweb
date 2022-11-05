package it.prova.gestionebigliettiweb.dao;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.EntityManager;

import it.prova.gestionebigliettiweb.model.Biglietto;

public class BigliettoDAOImpl implements BigliettoDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Biglietto> list() throws Exception {
		return entityManager.createQuery("from Biglietto", Biglietto.class).getResultList();
	}

	@Override
	public Biglietto findOne(Long id) throws Exception {
		return entityManager.find(Biglietto.class, id);
	}

	@Override
	public void update(Biglietto input) throws Exception {
		if (input == null)
			throw new RuntimeException("Problema valore in input");

		entityManager.merge(input);

	}

	@Override
	public void insert(Biglietto input) throws Exception {
		if (input == null)
			throw new RuntimeException("Problema valore in input");

		entityManager.persist(input);

	}

	@Override
	public void delete(Biglietto input) throws Exception {
		if (input == null)
			throw new RuntimeException("Problema valore in input");

		entityManager.remove(entityManager.merge(input));

	}

	@Override
	public List<Biglietto> search(Biglietto input) throws Exception {
		String query = "from Biglietto where 1=1";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		if (!(input.getProvenienza().isEmpty()))
			query += " and provenienza like '" + input.getProvenienza() + "%'";
		if (!(input.getDestinazione().isEmpty()))
			query += " and destinazione like '" + input.getDestinazione() + "%'";
		if (input.getData() != null)
			query += " and date(data) = '" + dateFormat.format(new java.sql.Date(input.getData().getTime())) + "'";
		if (input.getPrezzo() != null)
			query += " and prezzo = " + input.getPrezzo();

		return entityManager.createQuery(query, Biglietto.class).getResultList();
	}

}
