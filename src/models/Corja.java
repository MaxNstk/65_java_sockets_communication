package models;

import java.util.ArrayList;
import java.util.List;

public class Corja {

    private String nome;
    private String localEsconderijo;
    private int anoFundacao;
    private List<Pessoa> membros;

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

    @Override
    public String toString() {
        String retorno = ;
    }
}
