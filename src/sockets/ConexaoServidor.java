package sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import DAO.CorjaDao;
import DAO.PessoaDao;

import java.net.ServerSocket;

public class ConexaoServidor implements ConexaoGenerica {

    private ServerSocket serverSocket;
    private Socket conexao;

    private static ConexaoServidor instance;

    private ConexaoServidor() {}

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

    public String[] getConteudoMensagem(String[] mensagem){
        String[] conteudoMensagem = new String[mensagem.length-2];
        for(int i = 2; i <= mensagem.length-1; i++){
            conteudoMensagem[i] = mensagem[i];
        }
        return conteudoMensagem;
    }

    // PADRÃO: METODO;objeto;atributos=valores;
    private void serializarRequisicao() {
        String[] mensagem = this.read().split(";");

        if (mensagem[1].equalsIgnoreCase("Pessoa")){
        	
        	PessoaDao pessoaDao = PessoaDao.getInstance();
        	
            switch (mensagem[0]){
                case "INSERT":
                	pessoaDao.insert(getConteudoMensagem(mensagem));
                    this.send("");
                    break;
                case "UPDATE":
                    this.send(pessoaDao.update(getConteudoMensagem(mensagem)));
                    break;
                case "DELETE":
                    this.send(pessoaDao.delete(getConteudoMensagem(mensagem)));
                    break;
                case "LIST":
                    this.send(pessoaDao.list(getConteudoMensagem(mensagem)));
                    break;
                case "GET":
                    this.send(pessoaDao.get(getConteudoMensagem(mensagem)));
                    break;
                default:
                    this.send("Método inválido: "+mensagem[0]);
            }
        }
        if (mensagem[1].equalsIgnoreCase("Corja")){
        	
        	CorjaDao corjaDao = CorjaDao.getInstance();
        	
            switch (mensagem[0]){
                case "INSERT":
                	corjaDao.insert(getConteudoMensagem(mensagem));
                    this.send("");
                    break;
                case "UPDATE":
                    this.send(corjaDao.update(getConteudoMensagem(mensagem)));
                    break;
                case "DELETE":
                    this.send(corjaDao.delete(getConteudoMensagem(mensagem)));
                    break;
                case "LIST":
                    this.send(corjaDao.list(getConteudoMensagem(mensagem)));
                    break;
                case "GET":
                    this.send(corjaDao.get(getConteudoMensagem(mensagem)));
                    break;
                case "ADDPESSOA":
                    this.send(corjaDao.addPessoa(getConteudoMensagem(mensagem)));
                    break;
                case "REMOVEPESSOA":
                    this.send(corjaDao.removePessoa(getConteudoMensagem(mensagem)));
                    break;
                case "LISTPESSOA":
                	this.send(corjaDao.listarPessoas(getConteudoMensagem(mensagem)));
                	break;
                default:
                    this.send("Método inválido: "+mensagem[0]);
            }
        }
        this.send("Objeto inválido: "+mensagem[1]);
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
