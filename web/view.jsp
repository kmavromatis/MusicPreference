
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
            String spotid = (String) request.getAttribute("spotid");
            String acc_tok = (String) request.getAttribute("acc_tok");

            String src = "\"" + "https://www.youtube.com/embed/" + vid + "\"";


        %>
        <p>
            <%= name%>
            -
            <%= artist%>
            ( <%= spotid%> ) , access token = <%=acc_tok%>
        </p>
        <iframe width="420" height="315" src=<%=src%> >
        </iframe>
        <h2>
            <form method="get" action="ch2.do">

                <input type="hidden" name="id" value=<%= spotid%> />
                <input type="hidden" name="access_token" value=<%= acc_tok%> />
                <p>   <input type="submit" value="Get the audio features">

                </p>

            </form>


        </h2>


    </body>
</html>
