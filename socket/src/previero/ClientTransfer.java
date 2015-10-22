package previero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientTransfer {
	public static void main(String[] args) {

		//Criando Classe cliente para receber arquivo
		ClientTransfer cliente = new ClientTransfer();

		//Solicitando arquivo
		cliente.getFileFromServeR();
	}

	private void getFileFromServeR() {
		Socket sockServer = null;
		FileOutputStream fos = null;
		InputStream is = null;

		try {
			// Criando conexão com o servidor
			System.out.println("Conectando com Servidor porta 13267");
			sockServer = new Socket("SERVER", 13267);
			is = sockServer.getInputStream();

			// Cria arquivo local no cliente
			String arquivo = "e:/kiko/macaco/banana/churrasco/cebola/abobrinha/3x4.bmp";
			String diretorio = arquivo.substring(0, arquivo.lastIndexOf("/")+1);
			
			new CriarDiretorios(arquivo);

			fos = new FileOutputStream(new File(arquivo));//para:
			System.out.println("Arquivo Local Criado: " + arquivo);
			
			// Prepara variaveis para transferencia
			byte[] cbuffer = new byte[1024];
			int bytesRead;
			
			// Copia conteudo do canal
			System.out.println("Recebendo arquivo...");
			while ((bytesRead = is.read(cbuffer)) != -1) {
				fos.write(cbuffer, 0, bytesRead);
				fos.flush();
			}
			
			System.out.println("Arquivo recebido!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sockServer != null) {
				try {
					sockServer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
