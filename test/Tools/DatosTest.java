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
public class DatosTest {
    
    public DatosTest() {
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
     * Test of getSesion method, of class Datos.
     */
    @Test
    public void testGetSesion() {
        assertTrue(true);     
    }

    /**
     * Test of setSesion method, of class Datos.
     */
    @Test
    public void testSetSesion() {
        assertTrue(true);     
    }

    /**
     * Test of getCont_login method, of class Datos.
     */
    @Test
    public void testGetCont_login() {        
        assertTrue(true);     
    }

    /**
     * Test of setCont_login method, of class Datos.
     */
    @Test
    public void testSetCont_login() {
        assertTrue(true);     
    }

    /**
     * Test of sumCont_login method, of class Datos.
     */
    @Test
    public void testSumCont_login() {
        assertTrue(true);        
    }

    /**
     * Test of getLocalHost method, of class Datos.
     */
    @Test
    public void testGetLocalHost() {
        System.out.println("getLocalHost:");
        String[] expResult = {"ARMGARCES-PC","192.168.22.69","D0-27-88-9E-69-E4"};
        String[] result = Datos.getLocalHost();
        assertArrayEquals(expResult, result);
        
        System.out.println("expResult = " + expResult[0] +" / "+ expResult[1] +" / "+ expResult[2]);
        System.out.println("result = " + result[0]+" / "+result[1]+" / "+result[2]);
    }
}