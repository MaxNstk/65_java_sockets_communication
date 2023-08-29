package sistema;
import java.io.IOException;

import socket.ConexaoServidor;

public class ExecutavelServidor {

    public static void main(String[] args) {
        try {
            ConexaoServidor.getInstance().getConnection(80);
        } 
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
