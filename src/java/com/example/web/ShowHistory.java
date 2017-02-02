/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import com.example.model.FindSimilars;
import com.example.model.Database;
import com.example.model.SpotifyToken;

import org.apache.commons.codec.binary.Base64;

import com.example.model.YoutubeId;
import com.example.model.SpotifyToken;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.io.*;
import java.util.*;
import org.json.simple.ItemList;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.ContentHandler;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.Yytoken;

public class ShowHistory extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String recv;

        HttpSession session = request.getSession(false);
        String user = (String) session.getAttribute("usr");
        String recvbuff = new String();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        ArrayList<String> arr = new ArrayList<String>();
        try {
            Database db = new Database();
            arr = db.search(user);
            String[] simyoutubes = new String [ arr.size() ];
            YoutubeId allsimid = new YoutubeId();
            for(int j =0; j<arr.size(); j++){
                simyoutubes[j] = "\"" + "https://www.youtube.com/embed/" + allsimid.getVidbyTitle(arr.get(j)) +"\"";
                
                
                
            }
            request.setAttribute("simyoutubes", simyoutubes);
            request.setAttribute("simtracks", arr);
            RequestDispatcher view = request.getRequestDispatcher("showhistory.jsp");
            view.forward(request, response);
        } catch (Exception e) {

        }
    }
}
