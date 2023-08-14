package DAO;

import java.util.HashMap;
import java.util.Map;

import consts.CorjaConsts;
import consts.PessoaConsts;
import models.Corja;
import models.Pessoa;

public class CorjaDao {

	private Map<String, Corja> corjas = new HashMap<>();
	private Map<String, Pessoa> membros = new HashMap<>();
	
	private static CorjaDao instance;
	
	private CorjaDao() {}
	
    public static CorjaDao getInstance() {
        if (instance == null)
            instance = new CorjaDao();
        return instance;
    }
    
    public void insert(String[] mensagem){

       String nome = mensagem[CorjaConsts.NOME].split("=")[1];
       String localEsconderijo = mensagem[CorjaConsts.LOCAL_ESCONDERIJO].split("=")[1];
       int anoFundacao = Integer.parseInt(mensagem[CorjaConsts.ANO_FUNDACAO].split("=")[1]);
       
	   Corja corja = new Corja(nome, localEsconderijo, anoFundacao);
	   corjas.put(localEsconderijo, corja);
	}
    
    public String update(String[] mensagem){
    	
        String nome = mensagem[CorjaConsts.NOME].split("=")[1];
        String localEsconderijo = mensagem[CorjaConsts.LOCAL_ESCONDERIJO].split("=")[1];
        int anoFundacao = Integer.parseInt(mensagem[CorjaConsts.ANO_FUNDACAO].split("=")[1]);
    	
    	Corja corja = corjas.get(localEsconderijo);

		if (corja == null)
			return "Corja nï¿½o encontrada!";
		
		corja.setNome(nome);
		corja.setLocalEsconderijo(nome);
		corja.setAnoFundacao(anoFundacao);
		
		return "Corja atualizada com sucesso";
	}
    
    public String delete(String[] mensagem){
    	
    	String localEsconderijo = mensagem[CorjaConsts.LOCAL_ESCONDERIJO].split("=")[1];
    	
		if (corjas.size() == 0)
			return "Sem corjas cadastradas";

		if (corjas.get(localEsconderijo) == null)
			return "Corja nï¿½o encontrada";
		
		corjas.remove(localEsconderijo);
		return "Corja removida com sucesso";
	}
    
    public String get(String[] mensagem){
    	
    	String localEsconderijo = mensagem[CorjaConsts.LOCAL_ESCONDERIJO].split("=")[1];
    	
    	if(corjas.size() == 0)
			return "Sem corjas cadastradas";

		Corja corja = corjas.get(localEsconderijo);
		if (corja == null)
			return "Corja nï¿½o encontrada";

		return corja.toString();
	}
	
    public String list(String[] mensagem){
		if(corjas.size() == 0)
			return "0";

		String resposta = "";
		resposta += corjas.size()+" \n";
		for (Map.Entry<String, Corja> corja : corjas.entrySet()) {
			resposta += corja.getValue().toString()+" \n";
		}

		return resposta;
    }
    
    public String addPessoa(String[] mensagem) {
    	
    	String localEsconderijo = mensagem[CorjaConsts.LOCAL_ESCONDERIJO].split("=")[1];
    	String cpf = mensagem[PessoaConsts.CPF].split("=")[1];
    	PessoaDao pessoaDao = PessoaDao.getInstance();
    	
    	if(corjas.size() == 0)
			return "Sem corjas cadastradas";

		Corja corja = corjas.get(localEsconderijo);
		if (corja == null)
			return "Corja nï¿½o encontrada";
    	    	
    	if(pessoaDao.getPessoas().size() == 0)
			return "Sem pessoas cadastradas";

		Pessoa pessoa = pessoaDao.getPessoas().get(cpf);
		if (pessoa == null)
			return "Pessoa nï¿½o encontrada";
		
		membros.put(cpf, pessoa);
		
		return "Pessoa: "+pessoa.toString()+" adicionada à Corja: "+corja.toString();
    }
    
    public String removePessoa(String[] mensagem) {
    	
    	String localEsconderijo = mensagem[CorjaConsts.LOCAL_ESCONDERIJO].split("=")[1];
    	String cpf = mensagem[PessoaConsts.CPF].split("=")[1];
    	
    	if(corjas.size() == 0)
			return "Sem corjas cadastradas";

		Corja corja = corjas.get(localEsconderijo);
		if (corja == null)
			return "Corja nï¿½o encontrada";
    	
		if (membros.size() == 0)
			return "Sem pessoas vinculadas";

		if (membros.get(cpf) == null)
			return "Pessoa nï¿½o encontrada";
		
		membros.remove(cpf);
		
		return "Pessoa desvínculada com sucesso";
    }
    
    public String listarPessoas(String[] mensagem) {
		
    	if(membros.size() == 0)
			return "0";

		String resposta = "";
		resposta += membros.size()+" \n";
		for (Map.Entry<String, Pessoa> pessoa : membros.entrySet()) {
			resposta += pessoa.getValue().toString()+" \n";
		}

		return resposta;
    }
}
