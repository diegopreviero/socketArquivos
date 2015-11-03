package anotacoes;

import java.util.Vector;

public class Funcao {

	public Funcao() { }
	
	int index;
	String nome;
	String parametro1;
	String parametro2;
	Vector<Arquivo> arquivo;
	
	public Funcao(int index, String nome, String parametro1, String parametro2, Vector<Arquivo> arquivo) {
		super();
		this.index = index;
		this.nome = nome;
		this.parametro1 = parametro1;
		this.parametro2 = parametro2;
		this.arquivo = arquivo;
	}

	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParametro1() {
		return parametro1;
	}

	public void setParametro1(String parametro1) {
		this.parametro1 = parametro1;
	}

	public String getParametro2() {
		return parametro2;
	}

	public void setParametro2(String parametro2) {
		this.parametro2 = parametro2;
	}

	public Vector<Arquivo> getArquivo() {
		return arquivo;
	}

	public void setArquivo(Vector<Arquivo> arquivo) {
		this.arquivo = arquivo;
	}

}
