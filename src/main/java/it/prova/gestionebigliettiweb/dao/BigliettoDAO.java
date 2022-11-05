package it.prova.gestionebigliettiweb.dao;

import java.util.List;

import it.prova.gestionebigliettiweb.model.Biglietto;

public interface BigliettoDAO extends IBaseDAO<Biglietto>{
	public List<Biglietto> search(Biglietto input) throws Exception;
}
