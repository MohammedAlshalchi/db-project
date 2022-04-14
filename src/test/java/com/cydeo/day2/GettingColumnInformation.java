package com.cydeo.day2;

import java.sql.*;

public class GettingColumnInformation {



    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(url,username,password) ;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   = stmt.executeQuery("SELECT * FROM EMPLOYEES") ;

        // We want to extract column information from above ResultSet object
        // First we need to ResultSetMetaData object by calling below method
        ResultSetMetaData rsmd = rs.getMetaData();
        // This ResultSetMetaData has 2 methods we care about
        //  getColumnCount method to get the count of column
        //  getColumnName or getColumnLabel using 1 based index
        System.out.println("rsmd.getColumnCount() = " + rsmd.getColumnCount() );

        System.out.println("rsmd.getColumnName(2) = " + rsmd.getColumnName(2));
int totalColumnCount = rsmd.getColumnCount();

        for (int columnIndex = 1; columnIndex <= totalColumnCount ; columnIndex++) {
            //            System.out.println("rsmd.getColumnName( "+columnIndex+" ) = "
//                    + rsmd.getColumnName(columnIndex) );
            System.out.println(rsmd.getColumnName(columnIndex));
        }

        // HOMEWORK :
        // NOW YOU KNOW HOW TO GO THROUGH ALL THE COLUMNS
        // AND HOW TO GO THROUGH ALL THE ROWS
        // WRITE A PIECE OF CODE THAT GO THROUGH EACH AND EVERY CELL
        // AND PRINT OUT IT'S VALUE





    }
}
