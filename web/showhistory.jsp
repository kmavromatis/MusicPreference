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
                    <table>
                        <c:forEach var="song" items="${simtracks}" varStatus="status">
                            <tr>
                                <td><h3 style="display:inline;">
                                        <span style=" text-shadow:1px 1px #a0a0a0;" style="display:inline;">${song}</span>
                                        <h4 style="display:inline;"><form method="get" action="ch.do" style="display:inline;">


                                            <input type="hidden" name="q" value="${song}" />
                                            <input type="hidden" name="type" value="track" />

                                            <input type="submit" value="Select" style="height:40px; width:150px">


                                        </form>
                                        </h4>
                                        <br>

                                        <iframe width="260" height="120" src=${simyoutubes[status.index]} >
                                        </iframe> 
                                    </h3>
                                    <br>
                                    <br>


                                </td>
                            </tr>
                        </c:forEach>

                    </table>

                </div>
            </div>
        </div>
    </body>
</html>
