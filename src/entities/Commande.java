package entities;

public class Commande {

	private int numCde;
	private String dateCde;
	public int getNumCde() {
		return numCde;
	}
	public void setNumCde(int numCde) {
		this.numCde = numCde;
	}
	public String getDateCde() {
		return dateCde;
	}
	public void setDateCde(String dateCde) {
		this.dateCde = dateCde;
	}
	@Override
	public String toString() {
		return "Commande [numCde=" + numCde + ", dateCde=" + dateCde + "]";
	}
	public Commande(int numCde, String dateCde) {
		super();
		this.numCde = numCde;
		this.dateCde = dateCde;
	}
	
	public Commande( String dateCde) {
		super(); 
		this.dateCde = dateCde;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
