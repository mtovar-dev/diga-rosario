/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ARMGARCES
 */
public class ProtectorTest {
    
    public ProtectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of encrypt method, of class Protector.
     */
    @Test
    public void testEncrypt() throws Exception {
        System.out.println("*************************************************");
        System.out.println("encrypt");
        String value = "192.168.0.16";
        String salt = java.util.ResourceBundle.getBundle("BD/DBcon").getString("dns");
        
        String result    = Protector.encrypt(value , salt);
        String expResult = Protector.decrypt(result, salt);
        
        System.out.println("result = " + result);
        
        assertEquals(expResult, value);
    }

    /**
     * Test of decrypt method, of class Protector.
     */
    @Test
    public void testDecrypt() throws Exception {
        System.out.println("*************************************************");
        System.out.println("decrypt");
        //String value = java.util.ResourceBundle.getBundle("BD/DBcon").getString("password");
        String value = "iooqIg2MEG9AzuQDFDylBzdtUkOLX7+G85pb3x5DaEeRLgk66MoGPXWXH0ErFu/e9UnscHVEFj+h0H7m89eT743lmpKVb64WQK/L7NHx3fhZwz5DarhmSl0e7TLbSSdU";
        String salt = java.util.ResourceBundle.getBundle("BD/DBcon").getString("dns");
        
        String expResult = "192.168.0.16";
        
        String result = Protector.decrypt(value, salt);
        
        System.out.println("value = " + value);
        System.out.println("result = " + result);
        System.out.println("expResult = " + expResult);
        
        assertEquals(expResult, result);
    }
}