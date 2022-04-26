package utilities;
import java.sql.*;
public class JDBC {
    /*
1. get connection with hr database
    2. get connection with spartan database
    3. get top 2 first names from employees table using next() and different method
    4. get top 3 phone numbers from spartans table using next() and different method
    5. get every country name from countries table
    6. get every spartan name from spartans table
    7. get me first department name from departments table
    8. get me last street address from locations table
    9. get me "ResultSet.next was not called" exception
    10. get me "Result set after last row" exception
    11. get me 10th spartans's gender
    12. get me 5th job_title from jobs table
    13. get me the first created date(not including time) in spartans table
    14. get me 5th manager_id from departments table (dont' use getString() method)
    15. get me the highest salary from employees table ( don't use getInt or getString method)
    16. get me column numbers of spartans table
    17. get me all column names from job_history table
    18. value first country in countries table is Argentina (using db_util class)
    19. value employees table has 107 row (using db_util class)
    20. get all data from locations table (using db_util class)
*/


    public static void main(String[] args) throws SQLException {

//        1. get connection with hr database
//        2. get connection with spartan database

        String url_HR = "jdbc:oracle:thin:@18.205.117.23:1521:XE" ;
        String userName_hr = "hr" ;
        String passWord_hr = "hr" ;
        Connection conn_hr = DriverManager.getConnection(url_HR,userName_hr,passWord_hr);
        Statement stmt_hr = conn_hr.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        String url_sp = "jdbc:oracle:thin:@18.205.117.23:1521:XE" ;
        String userName_sp = "SP" ;
        String passWord_sp = "SP" ;
        Connection conn_sp = DriverManager.getConnection(url_sp,userName_sp,passWord_sp);
        Statement stmt_sp = conn_sp.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


//        3. get top 2 first names from employees table using next() and different method
        ResultSet rs_hr1 = stmt_hr.executeQuery("SELECT * FROM EMPLOYEES");
        rs_hr1.next();
        System.out.println(rs_hr1.getString(2));
        rs_hr1.next();
        System.out.println(rs_hr1.getString(2));

        System.out.println("================================================");





//        4. get top 3 phone numbers from spartans table using next() and different method
ResultSet rs_sp1 = stmt_sp.executeQuery("SELECT * FROM SPARTANS");
rs_sp1.next();
        System.out.println(rs_sp1.getString(4));
        rs_sp1.next();
        System.out.println(rs_sp1.getString("PHONE"));
        rs_sp1.next();
        System.out.println(rs_sp1.getString(4));
        System.out.println("================================================");

//        5. get every country name from countries table
ResultSet rs_hr2 = stmt_hr.executeQuery("SELECT COUNTRY_NAME FROM COUNTRIES");
while (rs_hr2.next()){
    System.out.println(rs_hr2.getString(1));
}

        System.out.println("================================================");

//        6. get every spartan name from spartans table
ResultSet rs_sp2 = stmt_sp.executeQuery("SELECT NAME FROM SPARTANS");
while (rs_sp2.next()){
    System.out.println(rs_sp2.getString(1));
}


        System.out.println("================================================");
//        7. get me first department name from departments table
ResultSet rs_hr3 = stmt_hr.executeQuery("SELECT  DEPARTMENT_NAME FROM DEPARTMENTS");
rs_hr3.next();
        System.out.println(rs_hr3.getString(1));


        System.out.println("================================================");
//        8. get me last street address from locations table
ResultSet rs_hr4 = stmt_hr.executeQuery("SELECT STREET_ADDRESS FROM LOCATIONS");
rs_hr4.next();
        System.out.println(rs_hr4.getString(1));
        System.out.println("================================================");
//        9. get me "ResultSet.next was not called" exception
ResultSet rs_hr5 = stmt_hr.executeQuery("SELECT *  FROM EMPLOYEES");
      //  System.out.println(rs_hr5.getString(1));


        System.out.println("================================================");
//        10. get me "Result set after last row" exception
rs_hr5.afterLast();
       // System.out.println(rs_hr5.getString(1));


        System.out.println("================================================");
//        11. get me 10th spartans's gender
ResultSet rs_sp3 = stmt_sp.executeQuery("SELECT GENDER FROM SPARTANS");
rs_sp3.absolute(10);
        System.out.println(rs_sp3.getString(1));


        System.out.println("================================================");
//        12. get me 5th job_title from jobs table
ResultSet rs_hr6= stmt_hr.executeQuery("SELECT  JOB_TITLE FROM JOBS");
rs_hr6.absolute(5);
        System.out.println(rs_hr6.getString(1));

        System.out.println("================================================");
//        13. get me the first created date(not including time) in spartans table
ResultSet rs_sp4 = stmt_sp.executeQuery("SELECT created_AT FROM SPARTANS");
rs_sp4.next();
        System.out.println(rs_sp4.getDate(1));

        System.out.println("================================================");
//        14. get me 5th manager_id from departments table (dont' use getString() method)
ResultSet rs_hr7 = stmt_hr.executeQuery("SELECT MANAGER_ID FROM DEPARTMENTS");
rs_hr7.absolute(5);
        System.out.println(rs_hr7.getInt(1));


        System.out.println("================================================");
//        15. get me the highest salary from employees table ( don't use getInt or getString method)
ResultSet rs_hr8 = stmt_hr.executeQuery("SELECT MAX(SALARY) FROM EMPLOYEES");
rs_hr8.next();
        System.out.println(rs_hr8.getDouble(1));

        System.out.println("================================================");
//        16. get me column numbers of spartans table
ResultSet rs_sp5 = stmt_sp.executeQuery("SELECT * FROM SPARTANS");
ResultSetMetaData rsmd_sp = rs_sp5.getMetaData();
        System.out.println(rsmd_sp.getColumnCount());


        System.out.println("================================================");
//        17. get me all column names from job_history table
        ResultSet rs_hr10 = stmt_hr.executeQuery("SELECT * FROM JOB_HISTORY");
        ResultSetMetaData rsmd_hr = rs_hr10.getMetaData();
        int columnCount = rsmd_hr.getColumnCount();
        for (int i = 1; i <= columnCount ; i++) {
            System.out.println(rsmd_hr.getColumnName(i));
        }

        System.out.println("================================================");
//        18. verify first country in countries table is Argentina (using db_util class)


        System.out.println("================================================");
//        19. value employees table has 107 row (using db_util class)
//        20. get all data from locations table (using db_util class)































    }
}
