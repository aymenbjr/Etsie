package entities;

public class Produit {
	
	private int numPro;
	private Double puProd;
	private String nomPro;
	private int famPro;
	public int getNumPro() {
		return numPro;
	}
	public void setNumPro(int numPro) {
		this.numPro = numPro;
	}
	public Double getpuProd() {
		return puProd;
	}
	public void setpuProd(Double puProd) {
		this.puProd = puProd;
	}
	public String getNomPro() {
		return nomPro;
	}
	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
	}
	public int getFamPro() {
		return famPro;
	}
	public void setFamPro(int famPro) {
		this.famPro = famPro;
	}
	@Override
	public String toString() {
		return "Produit [numPro=" + numPro + ", puProd=" + puProd + ", nomPro="
				+ nomPro + ", famPro=" + famPro + "]";
	}
	public Produit(int numPro, Double puProd, String nomPro, int famPro) {
		super();
		this.numPro = numPro;
		this.puProd = puProd;
		this.nomPro = nomPro;
		this.famPro = famPro;
	}
	
	public Produit( Double puProd, String nomPro, int famPro) {
		super(); 
		this.puProd = puProd;
		this.nomPro = nomPro;
		this.famPro = famPro;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
