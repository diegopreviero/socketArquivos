package anotacoes;

import java.util.Vector;

public class teste {

	public teste() {}

	public static void main(String[] args) {
		
		Vector<Arquivo> v = new Vector<Arquivo>();
		v.add(new Arquivo("um","","",1));
		v.add(new Arquivo("dois","","",2));
		v.add(new Arquivo("tres","","",3));
		
		Funcao f = new Funcao( 1, "teste", "par1", "par2", v );
		
		f.teste();
		
//		for (Arquivo arq : f.arquivo) {
//			System.out.println("index: " + f.index + " - nome: " + f.nome + " - par1: " + f.parametro1 + " - par2: " + f.parametro2);
//			System.out.println("raiz: " +arq.raiz + " - origem: " + arq.origem + " - destino: " + arq.destino + " - tamanho: " + arq.tamanho + "\n*********\n");
//		}
		
	}

}
