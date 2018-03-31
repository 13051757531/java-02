package www.wujianbothree.woniuatm;

public class UserData {
	private String namnes;
	private String passes;
	private double balances;
	
	
	
	
	public String getNamnes() {
		return namnes;
	}
	public void setNamnes(String namnes) {
		this.namnes = namnes;
	}
	public String getPasses() {
		return passes;
	}
	public void setPasses(String passes) {
		this.passes = passes;
	}
	public double getBalances() {
		return balances;
	}
	public void setBalances(double balances) {
		this.balances = balances;
	}
	
	public UserData() {
		// TODO Auto-generated constructor stub
	}
	
	public UserData(String name, String pass, Double balance) {
		// TODO Auto-generated constructor stub
		this.namnes= name;
		this.passes= pass;
		this.balances= balance;
	}
	
	
	
	
	
	
	
	

}
