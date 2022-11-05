package it.prova.gestionebigliettiweb.service;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;

public interface BigliettoService {
	// questo mi serve per injection
		public void setBigliettoDAO(BigliettoDAO bigliettoDAO);
}
