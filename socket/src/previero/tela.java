package previero;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class tela {

	private JFrame frmTransfernciaViaSocket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela window = new tela();
					window.frmTransfernciaViaSocket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTransfernciaViaSocket = new JFrame();
		frmTransfernciaViaSocket.setTitle("Transfer\u00EAncia via Socket");
		frmTransfernciaViaSocket.setBounds(100, 100, 699, 201);
		frmTransfernciaViaSocket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTransfernciaViaSocket.getContentPane().setLayout(null);
		frmTransfernciaViaSocket.setLocationRelativeTo(null);

		JButton btnPesquisar = new JButton("Pesquisar...");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tela t = new tela();
				String dir = t.choose();
				textField.setText(dir);
				textField_1.setText(dir);
				textField_1.requestFocus();
			}
		});
		btnPesquisar.setBounds(548, 11, 125, 23);
		frmTransfernciaViaSocket.getContentPane().add(btnPesquisar);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela t = new tela();
				t.enviar();
			}
		});
		btnOk.setBounds(548, 129, 125, 23);
		frmTransfernciaViaSocket.getContentPane().add(btnOk);

		JButton button = new JButton("Pesquisar...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela t = new tela();
				textField_1.setText(t.choose());
				textField_1.requestFocus();
			}
		});
		button.setBounds(548, 45, 125, 23);
		frmTransfernciaViaSocket.getContentPane().add(button);

		textField = new JTextField();
		textField.setBounds(66, 12, 472, 20);
		frmTransfernciaViaSocket.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(66, 46, 472, 20);
		frmTransfernciaViaSocket.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setBounds(10, 15, 46, 14);
		frmTransfernciaViaSocket.getContentPane().add(lblOrigem);

		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setBounds(10, 49, 46, 14);
		frmTransfernciaViaSocket.getContentPane().add(lblDestino);
	}

	String pasta1 = "";
	String pasta2 = "";
	private JTextField textField;
	private JTextField textField_1;

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

	public String choose (){

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = chooser.showOpenDialog(frmTransfernciaViaSocket);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath();
		}else{
			return "";
		}

	}


	public void enviar(){

		pasta1 = textField.getText().replace("\\", "/");
		pasta2 = textField.getText().replace("\\", "/");
		
		if (pasta1 != "" || pasta2 != ""){

			try {

				List<File> pdfs = buscaRecursiva(new File(pasta1), "");
				//System.out.println("Quantidade: " + pdfs.size() + "\n");

				for (File pdf : pdfs) {
					//System.out.println("bytes: " + pdf.length());
					//System.out.println("Arquivo: " + pdf.getName());
					//String local = pasta1.substring( pasta1.lastIndexOf("/")+1,pasta1.length() );
					
					System.out.println( "Arquivo: " + pdf.getAbsolutePath() );
					
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}


		}else{
			JOptionPane.showMessageDialog(null, "Escolha um destino!!!");
		}

	}

}
