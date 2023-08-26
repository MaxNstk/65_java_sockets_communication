package sockets;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConexaoCliente implements Conexao {

	private Socket conexao;
	
	public boolean getConection(String host, int porta){
				
		try {
			closeConnection();
			this.conexao = new Socket(host,porta);			
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}
	
	public void send(String command) {
		
		try {
			OutputStream out = this.conexao.getOutputStream();
			out.write(command.getBytes());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String read() {
		
		byte[] dadosBrutos = new byte[1024];
		
		try {
			InputStream in = this.conexao.getInputStream();
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
			if(!this.conexao.isClosed())
				this.conexao.close();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
