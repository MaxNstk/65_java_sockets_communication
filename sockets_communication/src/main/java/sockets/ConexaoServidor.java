package sockets;

import models.Corja;
import models.Pessoa;

import java.net.Socket;
import java.util.List;

public class ConexaoServidor {

    private static ConexaoServidor instance;

    private ConexaoServidor() {}

    public static ConexaoServidor getInstance() {
        if(instance == null)
            instance = new ConexaoServidor();
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

}
