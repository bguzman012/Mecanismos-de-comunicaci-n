package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 233, 308, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Socket miScoket = new Socket("192.168.18.3", 9999);
					DataOutputStream flujoSalida = new DataOutputStream(miScoket.getOutputStream());
					flujoSalida.writeUTF(textField.getText());
					flujoSalida.close();
				
				} catch (UnknownHostException e) {
			
					e.printStackTrace();
				} catch (IOException e) {
				
					System.out.println(e.getMessage());
				}
				
			}
		});
		btnEnviar.setBounds(326, 233, 91, 22);
		contentPane.add(btnEnviar);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
