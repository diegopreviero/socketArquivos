package previero4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import previero4.objetos.CriarDiretorios;
import previero4.objetos.Funcao;

public class Cliente extends Thread {

	private String server;
	private int porta;
	//public static int i ;
	String origem;
	String destino;
	Funcao funcao;

	public Cliente(Funcao funcao){
		this.funcao = funcao;
		this.server = funcao.getServerName();
		this.porta = funcao.getServerPort();
	}

	public Cliente(String server, int porta, String origem, String destino) {
		this.server = server;
		this.porta = porta;
		this.origem = origem;
		this.destino = destino;
	}
	
	public Cliente(String server, int porta, String origem, String destino, Funcao funcao) {
		this.server = server;
		this.porta = porta;
		this.origem = origem;
		this.destino = destino;
		this.funcao = funcao;
	}

	public void run() {

		Socket s = null;
		FileOutputStream fos = null;
		InputStream is = null;

		try {

			System.out.println("Conectando com Servidor porta 13267");

			s = new Socket(server, porta);
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;

			oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(funcao);
			ois = new ObjectInputStream(s.getInputStream());
			String message = (String) ois.readObject();

			if (message.equals("arquivo")){
				JOptionPane.showMessageDialog(null, message);
			}else{
				JOptionPane.showMessageDialog(null, "Outro:" + message);
			}

			ois.close();//atencao
			oos.close();
			//s.close();//copiado para antes do catch

			if(funcao.getIndex() == 3){

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
			}
			
			s.close();

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
