/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECode;

import java.util.ArrayList;

/**
 *
 * @author Utilizador
 */
public class Eleitor {
    
    private int ID;
    private String nome;
    private ArrayList<Candidato> votacoes;
    
    Eleitor(String nome){
        this.ID = (int)(Math.random()*100000000);
        this.nome = nome;
        this.votacoes = new ArrayList<Candidato>();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public ArrayList<Candidato> getListaVotacoes(){
        return this.votacoes;
    }
    
    public void addVotacao(Candidato candidato){
        this.votacoes.add(candidato);
    }
}
