package previero4.objetos;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Funcao implements Serializable {

	private static final long serialVersionUID = 1L;

	public Funcao() { }

	public Funcao(int index, String nome, String parametro1, String parametro2, Vector<Arquivo> arquivo) {
		super();
		this.index = index;
		this.descricao = nome;
		this.parametro1 = parametro1;
		this.parametro2 = parametro2;
		this.arquivo = arquivo;
	}

	public Funcao(int index, String nome, InfoCliente info) {
		super();
		this.index = index;
		this.descricao = nome;
		this.info = info;
	}

	int index;
	String descricao;
	String serverName = "SERVER";
	int serverPort = 1024;
	String parametro1;
	String parametro2;
	Vector<Arquivo> arquivo;
	InfoCliente info;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
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

	public InfoCliente getInfo() {
		return info;
	}

	public void setInfo(InfoCliente info) {
		this.info = info;
	}

	public void teste(){

		long inicio = System.currentTimeMillis();
		for (Arquivo arq : arquivo) {

			try {
				new previero4.Cliente("SERVER", 1024, arq.origem, arq.destino).start();	
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