package objetos_02;
/*
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Vector;

public class Server implements Runnable {

	public void run() {
		try {

			System.out.println("Iniciando o servidor");

			ServerSocket serverSocket = new ServerSocket(9999);

			Socket socket = serverSocket.accept();

			System.out.println("Client conectado");

			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

			System.out.println("Enviando lista de coisas");
			outputStream.writeObject(getThingVector());

			outputStream.close();
			serverSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Vector<Thing> getThingVector() {
		Vector<Thing> things = new Vector<Main.Thing>();
		for (int i = 0; i < 100; i++) {
			things.add(new Thing(i, "Thing" + i, new Date()));
		}

		return things;
	}

}*/
