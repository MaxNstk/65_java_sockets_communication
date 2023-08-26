package dao;

import java.util.HashMap;
import java.util.Map;

import models.Saqueador;

public class SaqueadorDao {

	private Map<String, Saqueador> saqueadores = new HashMap<>();;
	private static SaqueadorDao instance;
	
	private SaqueadorDao() {}
	
    public static SaqueadorDao getInstance() {
        if (instance == null)
            instance = new SaqueadorDao();
        return instance;
    }
    
    public Map<String, Saqueador> getSaqueadors(){
    	return this.saqueadores;
    }
    
    public void insert(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	double valorSaqueado = Double.parseDouble(mensagem[5].split("=")[1]);
    	
    	Saqueador saqueador = new Saqueador(nome, cpf, endereco, valorSaqueado);
   
    	saqueadores.put(cpf, saqueador);
	}
    
    public String update(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	String nome = mensagem[3].split("=")[1];
    	String endereco = mensagem[4].split("=")[1];
    	double valorSaqueado = Double.parseDouble(mensagem[5].split("=")[1]);
    	
    	Saqueador saqueador = saqueadores.get(cpf);

		if (saqueador == null)
			return "Saqueador não encontrado!";
		
		saqueador.setNome(nome);
		saqueador.setEndereco(endereco);
		saqueador.setValorSaqueado(valorSaqueado);
		
		return "Saqueador atualizado com sucesso";
	}
    
    public String delete(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
		if (saqueadores.size() == 0)
			return "Sem saqueadores cadastrados";

		if (saqueadores.get(cpf) == null)
			return "Saqueador não encontrado";
		
		saqueadores.remove(cpf);
		return "Saqueador removido com sucesso";
	}
    
    public String get(String[] mensagem){
    	
    	String cpf = mensagem[2].split("=")[1];
    	
    	if(saqueadores.size() == 0)
			return "Sem saqueadores cadastrados";

		Saqueador saqueador = saqueadores.get(cpf);
		if (saqueador == null)
			return "Saqueador não encontrado";

		return saqueador.toString();

	}
	 
    public String list(){

		if(saqueadores.size() == 0)
			return "0";

		String resposta = "";
		resposta += saqueadores.size()+" \n";
		for (Map.Entry<String, Saqueador> saqueador : saqueadores.entrySet()) {
			resposta += saqueador.getValue().toString()+" \n";
		}

		return resposta;
    }

}
