package sockets;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConexaoCliente implements ConexaoGenerica {

	private static ConexaoCliente instance;
	private Socket conexao;
	
	private ConexaoCliente() {}
	
	public static ConexaoCliente getInstance() {
		if(instance == null)
			instance = new ConexaoCliente();
		
		return instance;
	}
	
	public boolean getConection(String host, int porta){
				
		try {
			closeConnection();
			this.conexao = new Socket(host,porta);
			System.out.println("Conectado!");
			
			return true;
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void send(String command) {
		
		OutputStream out;
		try {
			out = this.conexao.getOutputStream();
			out.write(command.getBytes());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String read() {
		
		InputStream in;
		byte[] dadosBrutos = new byte[1024];
		
		try {
			in = this.conexao.getInputStream();
			int qtdBytesLidos = in.read(dadosBrutos);
			String response = new String(dadosBrutos, 0, qtdBytesLidos);
			
			return response;
		} 
		catch (Exception e) {
			return e.getMessage();
		}		
	}
	
	public boolean closeConnection() {
		
		try {
			if(this.conexao != null)
				this.conexao.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
