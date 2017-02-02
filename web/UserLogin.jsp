<%-- 
    Document   : similartracks
    Created on : Nov 29, 2016, 3:18:24 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/css.css" rel="stylesheet" type="text/css" />
        <link rel="icon" href="http://www.edmsauce.com/wp-content/uploads/2014/06/sax.png"/>
        <title>History</title>
    </head>
    <body>
        <div id="content">
            <div class="indent">
                <div class="indent1">
                    <div style="display:inline">
                        <h1>
                            <form method="get" action="ch.do" style="display:inline;">


                                <input type="search" name="q" placeholder="Search.." style="height:50px; width:400px"/>
                                <input type="hidden" name="type" value="track" />

                            </form>
                        </h1>
                    </div>
                    <br>
                    <br>
                    <h1> You must been logged in to view your history. Please log in or register. </h1>
                    <br><br>
                    <h4>
                        <form method="POST" action="login.do" >  
                            <label><b>Username</b></label>
                            <input type="text" placeholder="Enter Username" name="user">

                            <label><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="passwd" >

                            <button type="submit">Login</button>
                        </form>
                        <br><br>
                        <form method="POST" action ="register.do">
                            <label><b>Username</b></label>
                            <input type="text" placeholder="Enter Username" name="user">

                            <label><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="passwd" >

                            <button type="submit">Register</button>
                        </form>
                    </h4>

                </div>
            </div>
        </div>
    </body>
</html>
