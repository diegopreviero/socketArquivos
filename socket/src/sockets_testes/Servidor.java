package sockets_testes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Servidor {

	private ServerSocket server;
	private Socket socket;
	private InputStream entrada;
	private BufferedReader read;

	public Servidor() {
		
		while (true){
		try {
			server = new ServerSocket(606);            

			System.out.println("Servidor aguardando conexao.");

			socket = server.accept();

			entrada = socket.getInputStream();
			read = new BufferedReader(new InputStreamReader(entrada));

			//System.out.println(read.readLine());
			JOptionPane.showMessageDialog(null, read.readLine());

			read.close();
			socket.close();
			server.close();            

		} catch (IOException ex) {
			ex.printStackTrace();
		}   
		}
		
	}

	public static void main(String[] args) {
		new Servidor();
	}

}