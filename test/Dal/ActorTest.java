/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.util.ArrayList;
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
public class ActorTest {
    
    public ActorTest() {
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
     * Test of randomWeightsSet method, of class Actor.
     */
//    @Test
//    public void testRandomWeightsSet() {
//        System.out.println("randomWeightsSet");
//        Actor instance = new Actor();
//        instance.randomWeightsSet();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of summation method, of class Actor.
//     */
//    @Test
//    public void testSummation() {
//        System.out.println("summation");
//        Actor instance = new Actor();
//        instance.summation();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of activation method, of class Actor.
//     */
//    @Test
//    public void testActivation() {
//        System.out.println("activation");
//        Actor instance = new Actor();
//        instance.activation();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of errorCalculation method, of class Actor.
//     */
//    @Test
//    public void testErrorCalculation() {
//        System.out.println("errorCalculation");
//        Actor instance = new Actor();
//        instance.errorCalculation();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of backpropagation method, of class Actor.
//     */
//    @Test
//    public void testBackpropagation() {
//        System.out.println("backpropagation");
//        double rw = 0.0;
//        Actor instance = new Actor();
//        double expResult = 0.0;
//        double result = instance.backpropagation(rw);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of prediction method, of class Actor.
//     */
//    @Test
//    public void testPrediction() {
//        System.out.println("prediction");
//        double pramw = 0.0;
//        Actor instance = new Actor();
//        instance.prediction(pramw);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of feedfoward method, of class Actor.
//     */
//    @Test
//    public void testFeedfoward() {
//        System.out.println("feedfoward");
//        Actor instance = new Actor();
//        instance.feedfoward();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of insertActor method, of class Actor.
     */
    @Test
    public void testInsertActor() {
        System.out.println("insertActor");
        String name = "Vishal";
        int rank = 18;
        boolean gender = false;
        Actor instance = new Actor();
        int expResult = 1;
        int result = instance.insertActor(name, rank, gender);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteActor method, of class Actor.
     */
    @Test
    public void testDeleteActor() {
        System.out.println("deleteActor");
        int id = 13;
        Actor instance = new Actor();
        int expResult = 1;
        int result = instance.deleteActor(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateActorRank method, of class Actor.
     */
    @Test
    public void testUpdateActorRank() {
        System.out.println("updateActorRank");
        int rank = 9;
        int id = 10;
        Actor instance = new Actor();
        int expResult = 1;
        int result = instance.updateActorRank(rank, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateActor method, of class Actor.
     */
    @Test
    public void testUpdateActor() {
        System.out.println("updateActor");
        String name = "Ajith Kumar";
        int rank = 3;
        boolean gender = false;
        int id = 6;
        Actor instance = new Actor();
        int expResult = 1;
        int result = instance.updateActor(name, rank, gender, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectActors method, of class Actor.
     */
//    @Test
//    public void testSelectActors() {
//        System.out.println("selectActors");
//        Actor instance = new Actor();
//        ArrayList<Actor> expResult = null;
//        ArrayList<Actor> result = instance.selectActors();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectActorById method, of class Actor.
//     */
//    @Test
//    public void testSelectActorById() {
//        System.out.println("selectActorById");
//        int id = 0;
//        Actor instance = new Actor();
//        ArrayList<Actor> expResult = null;
//        ArrayList<Actor> result = instance.selectActorById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
