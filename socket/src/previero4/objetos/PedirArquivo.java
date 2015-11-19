package previero4.objetos;

import java.io.File;
import java.util.List;
import java.util.Vector;

public class PedirArquivo extends Thread {

	String origem;
	String destino;

	public PedirArquivo(String origem, String destino) {

		super();
		this.origem = origem;
		this.destino = destino;

	}

	public void run(){

		System.out.println("run");
		try {
			Vector<Arquivo> v = new Vector<Arquivo>();
			Funcao f = new Funcao( 3, "Pedir Arquivo", "", "", v );
			List<File> arq2 = f.buscaRecursiva(new File(origem), "");
			String prefixo = origem.substring(0,origem.lastIndexOf("/")+1);

			for (File arq : arq2){
				String ori = arq.getAbsolutePath().replace("\\", "/");

				v.add(new Arquivo("", ori, destino + ori.substring(prefixo.length(),
						ori.length()), arq.length() ));
			}

			f.teste();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}