package it.prova.gestionebigliettiweb.dao;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
