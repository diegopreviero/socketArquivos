package teste01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class PropertiesTest {

	public static void main(String[] args)
			throws Exception {
		try {

			FileInputStream propFile = new FileInputStream( "./src/teste01/config.cfg");

			Properties p = new Properties();
			//Properties p = new Properties(System.getProperties());
			p.load(propFile);

			p.list(System.out);

			/* SETAR PROPRIEDADES DO SISTEMA */
			//System.setProperties(p);
			//System.getProperties().list(System.out);

			System.out.println("\n############# EXIBINDO POR CHAVE #############");
			
			System.out.println("Nome:  " + p.getProperty("nome"));
			System.out.println("Idade: " + p.getProperty("idade"));
			System.out.println("Sexo:  " + p.getProperty("sexo"));
			
			System.out.println("\n############# ALTERANDO VALOR DA CHAVE #############");

			p.setProperty("nome", "jao");

			System.out.println("Nome:  " + p.getProperty("nome"));
			System.out.println("Idade: " + p.getProperty("idade"));
			System.out.println("Sexo:  " + p.getProperty("sexo"));

			System.out.println("\n############# ADICIONANDO NOVA CHAVE #############");
			p.setProperty("IP", "192.168.0.10");
			p.list(System.out);
			
			// SALVANDO ALTERACOES NO ARQUIVO 
			FileOutputStream arquivoOut = new FileOutputStream("./src/teste01/config.cfg");
			p.store(arquivoOut, null);



			/*
			// SETAR PROPRIEDADES DO SISTEMA

			System.out.println("Versão:          " + System.getProperty("java.version"));
			System.out.println("Vendor:          " + System.getProperty("java.vendor"));
			System.out.println("Vendor url:      " + System.getProperty("java.vendor.url"));
			System.out.println("Versão da VM:    " + System.getProperty("java.vm.version"));
			System.out.println("Nome da VM:      " + System.getProperty("java.vm.name"));
			System.out.println("Versão do Class: " + System.getProperty("java.class.version"));
			System.out.println("Compilador:      " + System.getProperty("java.compiler"));
			System.out.println("Nome da VM:      " + System.getProperty("os.name"));
			System.out.println("Versão do Class: " + System.getProperty("os.arch"));
			System.out.println("Compilador:      " + System.getProperty("os.version") + "\n");

			Properties p = System.getProperties();
			p.list(System.out);
			 */


		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não Foi possível salvar dados no arquivo config.cfg\n"+e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}
}