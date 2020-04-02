package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {

	private CorsoDAO dao;

	public Model() {
		dao = new CorsoDAO();
	}

	public boolean esisteCorso(String codins) {
		return dao.esisteCorso(codins);
	}

	public List<Corso> getCorsiByPeriodo(int pd) {
		return dao.getCorsiByPeriodo(pd);

		// CorsoDAO gestisce interazione con il DB
		// Model richiama dao per fornire dati al controller
	}

	public Map<Corso, Integer> getIscrittiByPeriodo(int pd) {
		return dao.getIscrittiByPeriodo(pd);
	}

	public List<Studente> getStudentiByCorso(Corso c) {
		return dao.getStudentiByCorso(c);
	}

	public Map<String, Integer> getDivisioneCDS(Corso c) {
		List<Studente> studenti = dao.getStudentiByCorso(c);

		Map<String, Integer> statistiche = new HashMap<String, Integer>();
		/*for (Studente s : studenti) {
			if (!s.getCDS().equals(null) && !s.getCDS().equals("")) {
				if (statistiche.containsKey(s.getCDS())) {
					statistiche.put(s.getCDS(), statistiche.get(s.getCDS()) + 1);
				} else {
					statistiche.put(s.getCDS(), 1);
				}
			}
		}
		return statistiche;*/
		return dao.getDivisioneCDS(c);
	}

}
