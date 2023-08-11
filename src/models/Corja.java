package models;

import java.util.ArrayList;
import java.util.List;

public class Corja {

    private String localEsconderijo;
    private int anoFundacao;
    private List<Pessoa> membros;

    public Corja() {
        this.membros = new ArrayList<>();
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
}
