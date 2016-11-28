/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.googleapis.json.GoogleJsonResponseException;
//import com.google.api.services.samples.youtube.cmdline.Auth;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Calendar;
import java.util.List;
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



public class YoutubeId {
    
    public String getVid(String id, String artist) throws IOException{
        id = id.replaceAll(" ", "+");
        artist = artist.replaceAll(" ","+");
        String api_key="AIzaSyAN2coT_R79AkUhb9SlOd18c9W6wToVRyw";
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&key="+api_key+"&q="+id+"+"+artist+"&type=video&videoEmbeddable=true";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        
        
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
            JSONObject json = (JSONObject) parser.parse(new StringReader(test));
            
            //out.println(json);
            
            
           // JSONObject tracks =(JSONObject) json.get("");
            //JSONObject items = tracks.getJSONObject("items");
            
            JSONArray itemArr = (JSONArray)json.get("items");
            JSONObject each = (JSONObject) itemArr.get(0);
            JSONObject jid = (JSONObject) each.get("id");
            String vid = (String)jid.get("videoId");
             return vid;
           } catch (Exception ex) {

        }
       return url;
     
    }
    
    
    
}
