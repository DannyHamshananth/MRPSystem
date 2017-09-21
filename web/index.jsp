<%-- 
    Document   : index
    Created on : Sep 2, 2017, 5:43:03 PM
    Author     : ASUS-PC
--%>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="js/login.js"></script>
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="register-form">
                    <input type="text" value="" placeholder="name"/>
                    <input type="password" value="" placeholder="password"/>
                    <input type="text" value="" placeholder="email address"/>
                    <button>create</button>
                    <p class="message">Already registered? <a href="#">Sign In</a></p>
                </form>
                <form class="login-form" action="login" method="post">
                    <input type="text" value="" name="uname" placeholder="username"/>
                    <input type="password" value="" name="pwd" placeholder="password"/>
                    <button type="submit">login</button>
                    <p class="message">Not registered? <a href="#">Create an account</a></p>

                    <c:if test="${not empty auth_user}">
                       
                        <h1>${auth_user}</h1>

                       
                    </c:if>



                </form>
            </div>
        </div>
    </body>
</html>
