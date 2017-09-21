<%-- 
    Document   : selMovie
    Created on : Sep 16, 2017, 2:20:01 PM
    Author     : ASUS-PC
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Dal.Dataconnection"%>
<%@page import="java.util.ArrayList"%>

<%@page import="Dal.Actor"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="container" width="1600px">

            <ul class="nav nav-pills">
                <li><a href="AdminHome.jsp">Home</a></li>
                <li class="dropdown active">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Actors <span class="caret"></span></a>
                    <ul class="dropdown-menu nav nav-pills">
                        <li><a href="#">Add Actor</a></li>
                        <li class="active"><a href="#">Manage Actor</a></li>
                        <li><a href="#">Actor Rankings</a></li>
                        <li><a href="#">Actress Rankings</a></li>                        
                    </ul>
                </li>
                <li><a href="#">Technicians</a></li>
                <li><a href="#">Movies</a></li>
                <li><a href="#">Ratings</a></li>
            </ul>
        </div>
        <div class="container">
            <table class="table">
                <thead><tr><td>ID</td><td>Movie Name</td><td>Movie Rating</td><td>Producer</td><td>Cast</td><td>Technicians</td><td>Edit Movie</td><td>Add Cast</td><td>Add Technicians</td></tr></thead>
                <%
                    Dataconnection dc = new Dataconnection();
                    Connection con = dc.newConnection();
                    String query = "SELECT m.movie_id as MID,m.movie_name AS MNAME,m.agg_rating AS RATING, (SELECT IfNull(producer.company_name, '') FROM producer WHERE producer.prod_id=m.movie_id) AS PRODUCTION,(SELECT GROUP_CONCAT(actor.actor_name) FROM actor INNER JOIN actor_do_movies ON actor.actor_id=actor_do_movies.actor_id WHERE actor_do_movies.movie_id=m.movie_id) AS CAST, (SELECT GROUP_CONCAT(technician.tech_name) FROM technician INNER JOIN tech_do_movies ON tech_do_movies.technician_id=technician.tech_id WHERE tech_do_movies.movie_id=m.movie_id) AS TECHNICIANS FROM movie m";
                    Statement stmt = null;
                    ResultSet rs = null;
                    stmt = con.createStatement();

                    rs = stmt.executeQuery(query);
                    while (rs.next()) {
                %>
                <tbody><tr><td><%=rs.getInt(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getFloat(3)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(5)%></td><td><%=rs.getString(6)%></td><td><input type="button" class="btn btn-success" onclick="location.href = 'editMovie.jsp?id=' +<%=rs.getInt(1)%>;" value="Edit Movie" /></td><td><input type="button" class="btn btn-success" onclick="location.href = 'editActor.jsp?id=' +<%=rs.getInt(1)%>;" value="Add Cast" /></td><td><input type="button" class="btn btn-success" onclick="location.href = 'editActor.jsp?id=' +<%=rs.getInt(1)%>;" value="Add Technicians" /></td></tr> </tbody>
                            <%
                                }
                                rs.close();
                                stmt.close();
                                con.close();

                            %>
            </table>
        </div>

        <c:if test="${not empty auth_user}">
            <script type="text/javascript">
                var msg = '<c:out value="${auth_user}"/>';
                alert(msg);


            </script>


        </c:if>

    </body>
</html>