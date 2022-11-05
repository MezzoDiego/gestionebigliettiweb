package it.prova.gestionebigliettiweb.service;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;

public class BigliettoServiceImpl implements BigliettoService{

	private BigliettoDAO bigliettoDAO;
	
	@Override
	public void setBigliettoDAO(BigliettoDAO bigliettoDAO) {
		this.bigliettoDAO = bigliettoDAO;
		
	}

}
