package Sockets;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mensaje.DetalleMensaje;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Cliente2 extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField mensaje;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JTextField miNick;
	private JLabel lblPara;
	private JTextField ip;
	
	private JTextField puerto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente2 frame = new Cliente2();
					frame.setVisible(true);
					frame.setTitle("Cliente2");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cliente2() {
		this.setTitle("Cliente 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mensaje = new JTextField();
		mensaje.setBounds(12, 252, 299, 25);
		contentPane.add(mensaje);
		mensaje.setColumns(10);
		
		JButton Enviar = new JButton("Enviar");
		Enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//Socket miScoket = new Socket("192.168.18.3", 9999);
					Socket miScoket = new Socket("192.168.18.3", 9999);
					
					DetalleMensaje detalleMensaje = new DetalleMensaje();
					
					detalleMensaje.setNick(miNick.getText());
					//detalleMensaje.setIp(ip.getText());
					detalleMensaje.setMensaje(mensaje.getText());
					detalleMensaje.setPuerto(Integer.parseInt(puerto.getText()));
					
					ObjectOutputStream objeto = new ObjectOutputStream(miScoket.getOutputStream());
					objeto.writeObject(detalleMensaje);
					//miScoket.close();
					
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
				
			}
		});
		Enviar.setBounds(324, 250, 105, 28);
		contentPane.add(Enviar);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 0, 299, 240);
		contentPane.add(textArea);
		
		lblNewLabel = new JLabel("De:");
		lblNewLabel.setBounds(329, 12, 59, 18);
		contentPane.add(lblNewLabel);
		
		miNick = new JTextField();
		miNick.setBounds(324, 42, 114, 22);
		contentPane.add(miNick);
		miNick.setColumns(10);
		
		/*lblPara = new JLabel("Para:");
		lblPara.setBounds(329, 116, 59, 18);
		contentPane.add(lblPara);
		
		ip = new JTextField();
		ip.setColumns(10);
		ip.setBounds(324, 146, 114, 22);
		contentPane.add(ip);*/
		
		JLabel lblNewLabel_1 = new JLabel("Puerto");
		lblNewLabel_1.setBounds(329, 141, 59, 18);
		contentPane.add(lblNewLabel_1);
		
		puerto = new JTextField();
		puerto.setBounds(324, 179, 114, 22);
		contentPane.add(puerto);
		puerto.setColumns(10);
		
		Thread hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(9091);
			Socket cliente;
			DetalleMensaje mensajeRecibido;
			while(true) {
				cliente = serverSocket.accept();
				ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
				mensajeRecibido = (DetalleMensaje) flujoEntrada.readObject();
				
				textArea.append("\n" + "De:" + "\t" + mensajeRecibido.getNick());
				textArea.append("\n" + "Para:" + "\t" + mensajeRecibido.getPuerto());
				textArea.append("\n" + "Mensaje:" + "\t" +mensajeRecibido.getMensaje());
				
				
				//serverSocket.close();
			}
			
			
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}
