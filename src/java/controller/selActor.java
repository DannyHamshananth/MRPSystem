/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dal.Actor;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS-PC
 */
@WebServlet(name = "selActor", urlPatterns = {"/selActor"})
public class selActor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Actor a = new Actor();
        ArrayList<Actor> alist = a.selectActors();

        request.setAttribute("alist", alist);
        request.getRequestDispatcher("selActor.jsp").forward(request, response);
    }

}
