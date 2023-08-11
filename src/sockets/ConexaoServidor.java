package sockets;

import DAO.BancoEmMemoria;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;

public class ConexaoServidor implements ConexaoGenerica {

    private ServerSocket serverSocket;
    private Socket conexao;

    private BancoEmMemoria bancoDados;

    private static ConexaoServidor instance;

    private ConexaoServidor() {
    }

    public static ConexaoServidor getInstance() {
        if (instance == null)
            instance = new ConexaoServidor();
        return instance;
    }

    public boolean getConnection(int porta) throws IOException {

        this.serverSocket = new ServerSocket(porta);
        this.serverSocket.setReuseAddress(true);

        while (true) {
            System.out.println("aguardando conexão");
            try {
                this.conexao = serverSocket.accept();
                System.out.println("Conexao extabelecida com o host: " + this.conexao.getInetAddress().getHostAddress());
                this.serializarRequisicao();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void serializarRequisicao() {
        String[] mensagem = this.read().split(";");

        switch (mensagem[0]){
            case "INSERT":
                this.bancoDados.insertPessoa(mensagem);
                break;
            case "UPDATE":
                this.send(this.bancoDados.updatePessoa(mensagem));
                break;
            case "DELETE":
                this.send(this.bancoDados.deletePessoa(mensagem));
                break;
            case "LIST":
                this.send(this.bancoDados.listPessoas(mensagem));
                break;
            case "GET":
                this.send(this.bancoDados.getPessoa(mensagem));
                break;
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
            return new String(dadosBrutos, 0, qtdBytesLidos);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public boolean closeConnection() {
        try {
            if(this.serverSocket != null)
                this.serverSocket.close();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

}
