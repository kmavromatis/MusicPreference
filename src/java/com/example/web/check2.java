/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import com.example.model.FindSimilars;

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
        response.setContentType("text/html");
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
            float speechiness,tempo,danceability,acousticness,liveness,valence,loudness,energy;
            
            speechiness = ((Number)json.get("speechiness")).floatValue();
            tempo = ((Number)json.get("tempo")).floatValue();
            danceability = ((Number)json.get("danceability")).floatValue();
            acousticness = ((Number)json.get("acousticness")).floatValue();
            liveness = ((Number)json.get("liveness")).floatValue();
            valence = ((Number)json.get("valence")).floatValue();
            loudness = ((Number)json.get("loudness")).floatValue();
            energy = ((Number)json.get("energy")).floatValue();
            
            float[] features ={speechiness , tempo , danceability , acousticness , liveness, valence, loudness,energy};
            
           //out.print("<br>"+Arrays.toString(features)+"<br>");
            
            
            FindSimilars fs = new FindSimilars();
            
          
            String[] simtracks = fs.getSim(access_token,id,features);
            out.println("<br>");
            out.println(Arrays.toString(simtracks));
      
            
            
        }catch(Exception e){
            
        }
            
            
   


    }
}
