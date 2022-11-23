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
import java.util.Arrays;
import security.integrity.Integrity;
import utils.SecurityUtils;

/**
 *
 * @author Utilizador
 */
public class SecurityConsole{
    
    public static void createAssimKeys(Eleitor eleitor) throws Exception{
        //transformação da palavra-passe inserida num hash dos bytes correspondentes
        byte[] passwordBytes = (eleitor.getPassword()).getBytes(Charset.forName("UTF-8"));
        byte[] passwordHash = Integrity.getHash(passwordBytes, "SHA-256");
        String passwordHashString = Arrays.toString(passwordHash);
        //criação da palavra-passe secreta (do sistema) para o utilizador, em bytes
        byte[] pass = (eleitor.getEmail() + passwordHashString).getBytes(Charset.forName("UTF-8"));
        //criação de um novo par de chaves assimétricas
        KeyPair kp = SecurityUtils.generateRSAKeyPair(2048);
        //guardar o par de chaves num ficheiro exclusivo
        SecurityUtils.saveKey(kp, eleitor.getEmail() + "KeyPair");
        //encriptar a palavra-passe criada anteriormente com a chave pública do par de chaves criado
        byte[] encryptedPass = SecurityUtils.encrypt(pass, kp.getPublic());
        //guardar a palavra-passe encriptada num ficheiro exclusivo
        Files.write(Paths.get(eleitor.getEmail() + "EncryptedPassword"), encryptedPass);
        //atribuir a chave privada ao utilizador
        eleitor.setPrivateKey(kp.getPrivate());
    }
}
