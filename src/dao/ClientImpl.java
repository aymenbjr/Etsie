package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Client;

public class ClientImpl implements IClient {

	@Override
	public void addClient(Client c) {
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("insert into client values (NULL,?,?,?,?)");
			st.setString(1, c.getNomCli());
			st.setString(2, c.getPrenomCli());
			st.setString(3, c.getAdrCli());
			st.setString(4, c.getPass());
			
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public Client getClient(String id_c) {
		Client c=null;
		Connection conn=DBconnect.getConnection();
		int idd=Integer.parseInt(id_c);
		try {
			PreparedStatement st=conn.prepareStatement("select * from Client where numCli=?");
			st.setInt(1, idd);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				c.setNumCli(idd);
				c.setNomCli(rs.getString("nomCli"));
				c.setPrenomCli(rs.getString("prenomCli"));
				c.setAdrCli(rs.getString("adrCli"));
				c.setPass(rs.getString("pass"));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public boolean login(String nom, String mdp) {
		Connection conn=DBconnect.getConnection();
		boolean b=false;
		try {
			PreparedStatement st=conn.prepareStatement("select pass from Client where nomCli=?");
			st.setString(1, nom);
		ResultSet rs=st.executeQuery();
		
		if(rs.next() && rs.getString("pass").equals(mdp)){
			b=true;
		}
		
	}catch (SQLException e) {
	}
		return b;
	}

	@Override
	public Client getClient(String nom, String mdp) {
		Connection conn=DBconnect.getConnection();
		Client c=new Client();
		try {
			PreparedStatement st=conn.prepareStatement("select * from Client where nomCli=? and pass=?");
			st.setString(1, nom);
			st.setString(2, mdp);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				c.setNumCli(rs.getInt("numCli"));
				c.setNomCli(nom);
				c.setPrenomCli(rs.getString("prenomCli"));
				c.setAdrCli(rs.getString("adrCli"));
				c.setPass(mdp);
			}
			st.close();
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return c;
}

}
