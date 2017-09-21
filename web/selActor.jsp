<%-- 
    Document   : selActor
    Created on : Sep 9, 2017, 4:06:46 PM
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
        <div class="container">

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
                <thead><tr><td>ID</td><td>Name</td><td>Gender</td><td>Rank</td><td>Edit</td><td>Delete</td></tr></thead>
                <%
                    Dataconnection dc = new Dataconnection();
                    Connection con = dc.newConnection();
                    String query = "SELECT actor.actor_id,actor.actor_name,case when actor.actor_gender=0 then 'Male' else 'Female' end AS GENDER,actor.actor_rank FROM `actor`";
                    Statement stmt = null;
                    ResultSet rs = null;
                    stmt = con.createStatement();

                    rs = stmt.executeQuery(query);
                    while (rs.next()) {
                %>
                <tbody><tr><td><%=rs.getInt(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getString(3)%></td><td><%=rs.getInt(4)%></td><td><input type="button" class="btn btn-success" onclick="location.href = 'editActor.jsp?id=' +<%=rs.getInt(1)%>;" value="Edit" /></td><td><input type="button" class="btn btn-danger" onclick="location.href = 'delActor?id=' +<%=rs.getInt(1)%>;" value="Delete" /></td></tr> </tbody>
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
