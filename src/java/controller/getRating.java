/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dal.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS-PC
 */
@WebServlet(name = "getRating", urlPatterns = {"/getRating"})
public class getRating extends HttpServlet {

    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int movieid=Integer.parseInt(request.getParameter("mid"));
       Movie m=new Movie();
       String mname=m.getMovieName(movieid);
       double rating=m.findFinalAvgDirect(movieid);
       
       request.setAttribute("mname", mname);
       request.setAttribute("rating", rating);
       request.getRequestDispatcher("getRating.jsp").forward(request, response);
       
       
    }

   

}
