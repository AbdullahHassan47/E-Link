<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
    <head>
        <title>
            E-Link
        </title>
        <style>
            *.header
            {
                padding: 30px;
                text-align: center;
                color: black;
            }
            .SignUp
            {
                padding-right: 120px;
                text-align: right;
                color: blue;
            }
            .LogIn
            {
                padding-left: 120px;
                text-align: left;
                color: appworkspace;
            }
            .Sign
            {
                padding-right: 290px;
                text-align: right;
                color: blue;
            }
        </style>
    </head>
    <style>
        body 
        {
            background-image: url("asd.jpg");
        }
        .no-background 
        {
            background-image: url("asd.jpg");
        }
    </style>
    
    <div class="header">
        <font color="white"><h1>eLink</h1>
        </font>
    </div>
    
    <div class="LogIn">
        <h2>Log In</h2>
        <form action="Login" method="post">
            Username: <input type="text"  placeholder="Enter Username" name="un" ><br><br>
            Password: <input type="password" placeholder="Enter Password" name="lpass"><br><br>
            <input type="submit" value="Login">
        </form>
    </div>
    
    <br>
    <br>
    <div class="Sign">
        <h2>Sign Up</h2>
    </div>
    <div class="SignUp">
        <form action="SignUp" method="post">
            First name: <input type="text" name="fn" placeholder="Enter Your Fristname" maxlength="15" required><br><br>
            Last name:  <input type="text" name="ln" placeholder="Enter Your Lastname" maxlength="15" required><br><br>
            Username:   <input type="text" name="sun" placeholder="Enter Your Username" maxlength="20" required><br><br>
            Your E-mail: <input type="email" name="email" placeholder="sophie@example.com" required><br><br>
            Re-enter your E-mail: <input type="email" name="remail" placeholder="sophie@example.com" required><br><br>
            New password:       <input type="password" name="spass" minlength="8" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number." required><br><br>
            Re-type password:   <input type="password" name="rspass" minlength="8" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number." required><br><br>
            Mobile number:      <input type="text" name="num"><br><br>
            Gender:             <input type="radio" name="gender" value="Male" checked>Male 
                                <input type="radio" name="gender" value="Female">Female<br><br>
            Birthday:           <input type="date" name="bday" max="2015-12-31" min="1950-12-31"><br><br>
                                <input type="submit" value="Sign Up">
        </form>
    </div>
    </body>
</html>