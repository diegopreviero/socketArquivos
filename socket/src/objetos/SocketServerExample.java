package objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import objetos.*;
public class SocketServerExample {
     
    private static ServerSocket server;
    private static int port = 9876;
     
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        server = new ServerSocket(port);
       
       Cachorro x = new Cachorro(); 
       // while(true){
           // System.out.println("Waiting for client request");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //String message = (String) ois.readObject().toString();
            Cachorro c = (Cachorro) ois.readObject();            
            //System.out.println("Message Received: " + message);
            System.out.println("Message Received: " + c.getRaca());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hi Client " /*+ message*/);
            ois.close();
            oos.close();
            socket.close();
            //if(message.equalsIgnoreCase("exit")) break;
          //  if(c.getCor().equalsIgnoreCase("branca")) break;
       // }
        //System.out.println("Shutting down Socket server!!");
        server.close();
    }
    
    /*
     * 
      ObjectInputStream oi = new ObjectInputStream(conexao.getInputStream());
 <Cliente> c = (Vector<Cliente>) oi.readObject();
 
 */
     //teste de stash
}