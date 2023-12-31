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
    	
    	Pessoa pessoa = pessoas.get(cpf);
    	
		if (pessoa == null || !pessoa.getClass().equals(Saqueador.class))
			return "Saqueador n�o encontrado!";
		
    	Saqueador saqueador = (Saqueador) pessoa;
		
		saqueador.setNome(nome);
		saqueador.setEndereco(endereco);
		saqueador.setValorSaqueado(valorSaqueado);
		
		return "Saqueador atualizado com sucesso";
	}
    
    public String updateTrapaceiro(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	String habilidade = mensagem[5].split("=")[1];
    	
    	Pessoa pessoa = pessoas.get(cpf);
    	
		if (pessoa == null || !pessoa.getClass().equals(Trapaceiro.class))
			return "Trapaceiro n�o encontrado!";
    	
    	Trapaceiro trapaceiro = (Trapaceiro) pessoa;
		
		trapaceiro.setNome(nome);
		trapaceiro.setEndereco(endereco);
		trapaceiro.setHabilidade(habilidade);
		
		return "Trapaceiro atualizado com sucesso";
	}
    
    public String delete(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
		if (pessoas.size() == 0)
			return "Sem pessoas cadastradas";

		if (pessoas.get(cpf) == null)
			return "Pessoa n�o encontrada";
		
		pessoas.remove(cpf);
				
		return "Pessoa removida com sucesso";
	}
    
    public String get(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	
    	if(pessoas.size() == 0)
			return "Sem pessoas cadastradas";
		
    	Pessoa pessoa = pessoas.get(cpf);

		if (pessoa == null)
			return "Pessoa n�o encontrada";
		
		if(pessoa.getClass().equals(Trapaceiro.class))
			return ((Trapaceiro) pessoa).toString();
		else
			return ((Saqueador) pessoa).toString();
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
