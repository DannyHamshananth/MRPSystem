<%-- 
    Document   : InsertActor
    Created on : Sep 10, 2017, 4:33:24 PM
    Author     : ASUS-PC
--%>
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
            <h1>Add Actor Details</h1>
            <form action="addActor" method="post">
                <div class="form-group">
                    <label for="aname">Actor Name</label>
                    <input type="text" class="form-control" id="aname" name="aname" placeholder="Enter Actor Name">

                </div>
                <div class="form-group">
                    <label for="agender">Actor Rank</label>
                    <input type="text" class="form-control" id="arank" name="arank" placeholder="Enter Actor Rank">

                </div>
                <div class="form-group">
                    <label for="exampleSelect1">Gender</label>
                    <select class="form-control" id="agender" name="agender">
                        <option>--Select Gender--</option>
                        <option value="0">Male</option>
                        <option value="1">Female</option>

                    </select>
                    <br>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>



    <c:if test="${not empty auth_user}">
        <script type="text/javascript">
            var msg='<c:out value="${auth_user}"/>';
            alert(msg);


        </script>


    </c:if>


   


</body>
</html>
