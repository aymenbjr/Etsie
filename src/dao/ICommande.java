package dao;

import java.util.List;

import entities.Commande;

public interface ICommande {
	public List<Commande> ListCommande();

	public void addCommande(Commande c);
}
