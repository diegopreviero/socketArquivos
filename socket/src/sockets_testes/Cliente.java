package sockets_testes;

import java.io.*;
import java.net.*;

public class Cliente {

	public Cliente() {}

	public static void main(String[] args) {
		try {

			Socket socket = new Socket("127.0.0.1", 606);

			OutputStream saida = socket.getOutputStream();            
			PrintStream escrita = new PrintStream(saida);

			if(args.length > 0) {
				escrita.println(args[0]);

			} else {
				escrita.println("previero...");
			} 

		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}