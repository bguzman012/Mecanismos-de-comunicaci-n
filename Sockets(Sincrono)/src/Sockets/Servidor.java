package Sockets;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mensaje.DetalleMensaje;

import javax.swing.JTextArea;

public class Servidor extends JFrame implements Runnable {

	private JPanel contentPane;
	
	private String nick;
	private String ip;
	private String mensaje;
	private DetalleMensaje recibirDetalleMensaje;
	private int puerto;
	
	
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
					frame.setTitle("Servidor");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.s
	 */
	public Servidor() {
		this.setTitle("Servidor");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 0, 356, 230);
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
				
				ObjectInputStream recibirPaquete = new ObjectInputStream(miSocket.getInputStream());
				recibirDetalleMensaje = (DetalleMensaje) recibirPaquete.readObject();
				
				nick = recibirDetalleMensaje.getNick();
				ip = recibirDetalleMensaje.getIp();
				mensaje = recibirDetalleMensaje.getMensaje();
				puerto = recibirDetalleMensaje.getPuerto();
				
				Socket enviarMensaje = new Socket("192.168.18.3",puerto);
				
				ObjectOutputStream enviarPaquete = new ObjectOutputStream(enviarMensaje.getOutputStream());
				
				enviarPaquete.writeObject(recibirDetalleMensaje);
				
				enviarPaquete.close();
				enviarMensaje.close();
				
				textArea.append("\n" + "De:" + "\t" + nick);
				textArea.append("\n" + "Para: " + "\t" + puerto);
				textArea.append("\n" + "Mensaje: " + "\t" + mensaje);

				
				//miSocket.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
