/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;
import java.sql.*;

/**
 *
 * @author lord_tns
 */
public class database {
     public static void main(String[] args)
  {
    try
    {
      // create a mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/music";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "root");
      Statement st = conn.createStatement();
       st.executeUpdate("INSERT INTO users " +"VALUES ('aaaaa', 'testsong')");
       conn.close();
       

    
    } catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
}