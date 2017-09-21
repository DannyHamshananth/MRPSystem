/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.sql.*;





public class Dataconnection {
   
    String DB_URL = "jdbc:mysql://localhost/mrps";
    String USER = "root";
    String PASS = "";
    
    public Connection newConnection(){
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn;
    conn =   (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    return conn;
    
    }catch(ClassNotFoundException | SQLException e){
    
    return null;
    }

     
    }
     

}