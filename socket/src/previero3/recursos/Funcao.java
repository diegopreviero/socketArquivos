package previero3.recursos;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import previero4.objetos.InfoCliente;

public class Funcao implements Serializable {

	private static final long serialVersionUID = 1L;

	public Funcao() { }

	int index;
	String nome;
	String parametro1;
	String parametro2;
	Vector<Arquivo> arquivo;
	InfoCliente info;

	public Funcao(int index, String nome, String parametro1, String parametro2, Vector<Arquivo> arquivo) {
		super();
		this.index = index;
		this.nome = nome;
		this.parametro1 = parametro1;
		this.parametro2 = parametro2;
		this.arquivo = arquivo;
	}
	
	public Funcao(int index, String nome, InfoCliente info) {
		super();
		this.index = index;
		this.nome = nome;
		this.info = info;
	}

	public void teste(){

		long inicio = System.currentTimeMillis();
		for (Arquivo arq : arquivo) {

			//			ClientTransfer cliente = new ClientTransfer(arq.origem, arq.destino);
			//			cliente.getFileFromServeR();

			try {
				new previero3.multi.Cliente("SERVER", 1024, arq.origem, arq.destino).start();	
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

		}


		JOptionPane.showMessageDialog(null, "Envio Terminado!: "
				+ ((System.currentTimeMillis()-inicio)/1000) + " segundos");
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