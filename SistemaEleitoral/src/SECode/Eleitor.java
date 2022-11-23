/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECode;

import java.security.Key;
import java.util.ArrayList;

/**
 *
 * @author Utilizador
 */
public class Eleitor {
    
    private int ID;
    private String nome;
    private String email;
    private String password;
    private Key privateKey;
    private ArrayList<Candidato> votacoes;
    
    public Eleitor(String nome, String email, String password){
        this.ID = (int)(Math.random()*100000000);
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.votacoes = new ArrayList<Candidato>();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    protected String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public Key getPrivateKey(){
        return privateKey;
    }
    
    protected void setPrivateKey(Key key){
        this.privateKey = key;
    }
    
    public ArrayList<Candidato> getListaVotacoes(){
        return this.votacoes;
    }
    
    public void addVotacao(Candidato candidato){
        this.votacoes.add(candidato);
    }
}
