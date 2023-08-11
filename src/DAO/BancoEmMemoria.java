package DAO;

import models.Corja;
import models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class BancoEmMemoria {

    private static BancoEmMemoria instance;
    private List<Pessoa> pessoas;
    private List<Corja> corjas;

    private BancoEmMemoria() {
        this.corjas = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }

    public static BancoEmMemoria getInstance() {
        if (instance == null)
            instance = new BancoEmMemoria();
        return instance;
    }

    public void insertPessoa(String[] mensagem) {
    }

    public String updatePessoa(String[] mensagem) {
        return "";
    }

    public String deletePessoa(String[] mensagem) {
        return "";
    }

    public String listPessoas(String[] mensagem) {
        return "";
    }

    public String getPessoa(String[] mensagem) {
        return "";
    }
}
