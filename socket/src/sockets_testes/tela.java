package sockets_testes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tela {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela window = new tela();
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
	public tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnStartServer = new JButton("start server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new Runnable() {
					public void run() {
						new Servidor();
					}
				};
			}
		});
		GridBagConstraints gbc_btnStartServer = new GridBagConstraints();
		gbc_btnStartServer.insets = new Insets(0, 0, 5, 0);
		gbc_btnStartServer.gridx = 3;
		gbc_btnStartServer.gridy = 2;
		frame.getContentPane().add(btnStartServer, gbc_btnStartServer);
		
		JButton btnStartClient = new JButton("start client");
		btnStartClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cliente();
			}
		});
		GridBagConstraints gbc_btnStartClient = new GridBagConstraints();
		gbc_btnStartClient.gridx = 3;
		gbc_btnStartClient.gridy = 4;
		frame.getContentPane().add(btnStartClient, gbc_btnStartClient);
	}

}
