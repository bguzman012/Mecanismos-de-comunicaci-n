import Sockets.Cliente;
import Sockets.Cliente2;
import Sockets.Servidor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setVisible(true);
		
		Cliente2 cliente2 = new Cliente2();
		cliente2.setVisible(true);
		
		
		Servidor servidor = new Servidor();
		servidor.setVisible(true);  
	}

}
