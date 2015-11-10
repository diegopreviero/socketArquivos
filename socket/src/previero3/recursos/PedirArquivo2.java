package previero3.recursos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class PedirArquivo2 extends Thread{

	String origem;
	String destino;

	public PedirArquivo2(String origem, String destino) {
		super();
		this.origem = origem;
		this.destino = destino;
	}

	public void run(){
		try {

			Socket sockServer = null;
			FileOutputStream fos = null;
			InputStream is = null;

			try {

				System.out.println("Conectando com Servidor porta 13267");
				sockServer = new Socket("SERVER", 13267);

				/***************************/
				OutputStream saida = sockServer.getOutputStream();            
				PrintStream escrita = new PrintStream(saida);
				escrita.println(origem);
				/**************************/


				is = sockServer.getInputStream();

				new CriarDiretorios(destino);

				fos = new FileOutputStream(new File(destino));
				System.out.println("Arquivo Local Criado: " + destino);

				byte[] cbuffer = new byte[1024];
				int bytesRead;

				System.out.println("Recebendo arquivo...");
				while ((bytesRead = is.read(cbuffer)) != -1) {
					fos.write(cbuffer, 0, bytesRead);
					fos.flush();
				}

				System.out.println("Arquivo recebido!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sockServer != null) {
					try {
						sockServer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				if (is != null) {
					try {
						is.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}


		} catch (Exception e) {

		}
	}
}