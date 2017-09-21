/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dal.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
//import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS-PC
 */
@WebServlet(name = "insertMovie", urlPatterns = {"/insertMovie"})
public class insertMovie extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mname = request.getParameter("mname");
        String rdate = request.getParameter("date");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
       
        java.util.Date date = null;
        try {
            date = dt.parse(rdate);
        } catch (ParseException ex) {
            Logger.getLogger(insertMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlStartDate; 
        sqlStartDate = new Date(date.getTime());
        double agg_rat= Double.parseDouble(request.getParameter("agg_rat"));
        int pid=Integer.parseInt(request.getParameter("pid"));
        
        Movie m=new Movie();
        int i=m.insertMovie(mname, agg_rat, pid, sqlStartDate);
        
        String stat;

        if (i == 0) {
            stat = "Error";
        } else {
            stat = "Successfully Updated";
        }

        request.setAttribute("auth_user", stat);
        request.getRequestDispatcher("insertMovie.jsp").forward(request, response);
        
    }

}
