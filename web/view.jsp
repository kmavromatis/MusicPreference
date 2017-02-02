
<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Song</title>
        <link rel="icon" href="http://www.edmsauce.com/wp-content/uploads/2014/06/sax.png">
    </head>


    <%

        String name = (String) request.getAttribute("naming");
        String artist = (String) request.getAttribute("artist");
        String vid = (String) request.getAttribute("vid");
        String spotid = (String) request.getAttribute("spotid");
        String acc_tok = (String) request.getAttribute("acc_tok");
        String myuserid = (String) request.getAttribute("myuserid");
        String image = (String) request.getAttribute("image");

        String src = "\"" + "https://www.youtube.com/embed/" + vid + "\"";

    %>

    <body background="${image}">


    <center>
        <iframe width="620" height="415" src=<%=src%> >
        </iframe>
    </center>
    <h2>
        <center>
            <form method="get" action="ch2.do">

                <input type="hidden" name="id" value=<%= spotid%> />
                <input type="hidden" name="access_token" value=<%= acc_tok%> />
                <input type="hidden" name="naming" value=<%=name%> />
                <input type="hidden" name="image" value=<%=image%> />
                <p>   <input type="submit" value="Recommend songs!" style="height:50px; width:200px">

                </p>

            </form>
            <div style="display:inline">
                <form method="get" action="ch.do" style="display:inline;">


                    <input type="search" name="q" placeholder="Search.." style="height:50px; width:400px"/>
                    <input type="hidden" name="type" value="track" />

                </form>
                <form method="get" action="MyHistory.do" style="display:inline;">


                    <input type="submit" value="History" style="height:50px; width:150px"/>


                </form>
            </div>
        </center>

    </h2>


</body>
</html>
