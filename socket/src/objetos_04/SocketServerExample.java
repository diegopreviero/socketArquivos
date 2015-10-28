package objetos_04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import objetos.*;
public class SocketServerExample {

	private static ServerSocket server;
	private static int port = 9876;

	public static void main(String args[]) throws IOException, ClassNotFoundException{
		server = new ServerSocket(port);
		Socket socket = server.accept();
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		Cachorro c = (Cachorro) ois.readObject();            
		JOptionPane.showMessageDialog(null, "Recebido: " + c.getRaca());
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject("From Server: " + c.getCor());
		ois.close();
		oos.close();
		socket.close();
		server.close();
	}
/*
	ObjectInputStream oi = new ObjectInputStream(conexao.getInputStream());
	<Cliente> c = (Vector<Cliente>) oi.readObject();
*/

}