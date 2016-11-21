<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center>
        <%
            List info = (List) request.getAttribute("info");
            if (info.size() > 0) {
                out.println("Your Data");
                out.println("<br>Name:" + info.get(0));
                out.println("<br>BirthYear:" + info.get(1));
                out.println("<br>Dept:" + info.get(2));
                out.println("<br>Email:" + info.get(3));
            } else {
                out.println("wrong username or password");
            }
        %>
        <%
		
	%>
        
    </center>
        <%@include  file="index.html" %>
        
</body>
</html>