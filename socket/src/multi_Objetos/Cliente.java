package multi_Objetos;

import java.net.*;
import java.io.*;

public class Cliente extends Thread {

	private String server;
	private int porta;
	private String texto;
	public static int i ;
	
	public Cliente(String server, int porta) {
		this.server = server;
		this.porta = porta;
	}

	public static void main(String[] args) {
		try {

			String server = "SERVER";
			int porta = 1024;
			int numeroDeClientes = 10;

			for (i = 0; i < numeroDeClientes; i++) {
				new Cliente(server, porta).start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {

			for (int x = 0; x < 5; x++){
				Socket s = new Socket(server, porta);
				ObjectOutputStream oo = new ObjectOutputStream(s.getOutputStream());
				System.out.println("Conectado a " + server + ":" + porta );
				oo.writeObject(getName());
				Thread.sleep(2000);
				s.close();
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
