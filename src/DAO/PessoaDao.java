package DAO;

import java.util.HashMap;
import java.util.Map;

import consts.PessoaConsts;
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
    	
    	String cpf = mensagem[PessoaConsts.CPF].split("=")[1];
    	String nome = mensagem[PessoaConsts.NOME].split("=")[1];
    	String endereco = mensagem[PessoaConsts.ENDERECO].split("=")[1];
    	
    	Pessoa pessoa = new Pessoa(nome, cpf, endereco);
   
    	pessoas.put(cpf, pessoa);
	}
    
    public String update(String[] mensagem){
    	
    	String cpf = mensagem[PessoaConsts.CPF].split("=")[1];
    	String nome = mensagem[PessoaConsts.NOME].split("=")[1];
    	String endereco = mensagem[PessoaConsts.ENDERECO].split("=")[1];
    	
    	Pessoa pessoa = pessoas.get(cpf);

		if (pessoa == null)
			return "Pessoa n�o encontrada!";
		pessoa.setCpf(nome);
		pessoa.setEndereco(endereco);
		return "Pessoa atualizada com sucesso";
	}
    
    public String delete(String[] mensagem){
    	
    	String cpf = mensagem[PessoaConsts.CPF].split("=")[1];
		if (pessoas.size() == 0)
			return "Sem pessoas cadastradas";

		if (pessoas.get(cpf) == null)
			return "Pessoa n�o encontrada";
		pessoas.remove(cpf);
		return "Pessoa removida com sucesso";
	}
    
    public String get(String[] mensagem){
    	
    	String cpf = mensagem[PessoaConsts.CPF].split("=")[1];
    	
    	if(pessoas.size() == 0)
			return "Sem pessoas cadastradas";

		Pessoa pessoa = pessoas.get(cpf);
		if (pessoa == null)
			return "Pessoa n�o encontrada";

		return pessoa.toString();

	}
	
    public String list(){
		if(pessoas.size() == 0)
			return "0";

		String resposta = "";
		resposta += pessoas.size()+" \n";
		for (Map.Entry<String, Pessoa> pessoa : pessoas.entrySet()) {
			resposta += pessoa.getValue().toString()+" \n";
		}

		return resposta;

    }
}
