<%-- 
    Document   : editActor
    Created on : Sep 13, 2017, 1:14:27 PM
    Author     : ASUS-PC
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Dal.Dataconnection"%>
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
        <%
            Dataconnection dc = new Dataconnection();
            Connection con = dc.newConnection();
            String query = "SELECT actor.actor_id,actor.actor_name,case when actor.actor_gender=0 then 'Male' else 'Female' end AS GENDER,actor.actor_rank FROM `actor` where actor.actor_id=" + request.getParameter("id");
            Statement stmt = null;
            ResultSet rs = null;
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);
            while (rs.next()) {
        %>

        <div class="col-xs-4 container">
            <h1>Edit Actor Details</h1>
            <form action="edActor" method="post">
                <div class="form-group">
                    <label for="aname">Actor ID</label>
                    <input type="text" class="form-control" value="<%=rs.getInt(1)%>" id="aid" name="aid">

                </div>
                <div class="form-group">
                    <label for="aname">Actor Name</label>
                    <input type="text" class="form-control" value="<%=rs.getString(2)%>" id="aname" name="aname" placeholder="Enter Actor Name">

                </div>
                <div class="form-group">
                    <label for="agender">Actor Rank</label>
                    <input type="text" class="form-control" id="arank" value="<%=rs.getString(4)%>" name="arank" placeholder="Enter Actor Rank">

                </div>

                <%
                    String gen = rs.getString(3);

                %>
                <div class="form-group">
                    <label for="exampleSelect1">Example select</label>
                    <select class="form-control" id="agender" name="agender">
                        <option>--Select Gender--</option>
                        <option value="0" <% if (gen.equals("Male")) {
                                out.println("selected");
                            } %>>Male</option>
                        <option value="1" <% if (gen.equals("Female")) {
                                out.println("selected");
                            } %>>Female</option>

                    </select>
                    <br>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
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
