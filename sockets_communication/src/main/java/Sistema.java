import sockets.ConexaoCliente;

public class Sistema {

	public static void main(String[] args) {

		ConexaoCliente c = ConexaoCliente.getInstance();
			
		c.getConection(null, 0);
		c.send("INSERT");
		c.read();
	}
}