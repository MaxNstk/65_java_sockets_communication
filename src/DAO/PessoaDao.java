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
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	
    	Pessoa pessoa = new Pessoa(nome, cpf, endereco);
   
    	pessoas.put(cpf, pessoa);
	}
    
    public String update(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	
    	Pessoa pessoa = pessoas.get(cpf);
    	
    	if(pessoa != null) {
    		pessoa.setCpf(nome);
    		pessoa.setEndereco(endereco);
    		return "Pessoa atualizada com sucesso";
    	}
    	else {
    		return "Pessoa não encontrada!";
    	}
	}
    
    public String delete(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	if(pessoas.size() > 0) {
    		
    		Pessoa pessoa = pessoas.get(cpf);
    		
    		if(pessoa != null) {
    			pessoas.remove(cpf);
    			return "Pessoa removida com sucesso";
    		}
    		else {
        		return "Pessoa não encontrada";
    		}
    	}
    	else {
    		return "Sem pessoas cadastradas";	
    	}
	}
    
    public String get(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	
    	if(pessoas.size() > 0) {
    		
    		Pessoa pessoa = pessoas.get(cpf);
    		
    		if(pessoa != null) {
    			return pessoa.toString();
    		}
    		else {
    			return "Pessoa não encontrada";
    		}
    	}
    	else {
        	return "Sem pessoas cadastradas";
    	}
	}
	
    public String list(String[] mensagem){
    	
    	String resposta = "";
    	
    	if(pessoas.size() > 0) {
    		
    		resposta += pessoas.size()+" \n";
    		
    		for (Map.Entry<String, Pessoa> pessoa : pessoas.entrySet()) {
    			resposta += pessoa.getValue().getCpf()+";"+pessoa.getValue().getNome()+";"+pessoa.getValue().getEndereco()+" \n";
    		}
    		
    		return resposta;
    	}
    	else {
        	return "0";
    	}
    }
}
