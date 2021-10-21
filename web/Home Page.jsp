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

            .header
            {
                background-image: url("journey-login-background.png");
                padding: 30px;
                color: #ffffff;
                text-align: center;
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

            .content
            {
                padding: 16px;
            }

            .sticky
            {
                position: fixed;
                top: 0;
                width: 100%;
            }
            .sticky + .content
            {
                padding-top: 60px;
            }

        </style>
    </head>
    <body>
        <div class="header">
            <h2>elink header</h2>
            <p>elink paragraph</p>
        </div>
        <div id="navbar">
            <a href="Sign-Up and Login.jsp">Sign out</a>
            <a href="PrintOne">Profile</a>
            <a class="active" href="javascript:void(0)">Home</a>
            <logo href="javascript:void(0)">eLink</logo>
        </div>
        <script>
            window.onscroll = function () 
            {
                myFunction();
            };
            var navbar = document.getElementById("navbar");
            var sticky = navbar.offsetTop;
            function myFunction() 
            {
                if (window.pageYOffset >= sticky) 
                {
                    navbar.classList.add("sticky");
                } 
                else
                {
                    navbar.classList.remove("sticky");
                }
            }
        </script>
        <h3><a href="ShowFriendList">Friend List</a></h3>
        <h3><a href="ShowFriendRequest">Friend request</a></h3>
        <br>
        <br>
        <section>
            <%
                HttpSession s = request.getSession();
                String name = s.getAttribute("username").toString();
            %>
            <h4>Welcome <%=name%></h4>
            <form action="InsertPost" method="post">
                <pre>
                                <textarea rows="4" cols="50" name="post" placeholder="What's on your mind?"></textarea>
                                                     <input type="submit" value="Post">
                </pre>
            </form>
        </section>
    </body>
</html>