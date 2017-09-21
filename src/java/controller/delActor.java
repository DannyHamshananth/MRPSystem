/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dal.Actor;
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
@WebServlet(name = "delActor", urlPatterns = {"/delActor"})
public class delActor extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id=Integer.parseInt(request.getParameter("id"));
       
       Actor a=new Actor();
       int i=a.deleteActor(id);
       
       String stat;
        
        if(i==0){
        stat="Error";
        }else{
        stat="Deleted";
        }
        
        request.setAttribute("auth_user", stat);
        request.getRequestDispatcher("selActor.jsp").forward(request, response);
       
    }

   

}
