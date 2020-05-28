package entities;

public class Client {
	
	private int numCli;
	private String nomCli;
	private String prenomCli;
	private String adrCli;
	private String pass;
	public int getNumCli() {
		return numCli;
	}
	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}
	public String getNomCli() {
		return nomCli;
	}
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	public String getPrenomCli() {
		return prenomCli;
	}
	public void setPrenomCli(String prenomCli) {
		this.prenomCli = prenomCli;
	}
	public String getAdrCli() {
		return adrCli;
	}
	public void setAdrCli(String adrCli) {
		this.adrCli = adrCli;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Client [numCli=" + numCli + ", nomCli=" + nomCli
				+ ", prenomCli=" + prenomCli + ", adrCli=" + adrCli + ", pass="
				+ pass + "]";
	}
	public Client(int numCli, String nomCli, String prenomCli, String adrCli,
			String pass) {
		super();
		this.numCli = numCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.adrCli = adrCli;
		this.pass = pass;
	}
	public Client( String nomCli, String prenomCli, String adrCli,
			String pass) {
		super(); 
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.adrCli = adrCli;
		this.pass = pass;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
