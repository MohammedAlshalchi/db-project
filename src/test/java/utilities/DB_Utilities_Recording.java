package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DB_Utilities_Recording {
private static Connection conn;
private static  ResultSet rs;
private static  Statement stmt;


    public static void createConnection(){
        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;
        try {
             conn = DriverManager.getConnection(url,username,password) ;
            System.out.println("Conecction successful");

        } catch (SQLException e) {
            System.out.println( "Connection has failed"+e.getSQLState() );
            e.printStackTrace();
        }
    }



public static ResultSet runQuery (String query){
    try {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery(query);
    } catch (SQLException e) {
        System.out.println("Error while Getting result"+e.getMessage());
    }
    return rs ;
}




public static void destroy (){
        try {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e){
e.printStackTrace();
        }
}


public static int getRowCount(){
     int rowCount =0 ;
    try {
        rs.last();
        rowCount = rs.getRow();
        rs.beforeFirst();
    } catch (SQLException e) {
        System.out.println("ERROR WHILE GETTING ROW COUNT"+e.getMessage());
    }
    return rowCount;
}


    public static int getColumnCNT(){
        int colCount = 0;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE COUNTING THE COLUMNS" + e.getMessage());
        }

return colCount;
    }



    public static List<String> getColumnNames(){
       List<String> colNamesList = new ArrayList<>();
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int colNum = 1; colNum <= rsmd.getColumnCount(); colNum++) {
              String colName = rsmd.getColumnLabel(colNum);
              colNamesList.add(colName);
            }
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING COLUMN NAMES" + e.getMessage());
        }

return colNamesList;
    }



   public static List<String>getRowDataAsList(int rowNum){
       List<String>rowDataList = new ArrayList<>();

       try {
           rs.absolute(rowNum);
           for (int colnum = 1; colnum <= getColumnCNT() ; colnum++) {
               String cellValue = rs.getString(colnum);
               rowDataList.add(cellValue);
           }
           rs.beforeFirst();
       } catch (SQLException e) {
           System.out.println("ERROR WHILE getRowDataAsList " + e.getMessage());
       }


       return rowDataList;
   }


   public static String getColumnDataAtRow (int rowNum , int columnIndex){

       String result = "" ;
       try {
           rs.absolute(rowNum);
           result = rs.getString(columnIndex);
           rs.beforeFirst();
       } catch (SQLException e) {
           System.out.println("ERROR WHILE getColumnDataAtRow " + e.getMessage());
       }


       return result;
   }


    public static String getColumnDataAtRow (int rowNum , String columnName){

        String result = "" ;
        try {
            rs.absolute(rowNum);
            result = rs.getString(columnName);
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE getColumnDataAtRow " + e.getMessage());
        }
        return result;
    }



public static List<String> getColumnDataAsList(int columnIndex){
List<String> columnDataList = new ArrayList<>();

try {
    rs.beforeFirst();
    while (rs.next()){
       String cellValue = rs.getString(columnIndex);
       columnDataList.add(cellValue);

    }
rs.beforeFirst();
}catch (SQLException e){
    System.out.println("ERROR WHILE getColmunDataAsList " + e.getMessage());
}
 return columnDataList;
}


public static List<String>getColumnDataAsList(String columnName){
    List<String> columnDataList = new ArrayList<>();

    try {
        rs.beforeFirst();
        while (rs.next()){
            String cellValue = rs.getString(columnName);
            columnDataList.add(cellValue);

        }
        rs.beforeFirst();

    }catch (SQLException e){
        System.out.println("ERROR WHILE getColmunDataAsList " + e.getMessage());
    }
    return columnDataList;
}




public static void displayAllData(){

    try {
        rs.beforeFirst();
        while (rs.next()){
            for (int colNum = 1; colNum <= getColumnCNT() ; colNum++) {
                System.out.print(rs.getString(colNum)+"\t");
            }
            System.out.println();
        }
    } catch (SQLException e) {
        System.out.println("ERROR WHILE DISPLAYING ALL DATA " + e.getMessage());
    }
}




public static Map<String,String> getRowMap ( int rowNum){
    Map<String,String> rowMap = new LinkedHashMap<>() ;
    try {
        rs.absolute(rowNum);
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int colNum = 1; colNum <= getColumnCNT() ; colNum++) {
          String colName = rsmd.getColumnLabel(colNum);
          String cellValue = rs.getString(colNum);
          rowMap.put(colName,cellValue);
        }
        rs.beforeFirst();
    } catch (SQLException e) {
        System.out.println("ERROR AT ROW MAP FUNCTION " + e.getMessage());
    }
    return rowMap;
}






public static List< Map<String,String> >getAllDataAsListOfMap(){
  List< Map<String,String> > rowMapList = new ArrayList<>();
    for (int rowNum  = 1; rowNum  <= getColumnCNT() ; rowNum ++) {
       rowMapList.add(getRowMap(rowNum)) ;
    }

        return rowMapList;
}




public static String getFirstData (){
    return getColumnDataAtRow(1,1);

}






    public static void main(String[] args) throws SQLException {

createConnection();
ResultSet MyResult = runQuery("SELECT * FROM EMPLOYEES");
rs.next();
        System.out.println(rs.getString(1));
        System.out.println(getRowCount());
        System.out.println(getColumnCNT());
        System.out.println(getColumnNames());
        System.out.println(getRowDataAsList(3));
        System.out.println("3rd row second column " + getColumnDataAtRow(3, 2));
        System.out.println("3rd row REGION_NAME column " + getColumnDataAtRow(3, "REGION_NAME"));
        System.out.println("1st column as list " +getColumnDataAsList(1) );
        System.out.println("1st column as list " +getColumnDataAsList("REGION_ID") );
        displayAllData();
        System.out.println(getRowMap(3));
        Map<String,String> thirdRowMap = getRowMap(3);
        System.out.println("get the last name " + thirdRowMap.get("LAST_NAME"));
        System.out.println(getAllDataAsListOfMap());
       // getFirstData();

        destroy();
    }














}
