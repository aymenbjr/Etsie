package dao;

import java.util.List;

import entities.Produit;

public interface IProduit {
	public List<Produit> ListProduit();
	public List<Produit> ListProduitFamille(String catalogue_famille);
	public Produit getProduit(int idProduit);
	public void addProduit(Produit nouveauProduit);
	public void supprimerProd(int idd);
	public void editProduit(Produit nouveauProduit);
	public List<Produit> ListParRech(String recherche);

}
