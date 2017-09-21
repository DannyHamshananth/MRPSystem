/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Apple
 */
public class Actor {

    public double avg;
    public double ramw;
    public double result;
    public double bias = 1;
    public double sum;
    public double sigmoid;
    public double err;
    public double desiredOutput;
    public double desiredsig;
    
    public int id;
    public String name;
    public String gender;
    public int rank;

    public Actor(int id, String name, String gender, int rank) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.rank = rank;
    }

    public Actor() {
    }

    public Actor(double avg, double desiredOutput) {
        this.avg = avg;
        this.desiredOutput = desiredOutput;
    }

    public void randomWeightsSet() {
        double maximum = 1;
        double minimum = 0;
        double temp;

        double rand = new Random().nextDouble();
        double randomWeights = minimum + (rand * (maximum - minimum));
        temp = randomWeights;
        System.out.println("Random weight :- " + temp);
        this.result = temp * avg;
        this.ramw = temp;
        System.out.println("Random weight * Input :- " + result);

    }

    public void summation() {
        this.sum = result + bias;
        System.out.println("weighted value + bias :- " + sum);
    }

    public void activation() {
        this.sigmoid = 1 / (1 + Math.exp(-sum));
        System.out.println("Sigmoid Value :- " + sigmoid);
    }

    public void errorCalculation() {
        this.desiredsig = 1 / (1 + Math.exp(-this.desiredOutput + 1));
        this.err = desiredsig - sigmoid;
        System.out.println("Desired Sigmoid :- " + desiredsig);
        System.out.println("Error value :- " + err);
    }

    public double backpropagation(double rw) {
        double cramw = rw;
        for (int i = 1; i < 1000; i++) {
            cramw = cramw + err * avg * 0.05;
            //System.out.println("Corrected weight :- " + cramw);
        }
        return cramw;

    }

    public void prediction(double pramw) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Predicted percentage :- " + df.format(pramw * 100) + "%");

    }

    public void feedfoward() {
        randomWeightsSet();
        summation();
        activation();
        errorCalculation();
    }

//    public static void main(String[] args) {
//        Actor a = new Actor();
//        a.randomWeightsSet();
//        a.summation();
//        a.activation();
//        a.errorCalculation();
//        double crmw=a.backpropagation(a.ramw);
//        a.prediction(crmw);
//    }
    public int insertActor(String name, int rank, boolean gender) {
        String sql = "INSERT INTO `actor` (`actor_name`, `actor_rank`, `actor_gender`) VALUES ( ?, ?, ?)";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, rank);
            statement.setBoolean(3, gender);

            rowsInserted = statement.executeUpdate();

            if (statement != null) {
                statement.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Actor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsInserted;

    }
    

    
    public int deleteActor(int id) {
        String sql = "DELETE FROM actor WHERE actor_id=?";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
           

            rowsInserted = statement.executeUpdate();

            if (statement != null) {
                statement.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Actor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsInserted;

    }
    
    public int updateActorRank(int rank, int id) {
        String sql = "UPDATE `actor` SET `actor_rank`= ? WHERE `actor`.`actor_id` = ?";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            
            statement.setInt(1, rank);
           
            statement.setInt(2, id);

            rowsInserted = statement.executeUpdate();

            if (statement != null) {
                statement.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Actor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsInserted;

    }
    
    public int updateActor(String name,int rank,boolean gender, int id) {
        String sql = "UPDATE `actor` SET `actor_name`=?, `actor_rank`=?,  `actor_gender`=? WHERE `actor`.`actor_id` = ?";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            
            statement.setString(1, name);
            
            statement.setInt(2, rank);
           
            statement.setBoolean(3, gender);
            
            statement.setInt(4, id);

            rowsInserted = statement.executeUpdate();

            if (statement != null) {
                statement.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Actor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsInserted;

    }
    
    public ArrayList<Actor> selectActors() {
        ArrayList<Actor> aclist = new ArrayList<>();
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        String query = "SELECT actor.actor_id,actor.actor_name,case when actor.actor_gender=0 then 'Male' else 'Female' end AS GENDER,actor.actor_rank FROM `actor`";

        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Actor a = new Actor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                aclist.add(a);

            }
        } catch (Exception e) {

        }
        return aclist;
    }
    
    public ArrayList<Actor> selectActorById(int id) {
        ArrayList<Actor> aclist = new ArrayList<>();
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        String query = "SELECT actor.actor_id,actor.actor_name,case when actor.actor_gender=0 then 'Male' else 'Female' end AS GENDER,actor.actor_rank FROM `actor` where actor.actor_id="+ id;

        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Actor a = new Actor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                aclist.add(a);

            }
        } catch (Exception e) {

        }
        return aclist;
    }

}
