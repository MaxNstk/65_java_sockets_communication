package DAO;

import java.util.ArrayList;
import java.util.List;

import models.Pessoa;

public class PessoaDao {

	private List<Pessoa> pessoas = new ArrayList<>();
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
