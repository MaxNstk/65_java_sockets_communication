package DAO;

import java.util.HashMap;
import java.util.Map;

import models.Pessoa;

public class PessoaDao {

	private Map<String, Pessoa> pessoas = new HashMap<>();;
	private static PessoaDao instance;
	
	private PessoaDao() {}
	
    public static PessoaDao getInstance() {
        if (instance == null)
            instance = new PessoaDao();
        return instance;
    }
    
    public void insert(String[] mensagem){
    	
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
}
