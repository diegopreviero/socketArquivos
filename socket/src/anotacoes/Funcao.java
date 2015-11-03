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

	public void teste(){
		for (Arquivo arq : arquivo) {
			System.out.println("index: " + index + " - nome: " + nome + " - par1: " + parametro1 + " - par2: " + parametro2);
			System.out.println("raiz: " +arq.raiz + " - origem: " + arq.origem + " - destino: " + arq.destino + " - tamanho: " + arq.tamanho + "\n*********\n");
		}
	}

}
