package objetos;

public class Cachorro implements java.io.Serializable{

	private static final long serialVersionUID = -1236586072550055157L;

	public Cachorro() {

	}

	String raca;
	String cor;
	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String toString(){
		return getCor() + " " + getRaca();
	}

}
