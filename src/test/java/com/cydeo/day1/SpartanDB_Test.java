package com.cydeo.day1;

import java.sql.*;

public class SpartanDB_Test {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@18.205.117.23:1521:XE";
        String username ="SP";
        String password = "SP";

        Connection conn = DriverManager.getConnection(url,username,password) ;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   = stmt.executeQuery("SELECT * FROM SPARTANS") ;

while (rs.next()){
    rs.next();
    System.out.println(rs.getString("SPARTAN_ID") + " " + rs.getString("NAME"));
}


    }

}
