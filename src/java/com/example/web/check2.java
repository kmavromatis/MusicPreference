/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import org.apache.commons.codec.binary.Base64;

import com.example.model.YoutubeId;
import com.example.model.SpotifyToken;
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

public class check2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String id = request.getParameter("id");
        String access_token = request.getParameter("access_token");

        String recv;

        HttpSession session = request.getSession();
        String recvbuff = new String();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        //response.setContentType("text/html");
        
        //PrintWriter out = response.getWriter();
        // response.setContentType("text/html");
        String url = "https://api.spotify.com/v1/audio-features/"+id;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Bearer " + access_token);
        //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        int responseCode = con.getResponseCode();
    
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response2 = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response2.append(inputLine);
        }
        in.close();

        //print result
        //out.println(response.toString());

        JSONParser parser = new JSONParser();

        String test = response2.toString();
        try {
            JSONObject json = (JSONObject) parser.parse(new StringReader(test));

            out.println(json);
            String speechiness,tempo,danceability,acousticness,liveness,valence,loudness,energy;
            
            speechiness = (String)json.get("speechiness");
            tempo = (String)json.get("tempo");
            danceability = (String)json.get("danceability");
            acousticness = (String)json.get("acousticness");
            liveness = (String)json.get("liveness");
            valence = (String)json.get("valence");
            loudness = (String)json.get("loudness");
            energy = (String)json.get("energy");
            
            
            
            
   

        } catch (Exception e) {

        }
    }
}
