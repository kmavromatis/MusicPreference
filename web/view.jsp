
<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Testing</title>
    </head>
    <body>
        <%
            String name = (String) request.getAttribute("naming");
            String artist = (String) request.getAttribute("artist");
            String vid = (String) request.getAttribute("vid");
            
            String src = "\""+ "https://www.youtube.com/embed/"+vid+"\"";
          

        %>
        <p>
        <%= name %>
        <%= artist %>
        </p>
        <iframe width="420" height="315" src=<%=src%> >
        </iframe>
        
    </body>
</html>
