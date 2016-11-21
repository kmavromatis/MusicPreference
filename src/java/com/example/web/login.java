/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.model.Uthldap;

;

public class login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        
         Uthldap ldap=new Uthldap(user,passwd);
         List info=new ArrayList();
         if(ldap.auth()){
             info.add(ldap.getName());
             info.add(ldap.getBirthYear());
             info.add(ldap.getDept());
             info.add(ldap.getMail());
         }
          request.setAttribute("info",info);
          
          RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
           rd.forward(request,response);  
       
        
}
}
