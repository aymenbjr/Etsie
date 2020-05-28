package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Commande;
import entities.Produit;

public class CommandeImpl implements ICommande {

	@Override
	public List<Commande> ListCommande() {
		List<Commande> cmd = new ArrayList();
		Connection conn=DBconnect.getConnection();
		
		try {
			PreparedStatement st=conn.prepareStatement("select * from commande");
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				Commande c=new Commande();
				c.setNumCde(rs.getInt("numCde"));
				c.setDateCde(rs.getString("dateCde"));
				cmd.add(c);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cmd;
	}

	@Override
	public void addCommande(Commande c) {
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("insert into commande values (NULL,?)");
			
			st.setString(1, c.getDateCde());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
