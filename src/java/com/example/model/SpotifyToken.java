/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import org.apache.commons.codec.binary.Base64;

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

public class SpotifyToken {

    public String getAuth() throws IOException {
        String clientid = "2b30eeec4f284508b3814d1deb6a7a70";
        String clientsecret = "f7baf0b941b643b79f52e8c7590ea01b";
        String idSecret = clientid + ":" + clientsecret;
        String idSecretEncoded = new String(Base64.encodeBase64(idSecret.getBytes()));
        //PrintWriter out = response.getWriter();
        // response.setContentType("text/html");
        String url = "https://accounts.spotify.com/api/token";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Basic " + idSecretEncoded);
        //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "grant_type=client_credentials";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'POST' request to URL : " + url);
        //System.out.println("Post parameters : " + urlParameters);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        //System.out.println(response.toString());
        JSONParser parser = new JSONParser();

        String test = response.toString();
        try {
            JSONObject json = (JSONObject) parser.parse(new StringReader(test));

            //out.println(json);
            String access_token = (String) json.get("access_token");
            // out.println(accesstoken);
             return access_token;
        } catch (Exception e) {
            return null;
        }
       
    }

}
