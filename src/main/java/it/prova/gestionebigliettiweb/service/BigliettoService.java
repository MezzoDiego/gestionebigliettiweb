package it.prova.gestionebigliettiweb.service;

import java.util.List;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.model.Biglietto;

public interface BigliettoService {
	// questo mi serve per injection
		public void setBigliettoDAO(BigliettoDAO bigliettoDAO);
		public List<Biglietto> listAll() throws Exception;
		public void inserisciNuovo(Biglietto bigliettoInstance) throws Exception;
		public Biglietto caricaSingoloElemento(Long id) throws Exception;
		public void rimuovi(Long id) throws Exception;
}
