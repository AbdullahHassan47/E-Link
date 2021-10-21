<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body 
            {
                margin: 0;
                font-size: 28px;
            }

            #navbar
            {
                overflow: hidden;
                background-color: #333;
            }

            #navbar a
            {
                float: right;
                display: block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            #navbar logo
            {
                float: left;
                display: block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 20px;
            }

            #navbar a:hover
            {
                background-color: #ddd;
                color: black;
            }

            #navbar a.active 
            {
                background-color: #4CAF50;
                color: white;
            }
        </style>
    </head>
    <body>
        <div id="navbar">
            <a href="Sign-Up and Login.jsp">Sign out</a>
            <a class="active" href="javascript:void(0)">Profile</a>
            <a href="PrintAllPosts">Home</a>
            <logo href="javascript:void(0)">eLink</logo>
            
        </div>
        <section>
            <%
                HttpSession s = request.getSession();
                String name = s.getAttribute("username").toString();
            %>
            <h4>Welcome <%=name%></h4>
            <center>
                <h1>Information</h1>
            </center>
        </section>
    </body>
</html>