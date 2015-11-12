package previero3.recursos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import previero3.ClientTransfer;

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

		long inicio = System.currentTimeMillis();
		for (Arquivo arq : arquivo) {
			/*System.out.println("index: " + index + "\nnome: " + nome + "\npar1: " + parametro1 + "\npar2: " + parametro2);
					System.out.println("raiz: " +arq.raiz + "\norigem: " + arq.origem + "\ndestino: " + arq.destino +
							"\ntamanho: " + arq.tamanho + ""
									+ " bytes\n**********************************************\n");*/

			/*ClientTransfer cliente = new ClientTransfer(arq.origem, arq.destino);
			cliente.getFileFromServeR();*/
			
			try {
				new previero3.multi.Cliente("SERVER",1024 ,arq.origem, arq.destino).start();	
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			

		}


		JOptionPane.showMessageDialog(null, "Envio Terminado!: " + ((System.currentTimeMillis()-inicio)/1000) + " segundos");
	}

	public List<File> buscaRecursiva(File pasta, String ext) {
		List<File> resultados = new ArrayList<File>();
		for (File f : pasta.listFiles()) {
			if (f.isDirectory()) {
				resultados.addAll(buscaRecursiva(f, ext));
			} else if (f.getName().endsWith(ext)) {
				resultados.add(f);
			}
		}
		return resultados;
	}
}
