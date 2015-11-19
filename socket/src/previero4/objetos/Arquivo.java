package previero4.objetos;

public class Arquivo {

	public Arquivo() { }

	String raiz;
	String origem;
	String destino;
	long tamanho;
	
	public Arquivo(String raiz, String origem, String destino, long tamanho) {
		super();
		this.raiz = raiz;
		this.origem = origem;
		this.destino = destino;
		this.tamanho = tamanho;
	}

	public String getRaiz() {
		return raiz;
	}

	public void setRaiz(String raiz) {
		this.raiz = raiz;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public long getTamanho() {
		return tamanho;
	}

	public void setTamanho(long tamanho) {
		this.tamanho = tamanho;
	}
	
	
}
