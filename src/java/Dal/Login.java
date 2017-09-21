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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

    String uname;
    String pwd;
    String usertype;

    public String userLogin(String uname, String pwd){
        String query = "SELECT COUNT(*) Number,login.utype as User_type FROM login WHERE login.usename='" + uname + "' and login.pwd='" + pwd + "'";
        Dataconnection dc = new Dataconnection();
        Connection con = dc.newConnection();

        PreparedStatement stmt;
        int log_stat = 0;
        String u_type = null;
        try {
            stmt = con.prepareStatement(query);
        

        ResultSet rs;
        

        rs = stmt.executeQuery(query);

        while (rs.next()) {
            log_stat = rs.getInt(1);
            u_type = rs.getString(2);
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (log_stat == 1) {
            return u_type;
        } else {
            return null;
        }
        
    }

}
