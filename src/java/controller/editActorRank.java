package controller;

import Dal.Actor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "editActorRank", urlPatterns = {"/editActorRank"})
public class editActorRank extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int aid = Integer.parseInt(request.getParameter("aid"));
        int arank = Integer.parseInt(request.getParameter("arank"));

        Actor a = new Actor();
        int i = a.updateActorRank(arank, aid);

        String stat;

        if (i == 0) {
            stat = "Error";
        } else {
            stat = "Successfully Updated";
        }

        request.setAttribute("auth_user", stat);
        request.getRequestDispatcher("selActor.jsp").forward(request, response);
    }

}
