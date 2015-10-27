package objetos_02;
/*
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		new Thread(new Server()).start();
		new Thread(new Client()).start();
	}

	static class Client implements Runnable {

		public void run() {

			try {

				System.out.println("Inciando o cliente");

				Socket socket = new Socket("localhost", 9999);
				ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

				System.out.println("Recebendo lista de coisas");
				Vector<Thing> things = (Vector<Thing>) inputStream.readObject();
				for (Thing thing : things) {
					System.out.println(thing);
				}

				socket.close();

			} catch (Exception e) {
				e.printStackTrace();
			}


		}
	}



}*/