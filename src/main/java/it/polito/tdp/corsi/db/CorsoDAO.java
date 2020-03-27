package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {
	
	public List<Corso> getCorsiByPeriodo(int pd){
		String sql="SELECT * FROM corso WHERE pd = ?";
		List<Corso> result= new ArrayList<>();
		
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, pd);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				Corso c= new Corso(rs.getString("codins"), rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				result.add(c);
			}
			
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		
		return result;
		
	}

	
	public Map<Corso,Integer> getIscrittiByPeriodo(int pd){
		String sql="SELECT c.codins, c.nome, c.crediti, c.pd, COUNT(*) as tot FROM corso as c, iscrizione i where c.codins=i.codins and c.pd =? group by c.codins, c.nome, c.crediti, c.pd";
		Map<Corso,Integer> result= new HashMap<>();
		
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, pd);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				Corso c= new Corso(rs.getString("codins"), rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				int n= rs.getInt("tot");
				result.put(c, n);
			}
			
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		
		return result;
		
	}

}
