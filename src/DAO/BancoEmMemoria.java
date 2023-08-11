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
        String s = "";
         for (String m:mensagem){
             s+=m;
         };
         return s;
    }

    public String deletePessoa(String[] mensagem) {
        String s = "";
        for (String m:mensagem){
            s+=m;
        };
        return s;
    }

    public String listPessoas(String[] mensagem) {
        String s = "";
        for (String m:mensagem){
            s+=m;
        };
        return s;
    }

    public String getPessoa(String[] mensagem) {
        String s = "";
        for (String m:mensagem){
            s+=m;
        };
        return s;
    }
}