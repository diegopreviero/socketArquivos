package previero3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import previero3.recursos.PedirArquivo;
import previero3.recursos.PedirArquivo3;

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

		JButton btnPesquisaOrigem = new JButton("Pesquisar...");
		btnPesquisaOrigem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tela t = new tela();
				tfOrigem.setText(t.choose());
				tfDestino.requestFocus();
			}
		});
		btnPesquisaOrigem.setBounds(548, 11, 125, 23);
		frmTransfernciaViaSocket.getContentPane().add(btnPesquisaOrigem);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String origem = tfOrigem.getText();
				String destino = tfDestino.getText();

				if(!destino.replace("\\", "/").endsWith("/")){
					destino = destino + "/";
				}

				//final String destino2 = destino;

				new PedirArquivo3(origem, destino);


				//CORRIGIR ESSAS VARIAVEIS REDUNDANTES

				/*EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new PedirArquivo(origem, destino2);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});*/





			}
		});
		btnOk.setBounds(548, 129, 125, 23);
		frmTransfernciaViaSocket.getContentPane().add(btnOk);

		JButton btnPesquisaDestino = new JButton("Pesquisar...");
		btnPesquisaDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela t = new tela();
				tfDestino.setText(t.choose());
				tfDestino.requestFocus();
			}
		});
		btnPesquisaDestino.setBounds(548, 45, 125, 23);
		frmTransfernciaViaSocket.getContentPane().add(btnPesquisaDestino);

		tfOrigem = new JTextField();
		tfOrigem.setBounds(118, 12, 420, 20);
		frmTransfernciaViaSocket.getContentPane().add(tfOrigem);
		tfOrigem.setColumns(10);

		tfDestino = new JTextField();
		tfDestino.setBounds(118, 46, 420, 20);
		frmTransfernciaViaSocket.getContentPane().add(tfDestino);
		tfDestino.setColumns(10);

		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setBounds(10, 15, 90, 14);
		frmTransfernciaViaSocket.getContentPane().add(lblOrigem);

		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setBounds(10, 49, 90, 14);
		frmTransfernciaViaSocket.getContentPane().add(lblDestino);
		
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			//JOptionPane.showMessageDialog(null, "win");
			tfOrigem.setText("e:/socket/");
			tfDestino.setText("e:/kiko/");
		}
	}

	private JTextField tfOrigem;
	private JTextField tfDestino;

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
			return chooser.getSelectedFile().getAbsolutePath().replace("\\", "/");
		}else{
			return "";
		}

	}

}


