package objetos_04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class SocketClientExample {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		Cachorro c = new Cachorro();
		c.setRaca("vira lata");
		c.setCor("preta");

		socket = new Socket(host.getHostName(), 9876);
		oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(c);
		ois = new ObjectInputStream(socket.getInputStream());
		String message = (String) ois.readObject();
		JOptionPane.showMessageDialog(null, message);
		ois.close();
		oos.close();
		socket.close();
	}
}