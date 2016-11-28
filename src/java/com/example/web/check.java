/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

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

/**
 *
 * @author user
 */
public class check extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        String recv;

        HttpSession session = request.getSession();
        String recvbuff = new String();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String q = request.getParameter("q");
        q = q.replaceAll(" ", "+");
        String type = request.getParameter("type");
        String url = "https://api.spotify.com/v1/search?q=" + q + "&type=" + type;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        // out.println("\nSending 'GET' request to URL : " + url);
        //out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response2 = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response2.append(inputLine);
        }
        in.close();

        //print result
        JSONParser parser = new JSONParser();

        String test = response2.toString();
        try {
            YoutubeId id = new YoutubeId();
            JSONObject json = (JSONObject) parser.parse(new StringReader(test));

            //out.println(json);
            JSONObject tracks = (JSONObject) json.get("tracks");
            //JSONObject items = tracks.getJSONObject("items");

            JSONArray itemArr = (JSONArray) tracks.get("items");

            for (int i = 0; i < itemArr.size(); i++) {
                JSONObject each = (JSONObject) itemArr.get(i);
                JSONArray art = (JSONArray) each.get("artists");
                JSONObject oneart = (JSONObject) art.get(0);
                String artist = (String) oneart.get("name");
                String naming = (String) each.get("name");
                out.print(artist);
                out.print("     :   ");

                out.print(naming);
                out.print("<div>     :   </div>");
                String getid = id.getVid(naming, artist);
                out.print(getid);
                out.print("<br>");
            }
            JSONObject each = (JSONObject) itemArr.get(0);
            JSONArray art1 = (JSONArray) each.get("artists");
            JSONObject oneart1 = (JSONObject) art1.get(0);
            String artist1 = (String) oneart1.get("name");
            String naming1 = (String) each.get("name");
            String getid = id.getVid(naming1, artist1);
            
            String SpotId = (String) each.get("id");

            SpotifyToken st = new SpotifyToken();
            String access_token = st.getAuth();
            
            
            request.setAttribute("naming", naming1);
            request.setAttribute("artist", artist1);
            request.setAttribute("vid", getid);
            request.setAttribute("spotid", SpotId);
            request.setAttribute("acc_tok", access_token);

            RequestDispatcher view = request.getRequestDispatcher("view.jsp");
            view.forward(request, response);

        } catch (Exception ex) {

        }
    }

}
