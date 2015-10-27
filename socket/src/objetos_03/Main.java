package objetos_03;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
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

	static class Server implements Runnable {

		public void run() {
			try {
				
				System.out.println("Iniciando o servidor");
				
				ServerSocket serverSocket = new ServerSocket(999);

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

	}

	static class Thing implements Serializable {

		private static final long serialVersionUID = 7639521599393469721L;
	
		private int id;
		private String name;
		private Date creationDate;

		public Thing(int id, String name, Date creationDate) {
			this.id = id;
			this.name = name;
			this.creationDate = creationDate;
		}

		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		@Override
		public String toString() {
			return "Thing [id=" + id + ", name=" + name + ", creationDate=" + creationDate + "]";
		}
	}

}