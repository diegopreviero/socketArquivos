package previero4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import objetos_04.Cachorro;

public class Servidor implements Runnable {

	ServerSocket ss;

	public Servidor(int porta) throws Exception {

		ss = new ServerSocket(porta);
		new Thread(this).start();
		System.out.println("Servidor ouvindo na porta:" + porta);

	}

	public void run() {
		try {
			while (true) {
				new TrataCliente(ss.accept()).start();
				System.out.println("Mais um cliente atendido!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		try {
			new Servidor(1024);

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}

class TrataCliente extends Thread {

	private Socket client;

	public TrataCliente(Socket s) {
		client = s;
	}

	public void run() {

		OutputStream socketOut = null;
		FileInputStream fileIn = null;

		InputStream entrada;
		BufferedReader read;
		String origem;

		try {
			System.out.println("Porta de conexao aberta 1024");
			System.out.println("Conexao recebida pelo cliente");
			
			


			ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
			Cachorro c = (Cachorro) ois.readObject();            
			JOptionPane.showMessageDialog(null, "Recebido: " + c.getRaca());
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			oos.writeObject("From Server: " + c.getCor());
			ois.close();
			oos.close();
			client.close();
			client.close();
			
			

			//**************************************
//			entrada = client.getInputStream();
//			read = new BufferedReader(new InputStreamReader(entrada));
//			origem = read.readLine();
			//**************************************

		/*	byte[] cbuffer = new byte[1024];
			int bytesRead;

			File file = new File(origem);
			fileIn = new FileInputStream(file);
			System.out.println("Lendo arquivo...");

			socketOut = client.getOutputStream();

			System.out.println("Enviando Arquivo...");
			while ((bytesRead = fileIn.read(cbuffer)) != -1) {
				socketOut.write(cbuffer, 0, bytesRead);
				socketOut.flush();
			}

			System.out.println("Arquivo Enviado!");
			client.close();*/
		} catch (Exception e) {
			e.printStackTrace();
		}/* finally {
			if (socketOut != null) {
				try {
					socketOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fileIn != null) {
				try {
					fileIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
		
		

	}
}