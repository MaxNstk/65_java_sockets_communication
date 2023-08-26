package dao;

import java.util.HashMap;
import java.util.Map;

import models.Trapaceiro;

public class TrapaceiroDao {

	private Map<String, Trapaceiro> trapaceiros = new HashMap<>();
	private static TrapaceiroDao instance;
	
	private TrapaceiroDao() {}
	
    public static TrapaceiroDao getInstance() {
        if (instance == null)
            instance = new TrapaceiroDao();
        return instance;
    }
    
    public Map<String, Trapaceiro> getTrapaceiros(){
    	return this.trapaceiros;
    }
    
    public void insert(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	String habilidade = mensagem[5].split("=")[1];
    	
    	Trapaceiro trapaceiro = new Trapaceiro(nome, cpf, endereco, habilidade);
   
    	trapaceiros.put(cpf, trapaceiro);
	}
    
    public String update(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	
    	Trapaceiro trapaceiro = trapaceiros.get(cpf);

		if (trapaceiro == null)
			return "Trapaceiro não encontrado!";
		
		trapaceiro.setNome(nome);
		trapaceiro.setEndereco(endereco);
		
		return "Trapaceiro atualizado com sucesso";
	}
    
    public String delete(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
		if (trapaceiros.size() == 0)
			return "Sem trapaceiros cadastrados";

		if (trapaceiros.get(cpf) == null)
			return "Trapaceiro não encontrado";
		
		trapaceiros.remove(cpf);
		return "Trapaceiro removida com sucesso";
	}
    
    public String get(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	
    	if(trapaceiros.size() == 0)
			return "Sem trapaceiros cadastrados";

		Trapaceiro trapaceiro = trapaceiros.get(cpf);
		if (trapaceiro == null)
			return "Trapaceiro não encontrado";

		return trapaceiro.toString();

	}
	 
    public String list(){

		if(trapaceiros.size() == 0)
			return "0";

		String resposta = "";
		resposta += trapaceiros.size()+" \n";
		for (Map.Entry<String, Trapaceiro> trapaceiro : trapaceiros.entrySet()) {
			resposta += trapaceiro.getValue().toString()+" \n";
		}

		return resposta;
    }
}
