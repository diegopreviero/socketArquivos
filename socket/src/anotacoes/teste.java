package anotacoes;

import java.io.File;
import java.util.List;
import java.util.Vector;

public class teste {

	public teste() {}

	public static void main(String[] args) {

		try {
			Vector<Arquivo> v = new Vector<Arquivo>();
			Funcao f = new Funcao( 1, "Pedir Arquivo", "", "", v );
			List<File> arq2 = f.buscaRecursiva(new File("/home/khaemhat/kiko"), "");

			for (File arq : arq2){
				v.add(new Arquivo("", arq.getAbsolutePath(), "", arq.length() ));
			}

			f.teste();			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
