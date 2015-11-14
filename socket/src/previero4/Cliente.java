package previero4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import previero3.recursos.CriarDiretorios;

public class Cliente extends Thread {

	private String server;
	private int porta;
	public static int i ;
	String origem;
	String destino;
	
	public Cliente(String server, int porta, String origem, String destino) {
		this.server = server;
		this.porta = porta;
		this.origem = origem;
		this.destino = destino;
	}

	public void run() {

		Socket s = null;
		FileOutputStream fos = null;
		InputStream is = null;

		try {
			
			System.out.println("Conectando com Servidor porta 13267");
			//sockServer = new Socket("SERVER", 13267);
			s = new Socket(server, porta);
			//sockServer = new Socket("SERVER", 1024);
			//sockServer = new Socket("192.168.0.102", 13267);
			
			/***************************/
			OutputStream saida = s.getOutputStream();            
			PrintStream escrita = new PrintStream(saida);
			escrita.println(origem);
			/**************************/
			
			is = s.getInputStream();

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
			
			Thread.sleep(2000);
			s.close();
			System.out.println("Arquivo recebido!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				try {
					s.close();
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
		
	}
}
