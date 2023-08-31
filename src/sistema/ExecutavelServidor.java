package sistema;
import java.io.IOException;
import java.util.Scanner;

import dao.CorjaDao;
import dao.PessoaDao;
import socket.ConexaoServidor;

public class ExecutavelServidor {

    public static void main(String[] args) {
    	
    	Scanner s = new Scanner(System.in);
    	System.out.println("Informe a porta do servidor");
		int hostPort = s.nextInt();
    	
		inserirDadosIniciais();
		
        try {
        	System.out.print("Aguardando conexoes...");
            ConexaoServidor.getInstance().getConnection(hostPort);
        } 
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void inserirDadosIniciais() {
    	PessoaDao pessoaDao = PessoaDao.getInstance();
    	String[] mensagem;
    	
    	mensagem = "INSERT;TRAPACEIRO;cpf=1;nome=Pedro;endereco=Dubai;habilidade=Estorquir".split(";");
    	pessoaDao.insertTrapaceiro(mensagem);
    	mensagem = "INSERT;TRAPACEIRO;cpf=2;nome=Henrique;endereco=Barcelona;habilidade=Enganar".split(";");
    	pessoaDao.insertTrapaceiro(mensagem);
    	mensagem = "INSERT;TRAPACEIRO;cpf=3;nome=Joao;endereco=PG;habilidade=Furtividade".split(";");
    	pessoaDao.insertTrapaceiro(mensagem);
    	mensagem = "INSERT;TRAPACEIRO;cpf=4;nome=Max;endereco=Ibirama;habilidade=Ladinagem".split(";");
    	pessoaDao.insertTrapaceiro(mensagem);
    	mensagem = "INSERT;TRAPACEIRO;cpf=5;nome=Luiz;endereco=Miami;habilidade=Intimidacao".split(";");
    	pessoaDao.insertTrapaceiro(mensagem);
    	mensagem = "INSERT;TRAPACEIRO;cpf=6;nome=Jorge;endereco=Florianopolis;habilidade=Resistencia".split(";");
    	pessoaDao.insertTrapaceiro(mensagem);
    	mensagem = "INSERT;TRAPACEIRO;cpf=7;nome=Fred;endereco=SP;habilidade=Roubo".split(";");
    	pessoaDao.insertTrapaceiro(mensagem);
    	
    	
    	mensagem = "INSERT;SAQUEADOR;cpf=8;nome=Maria;endereco=Roma;valorSaqueado=1500".split(";");
    	pessoaDao.insertSaqueador(mensagem);
    	mensagem = "INSERT;SAQUEADOR;cpf=9;nome=Helena;endereco=Xangai;valorSaqueado=100".split(";");
    	pessoaDao.insertSaqueador(mensagem);
    	mensagem = "INSERT;SAQUEADOR;cpf=10;nome=Maicon;endereco=Moscou;valorSaqueado=99".split(";");
    	pessoaDao.insertSaqueador(mensagem);
    	mensagem = "INSERT;SAQUEADOR;cpf=11;nome=Michel;endereco=Laurentino;valorSaqueado=320".split(";");
    	pessoaDao.insertSaqueador(mensagem);
    	mensagem = "INSERT;SAQUEADOR;cpf=12;nome=Lucas;endereco=Indaial;valorSaqueado=120".split(";");
    	pessoaDao.insertSaqueador(mensagem);
    	mensagem = "INSERT;SAQUEADOR;cpf=13;nome=Igor;endereco=Ascurra;valorSaqueado=50".split(";");
    	pessoaDao.insertSaqueador(mensagem);
    	mensagem = "INSERT;SAQUEADOR;cpf=14;nome=Nicolas;endereco=Blumenau;valorSaqueado=252".split(";");
    	pessoaDao.insertSaqueador(mensagem);
    	mensagem = "INSERT;SAQUEADOR;cpf=15;nome=Andre;endereco=RJ;valorSaqueado=12000".split(";");
    	pessoaDao.insertSaqueador(mensagem);
    	
    	CorjaDao corjaDao = CorjaDao.getInstance();
    	mensagem = "INSERT;CORJA;nome=Bravos;localEsconderijo=Caverna;anoFundacao=2002".split(";");
    	corjaDao.insert(mensagem);
    	mensagem = "INSERT;CORJA;nome=Caveira;localEsconderijo=Beco;anoFundacao=2015".split(";");
    	corjaDao.insert(mensagem);
    	mensagem = "INSERT;CORJA;nome=Velhacos;localEsconderijo=Asilo;anoFundacao=1850".split(";");
    	corjaDao.insert(mensagem);
    	mensagem = "INSERT;CORJA;nome=Vikings;localEsconderijo=Bar;anoFundacao=1999".split(";");
    	corjaDao.insert(mensagem);
    	
    	mensagem = "ADDPESSOA;CORJA;nome=Bravos;cpf=1".split(";");
    	corjaDao.addPessoa(mensagem);
    	mensagem = "ADDPESSOA;CORJA;nome=Bravos;cpf=15".split(";");
    	corjaDao.addPessoa(mensagem);
    	mensagem = "ADDPESSOA;CORJA;nome=Bravos;cpf=7".split(";");
    	corjaDao.addPessoa(mensagem);
    	mensagem = "ADDPESSOA;CORJA;nome=Caveira;cpf=12".split(";");
    	corjaDao.addPessoa(mensagem);
    	mensagem = "ADDPESSOA;CORJA;nome=Caveira;cpf=4".split(";");
    	corjaDao.addPessoa(mensagem);
    	mensagem = "ADDPESSOA;CORJA;nome=Velhacos;cpf=9".split(";");
    	corjaDao.addPessoa(mensagem);
    	mensagem = "ADDPESSOA;CORJA;nome=Vikings;cpf=2".split(";");
    	corjaDao.addPessoa(mensagem);
    	mensagem = "ADDPESSOA;CORJA;nome=Vikings;cpf=10".split(";");
    	corjaDao.addPessoa(mensagem);
    	mensagem = "ADDPESSOA;CORJA;nome=Vikings;cpf=6".split(";");
    	corjaDao.addPessoa(mensagem);
    }
}
