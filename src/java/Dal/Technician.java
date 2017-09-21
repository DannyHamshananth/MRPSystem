/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-PC
 */
public class Technician {
     public double avg;
    public double ramw;
    public double result;
    public double bias = 1;
    public double sum;
    public double sigmoid;
    public double err;
    public double desiredOutput;
    public double desiredsig;

    public Technician() {
    }

    
    public Technician(double avg, double desiredOutput) {
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
        double cramw=rw;
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
    
    public int insertTechnician(String name, int rank, int role_id) {
        String sql = "INSERT INTO `technician` (`tech_name`, `role_id`, `tech_rank`) VALUES ( ?, ?, ?)";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, role_id);
            statement.setInt(3, rank);

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
    
    public int updateTechnician(String name, int rank, int role_id,int techid) {
        String sql = "update `technician` set `tech_name`=?,`role_id`=?, `tech_rank`=? where tech_id=?";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, role_id);
            statement.setInt(3, rank);
            statement.setInt(4, techid);

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
    public int deleteTechnician(int techid) {
        String sql = "delete from technician where tech_id=?";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, techid);
            

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
}
