/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilizador
 */
public class ThreadMineira extends Thread {
    
    int dificulty;
    String data;
    int MAX_NONCE;
    int nonce;
    AtomicInteger ticket = new AtomicInteger();
    AtomicBoolean match = new AtomicBoolean(false);
    
    public ThreadMineira(int difficulty, String data, int MAX_NONCE){
        this.dificulty = difficulty;
        this.data = data;
        this.MAX_NONCE = MAX_NONCE;
    }
    
    @Override
    public void run(){
        //String of zeros
        String zeros = String.format("%0" + dificulty + "d", 0);
        //int helper for next nonce
        int nextNonce;
        //starting nonce
        while(match.get() == false && (nextNonce = ticket.getAndIncrement()) < MAX_NONCE){
            try {
                //calculate hash of block
                String hash = getHash(nextNonce + data);
                //Nounce found
                if (hash.startsWith(zeros)){
                //if (nextNonce == 5){
                    nonce = nextNonce;
                    match.getAndSet(true);
                }
            } catch (Exception ex) {
                Logger.getLogger(ThreadMineira.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String getHash(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] h = md.digest(data.getBytes());
        return Base64.getEncoder().encodeToString(h);
    }
    
    public static String calculateNonce(int dificulty, String data, int MAX_NONCE) throws InterruptedException{
        //----------- parametrizar o algoritmo para computador actual ---------
        int numProcessors = Runtime.getRuntime().availableProcessors();
        
        //array de Threads
        ThreadMineira[] thr = new ThreadMineira[numProcessors];
        //----- construir e por a threads a correr -----------
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new ThreadMineira(dificulty, data, MAX_NONCE);
            thr[i].start();
        }
        //----- esperar que a threads concluam o trabalho ------
        int nonce = 0;
        for(ThreadMineira thr1: thr){
            thr1.join();
            nonce = thr1.nonce;
        }
        
        //int nonce = thr[0].nonce;
        
        //return nonce;
        return String.valueOf(nonce);
    }
    
    public static void main(String[] args) throws Exception {
        System.out.print(calculateNonce(3, "data", 10000));
    }
}
