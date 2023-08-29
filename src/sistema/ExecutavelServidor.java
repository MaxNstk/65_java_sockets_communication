package sistema;
import java.io.IOException;
import java.util.Scanner;

import socket.ConexaoServidor;

public class ExecutavelServidor {

    public static void main(String[] args) {
    	
    	Scanner s = new Scanner(System.in);
    	System.out.println("Informe a porta do servidor");
		int hostPort = s.nextInt();
    	
        try {
            ConexaoServidor.getInstance().getConnection(hostPort);
        } 
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
