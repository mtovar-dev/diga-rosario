/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.security.*; 
import javax.crypto.Cipher; 
import javax.crypto.spec.SecretKeySpec; 
import sun.misc.*; 

/**
 *
 * @author MITM
 */
public class Protector {
    private static final String ALGORITHM = "AES"; 
    private static final int ITERATIONS = 2; 
    private static final byte[] keyValue = new byte[] { 'D', 'i', 'g', 'a', ',', 'E', 's', ',', 'L', 'o', ',', 'M', 'e', 'j', 'o', 'r'};      

    /**
     * 
     * @param value
     * @param salt
     * @return
     * @throws Exception 
     */
    public static String encrypt(String value, String salt) throws Exception{ 
        Key key = generateKey(); 
        Cipher c = Cipher.getInstance(ALGORITHM); 
        c.init(Cipher.ENCRYPT_MODE, key); 
        String eValue = value; 
        for (int i = 0; i < ITERATIONS; i++) { 
            String valueToEnc = salt + eValue; 
            byte[] encValue = c.doFinal(valueToEnc.getBytes()); 
            eValue = new BASE64Encoder().encode(encValue); 
        }
        return eValue; 
    } 
    
    /**
     * 
     * @param value
     * @param salt
     * @return
     * @throws Exception 
     */
    public static String decrypt(String value, String salt) throws Exception{ 
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM); 
        c.init(Cipher.DECRYPT_MODE, key); 
        String dValue = null; 
        String valueToDecrypt = value; 
        for (int i = 0; i < ITERATIONS; i++) { 
            byte[] decordedValue = new BASE64Decoder().decodeBuffer(valueToDecrypt);
            byte[] decValue = c.doFinal(decordedValue); 
            dValue = new String(decValue).substring(salt.length()); 
            valueToDecrypt = dValue; 
        } 
        return dValue; 
    } 
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    private static Key generateKey() throws Exception 
    { 
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        // SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM); 
        // key = keyFactory.generateSecret(new DESKeySpec(keyValue)); 
       return key; 
    } 

}
