/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.sql.*;
import java.util.*;

/**
 *
 * @author lord_tns
 */
public class Database {

    public ArrayList<String> search(String users) throws SQLException {
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/music";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            ArrayList<String> ar = new ArrayList<String>();
            String select = "SELECT song FROM users WHERE id = ?";
            PreparedStatement ps2 = conn.prepareStatement(select);
            ps2.setString(1, users);
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                //System.out.println("apotelesma"+rs2.getString("song"));
                ar.add(rs2.getString("song"));

            }
            conn.close();
            return ar;

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

   public void insert(String users, String value) throws SQLException {
        int check = 0;
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/music";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String find_name = "SELECT id FROM users WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(find_name);
            ps.setString(1, users);
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
            } else {
                System.out.println("EDW EIMAI");
                Statement st = conn.createStatement();
                st.executeUpdate("INSERT INTO users " + "VALUES ('" + users + "','" + value + "')");
                conn.close();
                return;
            }

            String select = "SELECT song FROM users WHERE id = ?";

            PreparedStatement ps2 = conn.prepareStatement(select);

            ps2.setString(1, users);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                if (rs2.getString("song").equals(value)) {
                    check = 1;

                }

            }
            if (check == 0) {
                Statement st = conn.createStatement();
                st.executeUpdate("INSERT INTO users " + "VALUES ('" + users + "','" + value + "')");
            } else {
                System.out.println("yphrxe hdh");

            }
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            e.printStackTrace();

        }
    }

}
