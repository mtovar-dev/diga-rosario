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
public class ValidarTest {
    
    public ValidarTest() {
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
     * Test of correo method, of class Validar.
     */
    @Test
    public void testnumerosYLetras() {
        System.out.println("numerosYLetras");
        String text = "c-c CENTRO COMERCIAL MACUTO I, C.A.";
        boolean expResult = true;
        boolean result = Validar.numerosYLetras(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}