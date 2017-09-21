/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dal.Login;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");

        Login l = new Login();
        String utype = l.userLogin(uname, pwd);

        if(utype != null){
        request.setAttribute("auth_user", utype);
        request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
        }
        
        else {
        request.setAttribute("auth_user", "Incorrect Details");
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

}
