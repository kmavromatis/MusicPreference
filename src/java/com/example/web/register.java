/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import com.example.model.LogDatabase;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.model.LogDatabase;

public class register extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean check=false;
        
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        LogDatabase ld = new LogDatabase();
        try {
            check = ld.insert(user, passwd);
        } catch (Exception e) {
        }
        if(check==true){ session.setAttribute("usr",user); }
        

        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);

    }
}
