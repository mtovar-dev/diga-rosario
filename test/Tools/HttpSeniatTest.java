/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tools;

import Objects.Seniat.ValidateRif;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MITM
 */
public class HttpSeniatTest {
    
    public HttpSeniatTest() {
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
     * Test of getSeniat method, of class ValidateRif.
     */
    @Test
    public void testGetHttpSeniat() {
        System.out.println("getHttpSeniat");
        String sRif = "j301548973";
        ValidateRif expResult = null;
        ValidateRif result = HttpSeniat.getHttpSeniat(sRif);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeniatCedula method, of class ValidateRif.
     */
    @Test
    public void testGetHttpSeniatCedula() {
        System.out.println("getHttpSeniatCedula");
        String sCedula = "12573510";
        ValidateRif expResult = null;
        ValidateRif result = HttpSeniat.getHttpSeniatCi(sCedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
