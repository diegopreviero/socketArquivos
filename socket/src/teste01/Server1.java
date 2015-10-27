package teste01;

//FIg17.6 - server.java  
//configura um servidor que ira receber pacotes de um cliente e enviar-lhe pacotes  

import java.io.*;  
import java.net.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.util.*;  

import javax.swing.*;  

public class Server1 extends JFrame {  
	private JTextArea displayArea;  
	private DatagramPacket sendPacket, receivePacket;  
	private DatagramSocket socket;  

	public Server1() {  
		super("Server");  

		displayArea = new JTextArea();  
		getContentPane().add(new JScrollPane (displayArea), BorderLayout.CENTER);  
		setSize (400,300);  
		setVisible(true);  

		//cria DatagramSocket para enviar e receber pacotes  
		try  
		{  
			socket = new DatagramSocket(5000);  
		}  
		catch (SocketException socketException)  
		{  
			socketException.printStackTrace();  
			System.exit(1);  
		}  
	}  

	//espera que os pacotes cheguem e, depois, exibe os dados e ecoa o pacote p/ o cliente    
	public void waitForPackets() {  
		while (true) {  
			//recebe o pacote, exibe o conteudo e ecoa p/ o cliente  
			try {  
				byte data[] = new byte[100];  
				receivePacket = new DatagramPacket (data,data.length);  

				//espera o pacote  
				socket.receive (receivePacket);  

				//processa o pacote  
				displayPacket();  

				//ecoa as informacoes do pacote de volta p/ o cliente  
				sendPacketToClient();  
			}  
			catch (IOException ioException)  
			{  
				displayArea.append(ioException.toString() + "\n");  
				ioException.printStackTrace();  
			}  
		}  
	}  

	//exibe conteudo do pacote  
	private void displayPacket() {  

		//É aqui que os dados sao recebidos em bytes, convertidos p/ string e jogados nos  
		//seus campos pelo Token  
		String SNome="",SData="",SHora="";    
		String dados = new String(receivePacket.getData(),0,receivePacket.getLength());  
		String auxToken = "";  
		int iCont=0;  
		StringTokenizer tokens = new StringTokenizer(dados);  

		while (tokens.hasMoreTokens()) {  

			SNome = tokens.nextToken();  
			SData = tokens.nextToken();  
			SHora = tokens.nextToken();  

		}  
		displayArea.append("Nome: " + SNome +"\nData: " + SData + "\nHora: " + SHora);    

		/*displayArea.append("\n Packet received: " +  
                         "\nFrom host : " + receivePacket.getAddress() +  
                         "\nHost port : " + receivePacket.getPort() + 
                         "\nLength    : " + receivePacket.getLength() +  
                         "\nContaining: \n\t" + auxToken);*/  


	}  


	//ecoa pacote p/ o cliente  
	private void sendPacketToClient() throws IOException {  
		displayArea.append("\n\nEcho data to client...");  

		//cria pacote p/ enviar  
		/*sendPacket = new DatagramPacket(receivePacket.getData(), 
                                      receivePacket.getLength(), 
                                      receivePacket.getAddress(), 
                                      receivePacket.getPort()); 
      //envia o pacote 
      socket.send(sendPacket);*/  

		String message = "MENSAGEM ENTREGUE COM SUCESSO!!!";//event.getActionCommand();  
		byte data[] = message.getBytes();  
		sendPacket = new DatagramPacket(data,data.length,receivePacket.getAddress(),receivePacket.getPort());  
		socket.send(sendPacket);  

		displayArea.append("Packet sent\n\n================================\n");  
		displayArea.setCaretPosition(displayArea.getText().length());  
	}  

	//executa o aplicativo  
	public static void main (String args[]) {  
		Server1 application = new Server1();  
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		application.waitForPackets();  
	}  
}