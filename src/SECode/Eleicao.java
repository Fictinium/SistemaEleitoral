/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECode;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Utilizador
 */
public class Eleicao {

    private String nome;
    private Date dataInicio;
    private Date dataFim;
    private ArrayList<Candidato> candidatos;
    private ArrayList<Eleitor> eleitores;
    
    Eleicao(String nome, Date dataInicio, Date dataFim){
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.candidatos = new ArrayList<Candidato>();
        this.eleitores = new ArrayList<Eleitor>();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public Date getDataInicio(){
        return this.dataInicio;
    }
    
    public void setDataInicio(Date dataInicio){
        this.dataInicio = dataInicio;
    }
    
    public Date getDataFim(){
        return this.dataFim;
    }
    
    public void setDataFim(Date dataFim){
        this.dataFim = dataFim;
    }
    
    public ArrayList<Candidato> getListaCandidatos(){
        return this.candidatos;
    }
    
    public ArrayList<Eleitor> getListaEleitores(){
        return this.eleitores;
    }
    
    public void addCandidato(Candidato candidato){
        this.candidatos.add(candidato);
    }
    
    public void addEleitor(Eleitor eleitor){
        this.eleitores.add(eleitor);
    }
}
