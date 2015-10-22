package multi_Objetos;

import java.net.*;
import java.io.*;

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
		try {
			ObjectInputStream oi = new ObjectInputStream(client.getInputStream());
			System.out.println("Chegou isso:" + oi.readObject());

			client.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}