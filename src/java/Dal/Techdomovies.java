/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-PC
 */
public class Techdomovies {
    int tid;
    int mid;
    
    public int insertTdm(int tid,int mid){
    String sql = "INSERT INTO `tech_do_movies` (`movie_id`, `technician_id`) VALUES ( ?, ?)";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, mid);
            statement.setInt(2, tid);
           

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
    

    
    public int delTdm(int tid,int mid) {
        String sql = "DELETE FROM tech_do_movies WHERE movie_id=? and technician_id=?";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int r = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, mid);
            statement.setInt(2, tid);
           

            r = statement.executeUpdate();

            if (statement != null) {
                statement.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Actor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
}
