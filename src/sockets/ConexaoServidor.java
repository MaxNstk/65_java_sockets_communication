package sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import DAO.CorjaDao;
import DAO.PessoaDao;
import consts.PessoaConsts;

import java.net.ServerSocket;


public class ConexaoServidor implements Conexao {

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
    
    // PADRÃO: METODO;objeto;atributos=valores;
    private void serializarRequisicao() {
    	
    	String dados = this.read();
        String[] mensagem = dados.isEmpty() ? null : dados.split(";");

        if (mensagem[PessoaConsts.TABELA].equalsIgnoreCase("Pessoa")){
        	
        	PessoaDao pessoaDao = PessoaDao.getInstance();
        	
            switch (mensagem[PessoaConsts.METODO]){
                case "INSERT":
                	pessoaDao.insert(mensagem);
                    this.send("");
                    break;
                case "UPDATE":
                    this.send(pessoaDao.update(mensagem));
                    break;
                case "DELETE":
                    this.send(pessoaDao.delete(mensagem));
                    break;
                case "LIST":
                    this.send(pessoaDao.list());
                    break;
                case "GET":
                    this.send(pessoaDao.get(mensagem));
                    break;
                default:
                    this.send("Método inválido: "+mensagem[PessoaConsts.METODO]);
            }
        }
        else if (mensagem[PessoaConsts.TABELA].equalsIgnoreCase("Corja")){
        	
        	CorjaDao corjaDao = CorjaDao.getInstance();
        	
            switch (mensagem[PessoaConsts.METODO]){
                case "INSERT":
                	corjaDao.insert(mensagem);
                    this.send("");
                    break;
                case "UPDATE":
                    this.send(corjaDao.update(mensagem));
                    break;
                case "DELETE":
                    this.send(corjaDao.delete(mensagem));
                    break;
                case "LIST":
                    this.send(corjaDao.list(mensagem));
                    break;
                case "GET":
                    this.send(corjaDao.get(mensagem));
                    break;
                case "ADDPESSOA":
                    this.send(corjaDao.addPessoa(mensagem));
                    break;
                case "REMOVEPESSOA":
                    this.send(corjaDao.removePessoa(mensagem));
                    break;
                case "LISTPESSOA":
                	this.send(corjaDao.listarPessoas(mensagem));
                	break;
                default:
                    this.send("Método inválido: "+mensagem[PessoaConsts.METODO]);
            }
        }
        else
            this.send("Objeto inválido: "+mensagem[PessoaConsts.TABELA]);
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
