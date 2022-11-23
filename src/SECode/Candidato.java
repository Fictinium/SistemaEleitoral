/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECode;

/**
 *
 * @author Utilizador
 */
public class Candidato {
    
    private int ID;
    private String nome;
    private int votos;
    
    public Candidato(String nome){
        this.ID = (int)(Math.random()*100000000);
        this.nome = nome;
        this.votos = 0;
    }
    
    public int getId(){
        return this.ID;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getVotos(){
        return this.votos;
    }
    
    public void setVotos(int votos){
        this.votos = votos;
    }
}
