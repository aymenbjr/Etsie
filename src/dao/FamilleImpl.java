package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import entities.Famille;

public class FamilleImpl implements IFamille {

	@Override
	public List<Famille> ListFam() {
		List<Famille> cmd = new ArrayList();
		Connection conn=DBconnect.getConnection();
		
		try {
			PreparedStatement st=conn.prepareStatement("select * from famille");
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				Famille c=new Famille();;
				c.setNumFam(rs.getInt("numFam"));
				c.setNomFam(rs.getString("nomFam"));
				cmd.add(c);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cmd;
	}

}
