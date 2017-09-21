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
public class Actordomovies {
    int aid;
    int mid;
    
    public int insertAdm(int aid,int mid){
    String sql = "INSERT INTO `actor_do_movies` (`movie_id`, `actor_id`) VALUES ( ?, ?)";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, mid);
            statement.setInt(2, aid);
           

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
    

    
    public int delAdm(int aid,int mid) {
        String sql = "DELETE FROM actor_do_movies WHERE movie_id=? and actor_id=?";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, mid);
            statement.setInt(2, aid);
           

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
