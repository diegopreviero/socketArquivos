package previero4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import previero3.recursos.PedirArquivo;

public class tela {

	private JFrame frmTransfernciaViaSocket;

	private JTextField tfOrigem;
	private JTextField tfDestino;
	private String origem;
	private String destino;

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setDestino(String destino) {

		if(!destino.replace("\\", "/").endsWith("/")){
			destino = destino + "/";
		}		

		this.destino = destino;
	}

	//implementacao de chamada Singleton
	private static tela uniqueInstance = new tela();
	public static tela getInstance() { return uniqueInstance; }


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getInstance().frmTransfernciaViaSocket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public tela() {
		initialize();
	}

	private void initialize() {

		frmTransfernciaViaSocket = new JFrame();
		frmTransfernciaViaSocket.setTitle("Transfer\u00EAncia via Socket");
		frmTransfernciaViaSocket.setBounds(100, 100, 699, 201);
		frmTransfernciaViaSocket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTransfernciaViaSocket.getContentPane().setLayout(null);
		frmTransfernciaViaSocket.setLocationRelativeTo(null);

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


		JButton btnPesquisaOrigem = new JButton("Pesquisar...");
		btnPesquisaOrigem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfOrigem.setText(getInstance().choose("origem"));
				tfDestino.requestFocus();
			}
		});
		btnPesquisaOrigem.setBounds(548, 11, 125, 23);
		frmTransfernciaViaSocket.getContentPane().add(btnPesquisaOrigem);

		JButton btnPesquisaDestino = new JButton("Pesquisar...");
		btnPesquisaDestino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tfDestino.setText(getInstance().choose("destino"));
				tfDestino.requestFocus();
			}
		});
		btnPesquisaDestino.setBounds(548, 45, 125, 23);
		frmTransfernciaViaSocket.getContentPane().add(btnPesquisaDestino);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setOrigem(tfOrigem.getText());
				setDestino(tfDestino.getText());

				//new PedirArquivo(origem, destino).start();
				
				
				

				tfDestino.requestFocus();

			}
		});
		btnOk.setBounds(548, 129, 125, 23);
		frmTransfernciaViaSocket.getContentPane().add(btnOk);

		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			setOrigem("e:/socket/");
			setDestino("e:/kiko/");
			tfOrigem.setText(getOrigem());
			tfDestino.setText(getDestino());
		}else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
			setOrigem("/home/khaemhat/socket/");
			setDestino("/home/khaemhat/kiko/");
			tfOrigem.setText(getOrigem());
			tfDestino.setText(getDestino());
		}

		try {
			new previero4.Servidor(1024);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public String choose (String op){

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = chooser.showOpenDialog(frmTransfernciaViaSocket);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath().replace("\\", "/");
		}else{
			if (op.equals("origem")) {
				return getOrigem();	
			}else {
				return getDestino();
			}			
		}
	}

}