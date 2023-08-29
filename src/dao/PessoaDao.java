package dao;

import java.util.HashMap;
import java.util.Map;

import modelo.Pessoa;
import modelo.Saqueador;
import modelo.Trapaceiro;

public class PessoaDao {

	private Map<String, Pessoa> pessoas = new HashMap<>();
	private static PessoaDao instance;
	
	private PessoaDao() {}
	
    public static PessoaDao getInstance() {
        if (instance == null)
            instance = new PessoaDao();
        return instance;
    }
    
    public Map<String, Pessoa> getPessoas(){
    	return this.pessoas;
    }
    
    public void insertSaqueador(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	double valorSaqueado = Double.parseDouble(mensagem[5].split("=")[1]);
    	
    	Pessoa pessoa = new Saqueador(nome, cpf, endereco, valorSaqueado);
   
    	pessoas.put(cpf, pessoa);
	}
    
    public void insertTrapaceiro(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	String habilidade = mensagem[5].split("=")[1];
    	
    	Pessoa pessoa = new Trapaceiro(nome, cpf, endereco, habilidade);
   
    	pessoas.put(cpf, pessoa);
	}
    
    
    public String updateSaqueador(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	double valorSaqueado = Double.parseDouble(mensagem[5].split("=")[1]);
    	
    	Saqueador saqueador = (Saqueador) pessoas.get(cpf);

		if (saqueador == null)
			return "Pessoa não encontrada!";
		
		saqueador.setNome(nome);
		saqueador.setEndereco(endereco);
		saqueador.setValorSaqueado(valorSaqueado);
		
		return "Pessoa atualizada com sucesso";
	}
    
    public String updateTrapaceiro(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	String habilidade = mensagem[5].split("=")[1];
    	
    	Trapaceiro trapaceiro = (Trapaceiro) pessoas.get(cpf);

		if (trapaceiro == null)
			return "Pessoa não encontrada!";
		
		trapaceiro.setNome(nome);
		trapaceiro.setEndereco(endereco);
		trapaceiro.setHabilidade(habilidade);
		
		return "Pessoa atualizada com sucesso";
	}
    
    public String delete(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
		if (pessoas.size() == 0)
			return "Sem pessoas cadastradas";

		if (pessoas.get(cpf) == null)
			return "Pessoa não encontrada";
		
		pessoas.remove(cpf);
		return "Pessoa removida com sucesso";
	}
    
    public String get(String[] mensagem){
    	
    	String entidade = mensagem[1].split("=")[1];
    	String cpf = mensagem[2].split("=")[1];
    	
    	if(pessoas.size() == 0)
			return "Sem pessoas cadastradas";
		
    	final Pessoa pessoa;
    	
    	if(entidade.equalsIgnoreCase("Trapaceiro")) 
    		pessoa = (Trapaceiro) pessoas.get(cpf);
    	else 
    		pessoa = (Saqueador) pessoas.get(cpf);

		if (pessoa == null)
			return "Pessoa não encontrada";
		
		return pessoa.toString();
	}
	 
    public String list(){

		if(pessoas.size() == 0)
			return "0";

		String resposta = "";
		resposta += pessoas.size()+" \n";
		for (Map.Entry<String, Pessoa> pessoa : pessoas.entrySet()) {
			if (pessoa.getValue().getClass().equals(Trapaceiro.class)) 
				resposta += ((Trapaceiro) pessoa.getValue()).toString()+" \n";
            else 
            	resposta += ((Saqueador) pessoa.getValue()).toString()+" \n";
		}
		return resposta;
    }
}
