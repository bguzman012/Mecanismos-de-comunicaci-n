package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.IOException;

import javax.print.attribute.standard.Severity;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends JFrame  implements Runnable{

	private JPanel contentPane;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
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
	public Servidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 12, 398, 231);
		contentPane.add(textArea);
		
		Thread miHilo = new Thread(this);
		miHilo.start();
	
	}

	@Override
	public void run() {
		
		try {
			ServerSocket servidor = new ServerSocket(9999);
			while (true) {
				Socket miSocket = servidor.accept();
				DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
				String mensaje = flujoEntrada.readUTF();
				textArea.append("\n" + mensaje);
				miSocket.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
}
