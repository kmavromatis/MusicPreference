/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import org.apache.commons.codec.binary.Base64;

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

public class FindSimilars {

    String limit = "&limit=5";
    float scaling = 0.15f;
    float dbscal = 5.0f;
    float tempscal = 20.0f;

    public String[] getSim(String access_token, String id, float[] features) throws IOException {
        
       

        float acoust_min, acoust_max;
        acoust_min = features[3];
        acoust_min = (acoust_min - scaling) > 0.0 ? (acoust_min - scaling) : 0.0f;
        acoust_max = features[3];
        acoust_max = (acoust_max + scaling) < 1.0f ? (acoust_max + scaling) : 1.0f;

        float speec_min, speec_max;
        speec_min = features[0];
        speec_min = (speec_min - scaling) > 0.0 ? (speec_min - scaling) : 0.0f;
        speec_max = features[0];
        speec_max = (speec_max + scaling) < 1.0f ? (speec_max + scaling) : 1.0f;

        float tem_min, tem_max;
        tem_min = features[1];
        tem_min = (tem_min - tempscal);
        tem_max = features[1];
        tem_max = (tem_max + tempscal);

        float danc_min, danc_max;
        danc_min = features[2];
        danc_min = (danc_min - scaling) > 0.0 ? (danc_min - scaling) : 0.0f;
        danc_max = features[2];
        danc_max = (danc_max + scaling) < 1.0f ? (danc_max + scaling) : 1.0f;

        float liv_min, liv_max;
        liv_min = features[4];
        liv_min = (liv_min - scaling);
        liv_max = features[4];
        liv_max = (liv_max + scaling);

        float val_min, val_max;
        val_min = features[5];
        val_min = (val_min - scaling) > 0.0 ? (val_min - scaling) : 0.0f;
        val_max = features[5];
        val_max = (val_max + scaling) < 1.0f ? (val_max + scaling) : 1.0f;

        float loud_min, loud_max;
        loud_min = features[6];
        loud_min = (loud_min - dbscal);
        loud_max = features[6];
        loud_max = (loud_max + dbscal);

        float ener_min, ener_max;
        ener_min = features[7];
        ener_min = (ener_min - scaling) > 0.0 ? (ener_min - scaling) : 0.0f;
        ener_max = features[7];
        ener_max = (ener_max + scaling) < 1.0f ? (ener_max + scaling) : 1.0f;

        String url = "https://api.spotify.com/v1/recommendations?"
                + "seed_tracks=" + id    //allakse kai to apo katw
                + "&min_speechiness=" + Float.toString(speec_min)
                + "&max_speechiness=" + Float.toString(speec_max)
                + "&min_tempo=" + Float.toString(tem_min)
                + "&max_tempo=" + Float.toString(tem_max)
                + "&min_danceability=" + Float.toString(danc_min)
                + "&max_danceability=" + Float.toString(danc_max)
                + "&min_acousticness=" + Float.toString(acoust_min)
                + "&max_acousticness=" + Float.toString(acoust_max)
                + "&min_liveness=" + Float.toString(liv_min)
                + "&max_liveness=" + Float.toString(liv_max)
                + "&min_valence=" + Float.toString(val_min)
                + "&max_valence=" + Float.toString(val_max)
                + "&min_loudness=" + Float.toString(loud_min)
                + "&max_loudness=" + Float.toString(loud_max)
                + "&min_energy=" + Float.toString(ener_min)
                + "&max_energy=" + Float.toString(ener_max)
                + limit;
        //return(url);
        
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

        String test = response2.toString();
   
        JSONParser parser = new JSONParser();

        
 
        try {
             
            JSONObject json = (JSONObject) parser.parse(new StringReader(test));

            //out.println(json);
            JSONArray tracks = (JSONArray) json.get("tracks");
            
            String[] simtracks =new String[5];
            for (int i = 0; i < tracks.size(); i++) {
                JSONObject onetrack = (JSONObject) tracks.get(i);
                JSONArray artists = (JSONArray) onetrack.get("artists");
                JSONObject oneart = (JSONObject) artists.get(0);
                String artist = (String) oneart.get("name");
                String naming = (String) onetrack.get("name");
               // out.println("new"+artist+"----"+naming);
               simtracks[i] = naming+" "+"("+artist+")";

            }
            
            return(simtracks);

        } catch (Exception ex) {
               return(null);
        }

       

    }

}
