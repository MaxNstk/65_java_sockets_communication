package DAO;

import java.util.HashMap;
import java.util.Map;

import consts.CorjaConsts;
import consts.PessoaConsts;
import models.Corja;

public class CorjaDao {

	private Map<String, Corja> membros = new HashMap<>();;
	private static CorjaDao instance;
	
	private CorjaDao() {}
	
    public static CorjaDao getInstance() {
        if (instance == null)
            instance = new CorjaDao();
        return instance;
    }
    
    public void insert(String[] mensagem){

//        String cpf = mensagem[CorjaConsts.NOME].split("=")[1];
//        String nome = mensagem[CorjaConsts.ANO_FUNDACAO].split("=")[1];
//        String endereco = mensagem[PessoaConsts.ENDERECO].split("=")[1]

	}
    
    public String update(String[] mensagem){
    	return "";
	}
    
    public String delete(String[] mensagem){
    	return "";
	}
    
    public String get(String[] mensagem){
    	return "";
	}
	
    public String list(String[] mensagem){
    	return "";
    }
    
    public String addPessoa(String[] mensagem) {
    	return "";
    }
    
    public String removePessoa(String[] mensagem) {
    	return "";
    }
    
    public String listarPessoas(String[] mensagem) {
    	return "";
    }
}
