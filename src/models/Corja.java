package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Corja {

    private String nome;
    private String localEsconderijo;
    private int anoFundacao;
    private Map<String, Pessoa> membros;

    public Corja(String nome, String localEsconderijo, int anoFundacao) {
        this.nome = nome;
        this.localEsconderijo = localEsconderijo;
        this.anoFundacao = anoFundacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocalEsconderijo() {
        return localEsconderijo;
    }

    public void setLocalEsconderijo(String localEsconderijo) {
        this.localEsconderijo = localEsconderijo;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public void addPessoa(Pessoa pessoa) {
    	membros.put(pessoa.getCpf(), pessoa);
    }
    
    public boolean removePessoa(String cpf) {
    	if (membros.get(cpf) != null) {
    		membros.remove(cpf);
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public Pessoa getPessoa(String cpf) {
    	return membros.get(cpf);
    }
    
    public List<Pessoa> listarPessoas() {
        return new ArrayList<>(membros.values());
    }
    
    @Override
    public String toString() {
        return this.nome+" - "+this.localEsconderijo+" - "+this.anoFundacao;
    }
}
