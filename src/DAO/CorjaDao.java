package DAO;

import java.util.ArrayList;
import java.util.List;

import models.Corja;

public class CorjaDao {
	
	private List<Corja> corjas = new ArrayList<>();
	private static CorjaDao instance;
	
	private CorjaDao() {}
	
    public static CorjaDao getInstance() {
        if (instance == null)
            instance = new CorjaDao();
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
