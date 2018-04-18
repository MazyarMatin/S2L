/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mmt
 */
public class DB_Test {
    
    public DB_Test() {
        

//    @BeforeClass
//    public static void setUpClass() {
//    }
        System.out.println("");
        System.out.println("Test wird ausgeführt...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Die Testfall");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
