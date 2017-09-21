<%-- 
    Document   : editMovie
    Created on : Sep 16, 2017, 3:33:40 PM
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <script>
            $(document).ready(function () {
                var date_input = $('input[name="date"]'); //our date input has the name "date"
                var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                var options = {
                    format: 'yyyy-mm-dd',
                    container: container,
                    todayHighlight: true,
                    autoclose: true,
                };
                date_input.datepicker(options);
            })
        </script>
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
        <h1>Edit Movie Details</h1>
        <form action="insertMovie" method="post">

            <%
                Dataconnection dc = new Dataconnection();
                Connection con = dc.newConnection();
                String query = "select * from movie m where m.movie_id=" + request.getParameter("id");
                Statement stmt = null;
                ResultSet rs = null;
                stmt = con.createStatement();

                rs = stmt.executeQuery(query);
                while (rs.next()) {
            %>

            <div class="form-group">
                <label for="aname">Movie ID</label>
                <input type="text" class="form-control" value="<%=rs.getInt(1)%>" id="mid" name="mid" placeholder="Enter movie name">

            </div>
            <div class="form-group">
                <label for="aname">Movie Name</label>
                <input type="text" class="form-control" value="<%=rs.getString(2)%>" id="mname" name="mname" placeholder="Enter movie name">

            </div>
            <div class="form-group">
                <label for="agender">Aggregated Rating</label>
                <input type="text" class="form-control" value="<%=rs.getFloat(3)%>" id="agg_rat" name="agg_rat" placeholder="Enter Movie Rating">


            </div>







            <div class="form-group"> <!-- Date input -->
                <label class="control-label" for="date">Release Date</label>
                <input class="form-control" id="date" value="<%=rs.getDate(5)%>" name="date" placeholder="yyyy-mm-dd" type="text"/>
            </div>


            <br>
            <button type="submit" class="btn btn-primary">Submit</button>


        </form>

    </div>

    <%
        }
        rs.close();
        stmt.close();
        con.close();

    %> 


    <c:if test="${not empty auth_user}">
        <script type="text/javascript">
            var msg = '<c:out value="${auth_user}"/>';
            alert(msg);

        </script>


    </c:if>





</body>
</html>

