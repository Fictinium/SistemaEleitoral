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
public class Voto {
    
    private Eleitor eleitor;
    private Candidato candidato;
    private Eleicao eleicao;

    public Voto(Eleitor eleitor, Candidato candidato, Eleicao eleicao) {
        this.eleitor = eleitor;
        this.candidato = candidato;
        this.eleicao = eleicao;
    }

   
    public Eleitor getEleitor(){
        return this.eleitor;
    }
    
    public Candidato getCandidato(){
        return this.candidato;
    }
    
    public Eleicao getEleicao() {
        return eleicao;
    }
   
}
