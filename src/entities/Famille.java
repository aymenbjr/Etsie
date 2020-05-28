package entities;

public class Famille {
	
	private int numFam;
	private String nomFam;
	public int getNumFam() {
		return numFam;
	}
	public void setNumFam(int numFam) {
		this.numFam = numFam;
	}
	public String getNomFam() {
		return nomFam;
	}
	public void setNomFam(String nomFam) {
		this.nomFam = nomFam;
	}
	@Override
	public String toString() {
		return "Famille [numFam=" + numFam + ", nomFam=" + nomFam + "]";
	}
	public Famille(int numFam, String nomFam) {
		super();
		this.numFam = numFam;
		this.nomFam = nomFam;
	}
	public Famille() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
