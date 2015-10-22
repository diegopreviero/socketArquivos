package multi_Objetos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TelaMulti {

	private JFrame frame;
	private JTextField textField;
	private JButton btnLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMulti window = new TelaMulti();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMulti() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 328, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnStartServer = new JButton("Start Server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Servidor(1024);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnStartServer.setBounds(10, 58, 292, 23);
		frame.getContentPane().add(btnStartServer);

		JButton btnStartClient = new JButton("Start Client");
		btnStartClient.setBounds(10, 92, 292, 23);
		frame.getContentPane().add(btnStartClient);

		textField = new JTextField();
		textField.setBounds(10, 27, 212, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		btnLista = new JButton("Lista");
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				try {

					TelaMulti x = new TelaMulti();

					String pasta1 = "e:/socket";

					List<File> pdfs = x.buscaRecursiva(new File(pasta1), "");

					for (File pdf : pdfs) {
						System.out.print(pdf.getAbsolutePath() + "\n");
						//String local = pasta1.substring(pasta1.lastIndexOf("/")+1,pasta1.length());
						System.out.println("f:\\" + pdf.getAbsolutePath().substring(pdf.getAbsolutePath().indexOf("\\")+1,pdf.getAbsolutePath().length()));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}


			}
		});
		btnLista.setBounds(10, 151, 292, 23);
		frame.getContentPane().add(btnLista);
	}



	public List<File> buscaRecursiva(File pasta, String ext) {
		List<File> resultados = new ArrayList<File>();
		for (File f : pasta.listFiles()) {
			if (f.isDirectory()) {
				resultados.addAll(buscaRecursiva(f, ext));
			} else if (f.getName().endsWith(ext)) {
				resultados.add(f);
			}
		}
		return resultados;
	}

}
