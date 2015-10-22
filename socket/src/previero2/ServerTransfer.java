package previero2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerTransfer {
	public static void main(String[] args) {

		ServerTransfer server = new ServerTransfer();
		server.waitForClient();

	}


	public void waitForClient() {
		OutputStream socketOut = null;
		ServerSocket servsock = null;
		FileInputStream fileIn = null;

		InputStream entrada;
		BufferedReader read;
		String origem = "";

		while (true){

			try {
				servsock = new ServerSocket(13267);

				System.out.println("Porta de conexao aberta 13267");

				Socket sock = servsock.accept();
				System.out.println("Conexao recebida pelo cliente");

				/**************************************/

				entrada = sock.getInputStream();
				read = new BufferedReader(new InputStreamReader(entrada));
				//JOptionPane.showMessageDialog(null, read.readLine());
				origem = read.readLine();

				/**************************************/

				byte[] cbuffer = new byte[1024];
				int bytesRead;

				String arquivo = origem;
				//String arquivo = "e:/socket/teste/3x4.bmp";
				File file = new File(arquivo);//de:
				fileIn = new FileInputStream(file);
				System.out.println("Lendo arquivo...");

				socketOut = sock.getOutputStream();

				System.out.println("Enviando Arquivo...");
				while ((bytesRead = fileIn.read(cbuffer)) != -1) {
					socketOut.write(cbuffer, 0, bytesRead);
					socketOut.flush();
				}

				System.out.println("Arquivo Enviado!");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (socketOut != null) {
					try {
						socketOut.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (servsock != null) {
					try {
						servsock.close();
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
			}
		}
	}
}