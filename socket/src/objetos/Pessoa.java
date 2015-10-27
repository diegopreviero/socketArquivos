package objetos;

public class Pessoa implements java.io.Serializable{

	private static final long serialVersionUID = -127162188099576900L;

	public Pessoa() {
		
	}
	
	String nome;
	int idade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString(){
		return getNome() + " " + getIdade();
	}

}
