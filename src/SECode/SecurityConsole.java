/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECode;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import utils.SecurityUtils;

/**
 *
 * @author Utilizador
 */
public class SecurityConsole{
    
    public static void createAssimKeys(Eleitor eleitor) throws Exception{
        
        byte[] pass = (eleitor.getEmail() + eleitor.getPassword()).getBytes(Charset.forName("UTF-8"));
        
        KeyPair kp = SecurityUtils.generateRSAKeyPair(2048);
        SecurityUtils.saveKey(kp, "keypair");
        
        byte[] encryptedPass = SecurityUtils.encrypt(pass, kp.getPublic());
        Files.write(Paths.get(eleitor.getEmail() + "EncryptedPassword"), encryptedPass);
        
        eleitor.setPrivateKey(kp.getPrivate());
        SecurityUtils.saveKey(kp.getPrivate(), eleitor.getEmail() + "PrivateKey");
    }
}
