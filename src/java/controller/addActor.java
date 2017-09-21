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
@WebServlet(name = "addActor", urlPatterns = {"/addActor"})
public class addActor extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String aname=request.getParameter("aname");
        int arank=Integer.parseInt(request.getParameter("arank"));
        String agender=request.getParameter("agender");
        boolean gender;
        if(agender.equals("0")){
            gender=false;
        } else {
            gender=true;
        }
        
        Actor a=new Actor();
        int i=a.insertActor(aname, arank, gender);
        
        String stat;
        
        if(i==0){
        stat="Error";
        }else{
        stat="Successfully Added";
        }
        
        request.setAttribute("auth_user", stat);
        request.getRequestDispatcher("InsertActor.jsp").forward(request, response);
        
    }

   

}
