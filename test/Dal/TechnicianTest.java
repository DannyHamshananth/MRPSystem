/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS-PC
 */
public class TechnicianTest {
    
    public TechnicianTest() {
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
     * Test of randomWeightsSet method, of class Technician.
     */
//    @Test
//    public void testRandomWeightsSet() {
//        System.out.println("randomWeightsSet");
//        Technician instance = new Technician();
//        instance.randomWeightsSet();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of summation method, of class Technician.
//     */
//    @Test
//    public void testSummation() {
//        System.out.println("summation");
//        Technician instance = new Technician();
//        instance.summation();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of activation method, of class Technician.
//     */
//    @Test
//    public void testActivation() {
//        System.out.println("activation");
//        Technician instance = new Technician();
//        instance.activation();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of errorCalculation method, of class Technician.
//     */
//    @Test
//    public void testErrorCalculation() {
//        System.out.println("errorCalculation");
//        Technician instance = new Technician();
//        instance.errorCalculation();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of backpropagation method, of class Technician.
//     */
//    @Test
//    public void testBackpropagation() {
//        System.out.println("backpropagation");
//        double rw = 0.0;
//        Technician instance = new Technician();
//        double expResult = 0.0;
//        double result = instance.backpropagation(rw);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of prediction method, of class Technician.
//     */
//    @Test
//    public void testPrediction() {
//        System.out.println("prediction");
//        double pramw = 0.0;
//        Technician instance = new Technician();
//        instance.prediction(pramw);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of feedfoward method, of class Technician.
//     */
//    @Test
//    public void testFeedfoward() {
//        System.out.println("feedfoward");
//        Technician instance = new Technician();
//        instance.feedfoward();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of insertTechnician method, of class Technician.
     */
//    @Test
//    public void testInsertTechnician() {
//        System.out.println("insertTechnician");
//        String name = "Nalan Kumaraswamy";
//        int rank = 20;
//        int role_id = 1;
//        Technician instance = new Technician();
//        int expResult = 1;
//        int result = instance.insertTechnician(name, rank, role_id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of updateTechnician method, of class Technician.
     */
    @Test
    public void testUpdateTechnician() {
        System.out.println("updateTechnician");
        String name = "A.R.Rahman";
        int rank = 1;
        int role_id = 3;
        int techid = 5;
        Technician instance = new Technician();
        int expResult = 1;
        int result = instance.updateTechnician(name, rank, role_id, techid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTechnician method, of class Technician.
     */
//    @Test
//    public void testDeleteTechnician() {
//        System.out.println("deleteTechnician");
//        int techid = 8;
//        Technician instance = new Technician();
//        int expResult = 1;
//        int result = instance.deleteTechnician(techid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
}
