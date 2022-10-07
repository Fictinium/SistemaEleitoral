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
    
    Voto(Eleitor eleitor, Candidato candidato){
        this.eleitor = eleitor;
        this.candidato = candidato;
    }
}
