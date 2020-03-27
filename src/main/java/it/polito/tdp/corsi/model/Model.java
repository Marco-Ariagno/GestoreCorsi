package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private CorsoDAO dao;
	
	public Model() {
		dao=new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(int pd){
		return dao.getCorsiByPeriodo(pd);
		
		//CorsoDAO gestisce interazione con il DB
		//Model richiama dao per fornire dati al controller
	}
	
	public Map<Corso,Integer> getIscrittiByPeriodo(int pd){
		return dao.getIscrittiByPeriodo(pd);
	}

}
