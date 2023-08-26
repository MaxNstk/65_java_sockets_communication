package dao;

import java.util.HashMap;
import java.util.Map;

import models.Corja;
import models.Pessoa;

public class CorjaDao {

	private Map<String, Corja> corjas = new HashMap<>();
	
	private static CorjaDao instance;
	
	private CorjaDao() {}
	
    public static CorjaDao getInstance() {
        if (instance == null)
            instance = new CorjaDao();
        return instance;
    }
    
    public void insert(String[] mensagem){

       String nome = mensagem[2].split("=")[1];
       String localEsconderijo = mensagem[3].split("=")[1];
       int anoFundacao = Integer.parseInt(mensagem[4].split("=")[1]);
       
	   Corja corja = new Corja(nome, localEsconderijo, anoFundacao);
	   corjas.put(nome, corja);
	}
    
    public String update(String[] mensagem){
    	
        String nome = mensagem[2].split("=")[1];
        String localEsconderijo = mensagem[3].split("=")[1];
        int anoFundacao = Integer.parseInt(mensagem[4].split("=")[1]);
    	
    	Corja corja = corjas.get(nome);

		if (corja == null)
			return "Corja não encontrada!";
		
		corja.setNome(nome);
		corja.setLocalEsconderijo(localEsconderijo);
		corja.setAnoFundacao(anoFundacao);
		
		return "Corja atualizada com sucesso";
	}
    
    public String delete(String[] mensagem){
    	
    	String nome = mensagem[2].split("=")[1];
    	
		if (corjas.size() == 0)
			return "Sem corjas cadastradas";

		if (corjas.get(nome) == null)
			return "Corja não encontrada";
		
		corjas.remove(nome);
		return "Corja removida com sucesso";
	}
    
    public String get(String[] mensagem){
    	
    	String nome = mensagem[2].split("=")[1];
    	
    	if(corjas.size() == 0)
			return "Sem corjas cadastradas";

		Corja corja = corjas.get(nome);
		if (corja == null)
			return "Corja não encontrada";

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
    	
    	String nome = mensagem[2].split("=")[1];
    	String cpf = mensagem[3].split("=")[1];
    	PessoaDao pessoaDao = PessoaDao.getInstance();
    	
    	if(corjas.size() == 0)
			return "Sem corjas cadastradas";

		Corja corja = corjas.get(nome);
		if (corja == null)
			return "Corja não encontrada";
    	    	
    	if(pessoaDao.getPessoas().size() == 0)
			return "Sem pessoas cadastradas";

		Pessoa pessoa = pessoaDao.getPessoas().get(cpf);
		if (pessoa == null)
			return "Pessoa não encontrada";
		
		corja.getMembros().put(cpf, pessoa);
		
		return "Pessoa: "+pessoa.toString()+" adicionada ï¿½ Corja: "+corja.toString();
    }
    
    public String removePessoa(String[] mensagem) {
    	
    	String nome = mensagem[2].split("=")[1];
    	String cpf = mensagem[3].split("=")[1];
    	
    	if(corjas.size() == 0)
			return "Sem corjas cadastradas";

		Corja corja = corjas.get(nome);
		if (corja == null)
			return "Corja não encontrada";
    	
		if(corja.getMembros().size() == 0)
			return "Sem pessoas vinculadas";

		if(corja.getMembros().get(cpf) == null)
			return "Pessoa não encontrada";
		
		corja.getMembros().remove(cpf);
		
		return "Pessoa desvinculada com sucesso";
    }
    
    public String listarPessoas(String[] mensagem) {
		
    	String nome = mensagem[2].split("=")[1];
    	
    	if(corjas.size() == 0)
			return "Sem corjas cadastradas";

		Corja corja = corjas.get(nome);
		if (corja == null)
			return "Corja não encontrada";
    	
		Map<String, Pessoa> membros = corja.getMembros();
		
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
