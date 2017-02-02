<%-- 
    Document   : similartracks
    Created on : Nov 29, 2016, 3:18:24 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>


<style>
    span {
        padding:10px;
    }
</style>
<%
    //String spotid = (String) request.getAttribute("spotid");
    String spotid = (String) request.getAttribute("spotid");
    String acc_tok = (String) request.getAttribute("acc_tok");
    String image = (String) request.getAttribute("image");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="http://www.edmsauce.com/wp-content/uploads/2014/06/sax.png"/>
        <title>Tracks</title>
    </head>
    <body background="${image}">

        <h1>
            <strong><span style="background-color:white; text-shadow:2px 2px #ff0000;">Recommended songs</span></strong>
            <br>
            <div style="display:inline">
            <form method="get" action="ch.do" style="display:inline;">


                <input type="search" name="q" placeholder="Search.." style="height:50px; width:400px"/>
                    <input type="hidden" name="type" value="track" />
                    
            </form>
            <form method="get" action="MyHistory.do" style="display:inline;">


                 <input type="submit" value="History" style="height:50px; width:150px"/>
                    
                    
            </form>
                </div>
        </h1>
        <br><br>

        <table>
            <c:forEach var="song" items="${simtracks}" varStatus="status">
                <tr>
                    <td><h3>
                            <span style="background-color:white; text-shadow:1px 1px #a0a0a0;">${song}</span>
                            <form method="get" action="ch.do" style="display:inline;">


                                <input type="hidden" name="q" value="${song}" />
                                <input type="hidden" name="type" value="track" />

                                <input type="submit" value="Select!" style="height:40px; width:150px">


                            </form>
                                <br>

                            <iframe width="420" height="195" src=${simyoutubes[status.index]} >
                            </iframe> 
                        </h3>
                        <br>
                        <br>


                    </td>
                </tr>
            </c:forEach>

        </table>


    </body>
</html>
