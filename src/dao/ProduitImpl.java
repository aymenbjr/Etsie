package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import entities.Client;
import entities.Commande;
import entities.Produit; 

public class ProduitImpl implements IProduit {

	@Override
	public List<Produit> ListProduit() {
		List<Produit> cmd = new ArrayList();
		Connection conn=DBconnect.getConnection();
		
		try {
			PreparedStatement st=conn.prepareStatement("select * from produit");
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				Produit c=new Produit();
				c.setNumPro(rs.getInt("numPro"));
				c.setpuProd(rs.getDouble("puProd"));
				c.setNomPro(rs.getString("nomPro"));
				c.setFamPro(rs.getInt("famPro"));
				cmd.add(c);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cmd;
	}

	@Override
	public List<Produit> ListProduitFamille(String catalogue_famille) {
		List<Produit> cmd = new ArrayList();
		Connection conn=DBconnect.getConnection();
		
		try {
			PreparedStatement st=conn.prepareStatement("select * from produit where famPro = ?");
			int cat_fam = Integer.parseInt(catalogue_famille);
			st.setInt(1, cat_fam);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				Produit c=new Produit();
				c.setNumPro(rs.getInt("numPro"));
				c.setpuProd(rs.getDouble("puProd"));
				c.setNomPro(rs.getString("nomPro"));
				c.setFamPro(rs.getInt("famPro"));
				cmd.add(c);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cmd;
	}

	@Override
	public Produit getProduit(int idProduit) {
		Produit c=new Produit();
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("select * from produit where numPro=?");
			st.setInt(1, idProduit);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				c.setNumPro(idProduit); 
				c.setpuProd(rs.getDouble("puProd"));
				c.setNomPro(rs.getString("nomPro"));
				c.setFamPro(rs.getInt("famPro"));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public void addProduit(Produit nouveauProduit) {
		Connection conn=DBconnect.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("insert into produit values (NULL,?,?,?)");
			
			st.setDouble(1, nouveauProduit.getpuProd());
			st.setString(2, nouveauProduit.getNomPro());
			st.setInt(3, nouveauProduit.getFamPro());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void supprimerProd(int idd) {
		try{
		Connection conn = DBconnect.getConnection();
		PreparedStatement st = conn.prepareStatement("DELETE FROM produit WHERE numPro = ?");
		st.setInt(1, idd);
		st.executeUpdate();
		st.close();
	}catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	}

	@Override
	public void editProduit(Produit nouveauProduit) {
		Connection conn=DBconnect.getConnection(); 
		try {
			PreparedStatement st=conn.prepareStatement("UPDATE produit SET puProd = ? , nomPro = ? , famPro = ? where numPro = ?");
			st.setDouble(1, nouveauProduit.getpuProd());
			st.setString(2, nouveauProduit.getNomPro());
			st.setInt(3, nouveauProduit.getFamPro());
			st.setInt(4, nouveauProduit.getNumPro());
			st.executeUpdate();
			st.close();
			}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<Produit> ListParRech(String recherche) {

		List<Produit> reise= new ArrayList();
		Connection conn = DBconnect.getConnection();
		PreparedStatement st;
		Produit c = new Produit();
		try{
		st = conn.prepareStatement("select * from Produit where nomPro like ?");
		st.setString(1,'%' + recherche + '%');
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			
			c.setNumPro(rs.getInt("numPro")); 
			c.setpuProd(rs.getDouble("puProd"));
			c.setNomPro(rs.getString("nomPro"));
			c.setFamPro(rs.getInt("famPro"));
			reise.add(c);
		}
		st.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return reise;
	}

	

}
