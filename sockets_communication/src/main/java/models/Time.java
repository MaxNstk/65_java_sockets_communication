package models;

import java.util.ArrayList;
import java.util.List;

public class Time {

    String nome;

    public Time(String nome, int anoFundacao) {
        this.nome = nome;
        this.anoFundacao = anoFundacao;
        this.membros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public void setMembros(List<Pessoa> membros) {
        this.membros = membros;
    }

    int anoFundacao;
    List<Pessoa> membros;
}
