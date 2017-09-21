<%-- 
    Document   : getRating
    Created on : Sep 16, 2017, 4:51:50 PM
    Author     : ASUS-PC
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Dal.Dataconnection"%>
<%@page import="Dal.Dataconnection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

        <!-- jQury Rate CSS and JS -->
        <link rel="stylesheet" type="text/css" href="rate/rate.min.css">
        <script type="text/javascript" src="rate/jquery.rate.min.js"></script>

        <!-- Demo CSS and JS -->
        <link rel="stylesheet" type="text/css" href="demo/demo.css">
        <script type="text/javascript" src="demo/demo.js"></script>

    </script>





</head>
<body>
    <div class="container">

        <ul class="nav nav-pills">
            <li><a href="AdminHome.jsp">Home</a></li>
            <li class="dropdown active">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Actors <span class="caret"></span></a>
                <ul class="dropdown-menu nav nav-pills">
                    <li class="active"><a href="#">Add Actor</a></li>
                    <li><a href="selActor.jsp">Manage Actor</a></li>
                    <li><a href="#">Actor Rankings</a></li>
                    <li><a href="#">Actress Rankings</a></li>      
                </ul>
            </li>
            <li><a href="#">Technicians</a></li>
            <li><a href="#">Movies</a></li>
            <li><a href="#">Ratings</a></li>
        </ul>
    </div>
    <div class="col-xs-4 container">
        <h1>Get Rating</h1>
        <form action="getRating" method="post">


            <%
                Dataconnection dc = new Dataconnection();
                Connection con = dc.newConnection();
                String query = "select movie.movie_id,movie.movie_name from movie WHERE movie.rel_date > NOW()";
                Statement stmt = null;
                ResultSet rs = null;
                stmt = con.createStatement();

                rs = stmt.executeQuery(query);

            %>
            <div class="form-group">
                <label for="exampleSelect1">Movie</label>
                <select class="form-control" id="agender" name="mid">
                    <option>--Select MOVIE--</option>
                    <%                        while (rs.next()) {

                    %>
                    <option value= "<%=rs.getInt(1)%>" ><%= rs.getString(2)%></option> 
                    <%
                        }
                        rs.close();
                        stmt.close();
                        con.close();
                    %>
                </select>	



            </div>





            <br>
            <button type="submit" class="btn btn-primary">Submit</button>


        </form>
    </div>
    <br>

    <%--<c:if test="${not empty rating}">--%>
     <!--<script type="text/javascript">-->    
    <div class="container">
       
        <div class="row">
      <div class="col-lg-12">
        <div class="progress">
            <div class="progress-bar" role="progressbar" aria-valuenow="<c:out value="${rating}"/>" aria-valuemin="0" aria-valuemax="100" style="width:<c:out value="${rating}"/>%">
                <c:out value="${rating}"/>
            </div>
        </div>
      </div>
            </div>
    </div>


    
       

<!--           var rating = '';
            alert(rating);

       </script>-->


    <%--</c:if>--%>





</body>
</html>

