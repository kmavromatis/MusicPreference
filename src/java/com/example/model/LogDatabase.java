/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lord_tns
 */
public class LogDatabase {
    
    public boolean insert(String user,String pass) throws ClassNotFoundException, SQLException{
       System.out.println("eeeeeeee");
       String myDriver = "org.gjt.mm.mysql.Driver";
       String myUrl = "jdbc:mysql://localhost/logs";
       Class.forName(myDriver);
       Connection conn = DriverManager.getConnection(myUrl, "root", "root");
       
       boolean result;
       
        result=this.search(user,pass);    
        if(result==true){
            conn.close();
            return false;
        }else{
            Statement st=conn.createStatement();
            st.executeUpdate("INSERT INTO accs "+"VALUES ('"+user+"','"+pass+"')");
            conn.close();
            return true;
        }
        
    }
     
    
    
    
  public  boolean search(String user,String pass) throws ClassNotFoundException, SQLException{
      System.out.println("eeeeeeee");
        String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/logs";
      Class.forName(myDriver);
      try (Connection conn = DriverManager.getConnection(myUrl, "root", "root")) {
           String select= "SELECT pass FROM accs WHERE user = ?";
            PreparedStatement ps2 = conn.prepareStatement(select);
            ps2.setString(1,user);
            ResultSet rs2=ps2.executeQuery();
            while(rs2.next()){
                if (rs2.getString("pass").equals(pass)){
                    conn.close();
                    return true;

                }else{
                    conn.close();
                    return false;
                }
            
            }
       }
      return false;
    }
          
      
}
