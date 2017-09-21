/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-PC
 */
public class Movie {

    int movie_id;
    double avg_actor_rating;
    double avg_tech_rating;
    double avg_final;
    ArrayList<Double> avg;
    ArrayList<Double> rank;
    ArrayList<Double> prating;
    ArrayList<Double> avg_tech;
    ArrayList<Double> rank_tech;
    ArrayList<Double> prating_tech;

    public String getMovieName(int mid) {
        String query = "select movie.movie_name from movie where movie.movie_id=" + mid;
        String mname = null;

        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();

        ResultSet rs = null;

        try {

            Statement stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                mname = rs.getString(1);

            }

        } catch (SQLException e) {

        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return mname;

    }

    public int insertMovie(String mname, double aggrating, int pid, Date rel_date) {
        String sql = "INSERT INTO `movie` (`movie_name`, `agg_rating`, `producer_id`, `rel_date`) VALUES (?, ?, ?, ?)";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;
        
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, mname);
            statement.setFloat(2, (float) aggrating);
            statement.setInt(3, pid);
            statement.setDate(4, rel_date);

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
    public int updateMovie(String mname, double aggrating, int pid, Date rel_date,int movie_id) {
        String sql = "update `movie` set `movie_name`=?, `agg_rating`=?, `producer_id`=?, `rel_date`=? where movie.movie_id=?";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsInserted = 0;
        
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, mname);
            statement.setFloat(2, (float) aggrating);
            statement.setInt(3, pid);
            statement.setDate(4, rel_date);
            statement.setInt(5, movie_id);

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
    
    public int deleteMovie(int id) {
        String sql = "DELETE FROM movie WHERE movie_id=?";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();
        int rowsdel = 0;

        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
           

            rowsdel = statement.executeUpdate();

            if (statement != null) {
                statement.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Actor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsdel;

    }

    public void getActorAvg(int m_id) {
        String q1 = "SELECT actor_do_movies.actor_id,AVG(movie.agg_rating) FROM actor_do_movies INNER JOIN movie ON actor_do_movies.movie_id=movie.movie_id WHERE actor_do_movies.actor_id IN (SELECT actor_do_movies.actor_id FROM actor_do_movies WHERE actor_do_movies.movie_id=" + m_id + ") GROUP BY actor_do_movies.actor_id";

        avg = new ArrayList<>();

        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();

        ResultSet rs = null;

        try {

            Statement stmt = con.createStatement();

            rs = stmt.executeQuery(q1);

            while (rs.next()) {
                double avg1 = rs.getFloat(2);
                avg.add(avg1);
                System.out.println(avg1);

            }

        } catch (SQLException e) {

        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void getActorRank(int m_id) {

        String q1 = "SELECT actor.actor_id,(1-(actor.actor_rank/25))*100 AS Ranking FROM actor WHERE actor.actor_id IN (SELECT actor_do_movies.actor_id FROM actor_do_movies WHERE actor_do_movies.movie_id=" + m_id + ") GROUP BY actor.actor_id";
        rank = new ArrayList<>();

        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();

        ResultSet rs = null;

        try {

            Statement stmt = con.createStatement();

            rs = stmt.executeQuery(q1);

            while (rs.next()) {
                double rank1 = rs.getFloat(2);
                rank.add(rank1);
                System.out.println(rank1);

            }

        } catch (SQLException e) {

        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void getPredictedList() {
        prating = new ArrayList<>();
        for (int i = 0; i < avg.size(); i++) {
            double pavg = getPredictedAvg(avg.get(i), rank.get(i));
            System.out.println(pavg);
            prating.add(pavg);

        }

        for (int i = 0; i < prating.size(); i++) {

            System.out.println(prating.get(i));

        }

    }

    public void findActorAvg() {
        double t_rating = 0;
        double a_rating = 0;

        for (int i = 0; i < prating.size(); i++) {

            t_rating = t_rating + prating.get(i);

        }
        a_rating = t_rating / prating.size();
        avg_actor_rating = a_rating;

        System.out.println("Avg for cast " + a_rating);

    }

    public double getPredictedAvg(double avg, double exp) {
        Actor a = new Actor(avg, exp);
        a.randomWeightsSet();
        a.summation();
        a.activation();
        a.errorCalculation();
        double crmw = a.backpropagation(a.ramw);
        //a.prediction(crmw);
        double crmw2 = (double) Math.round(crmw * 100);
        if (crmw2 > 100) {
            return 100;
        }
        if (crmw2 < 0) {
            return 0;
        }

        System.out.println(crmw2);
        return crmw2;

    }

    //Tech-----------------------------------------------------------------------------------------------------------------
    public void getTechAvg(int m_id) {
        String q1 = "SELECT tech_do_movies.technician_id,AVG(movie.agg_rating) FROM tech_do_movies INNER JOIN movie ON tech_do_movies.movie_id=movie.movie_id WHERE tech_do_movies.technician_id IN (SELECT tech_do_movies.technician_id FROM tech_do_movies WHERE tech_do_movies.movie_id=" + m_id + ") GROUP BY tech_do_movies.technician_id";

        avg_tech = new ArrayList<>();

        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();

        ResultSet rs = null;

        try {

            Statement stmt = con.createStatement();

            rs = stmt.executeQuery(q1);

            while (rs.next()) {
                double avg1 = rs.getFloat(2);
                avg_tech.add(avg1);
                System.out.println(avg1);

            }

        } catch (SQLException e) {

        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void getTechRank(int m_id) {

        String q1 = "SELECT technician.tech_id,(1-(technician.tech_rank/25))*100 AS Ranking FROM technician WHERE technician.tech_id IN (SELECT tech_do_movies.technician_id FROM tech_do_movies WHERE tech_do_movies.movie_id=" + m_id + ") GROUP BY technician.tech_id ";
        rank_tech = new ArrayList<>();

        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();

        ResultSet rs = null;

        try {

            Statement stmt = con.createStatement();

            rs = stmt.executeQuery(q1);

            while (rs.next()) {
                double rank1 = rs.getFloat(2);
                rank_tech.add(rank1);
                System.out.println(rank1);

            }

        } catch (SQLException e) {

        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void getTechPredictedList() {
        prating_tech = new ArrayList<>();
        for (int i = 0; i < avg_tech.size(); i++) {
            double pavg = getPredictedTechAvg(avg_tech.get(i), rank_tech.get(i));
            System.out.println(pavg);
            prating_tech.add(pavg);

        }

        for (int i = 0; i < prating_tech.size(); i++) {

            System.out.println(prating_tech.get(i));

        }

    }

    public void findTechAvg() {
        double t_rating = 0;
        double a_rating = 0;

        for (int i = 0; i < prating_tech.size(); i++) {

            t_rating = t_rating + prating_tech.get(i);

        }
        a_rating = t_rating / prating_tech.size();
        avg_tech_rating = a_rating;

        System.out.println("Avg for technicians " + a_rating);

    }

    public double getPredictedTechAvg(double avg, double exp) {
        Technician t = new Technician(avg, exp);
        t.randomWeightsSet();
        t.summation();
        t.activation();
        t.errorCalculation();
        double crmw = t.backpropagation(t.ramw);
        //a.prediction(crmw);
        double crmw2 = (double) Math.round(crmw * 100);
        if (crmw2 > 100) {
            return 100;
        }
        if (crmw2 < 0) {
            return 0;
        }

        System.out.println(crmw2);
        return crmw2;

    }

    //--------------------------------------------------------------------------------------------------
    public double findFinalAvg() {
        avg_final = (avg_actor_rating + avg_tech_rating) / 2;
        System.out.println("Predicted " + avg_final);
        return avg_final;
    }

    public void pdemo(int dem) {
        System.out.println(dem);

    }

    public double findFinalAvgDirect(int m_id) {
        Movie m = new Movie();
        m.getActorAvg(m_id);
        m.getActorRank(m_id);
        m.getPredictedList();
        m.findActorAvg();

        m.getTechAvg(m_id);
        m.getTechRank(m_id);
        m.getTechPredictedList();
        m.findTechAvg();

        double favg = m.findFinalAvg();
        return favg;
    }

//    public static void main(String[] args) {
//
//        Movie m = new Movie();
//        m.findFinalAvgDirect(17);
//
//        //m.getPredictedAvg(70, 80);
//    }

}
