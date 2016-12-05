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
        <title>Tracks</title>
    </head>
    <body>
    
        
        <strong>Recommended songs</strong>
        <br><br>
        
        <table>
            <c:forEach var="song" items="${simtracks}" varStatus="status">
                <tr>
                    <td>${song}<br>
                        <iframe width="220" height="115" src=${simyoutubes[status.index]} >
                        </iframe> <br>
                        
                        
                    </td>
                </tr>
            </c:forEach>
                       
        </table>
        
  
</body>
</html>
