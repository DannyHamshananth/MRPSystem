<%-- 
    Document   : AdminHome
    Created on : Sep 2, 2017, 4:30:22 PM
    Author     : ASUS-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .container {
                display: table;
            }
            .centered {
                display: table-cell;
                height: 400px;
                width: 800px;
                color: green;
                text-align: center;
                vertical-align: middle;
            }
        </style>
    </head>
    <body>

        <div class="container">

            <ul class="nav nav-pills">
                <li class="active"><a href="#">Home</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Actors <span class="caret"></span></a>
                    <ul class="dropdown-menu nav nav-pills">
                        <li><a href="InsertActor.jsp">Add Actor</a></li>
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
        <div class="container">
            <div class="centered">
                <h1>Movie Rating Prediction System</h1>
            </div>
        </div>

    </body>
</html>
