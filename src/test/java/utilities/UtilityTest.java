package utilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UtilityTest {
// 18. verify first country in countries table is Argentina (using db_util class)
    @BeforeClass
    public void setUp(){
        String url_HR = "jdbc:oracle:thin:@18.205.117.23:1521:XE" ;
        String userName_hr = "hr" ;
        String passWord_hr = "hr" ;

        DB_Util.createConnection(url_HR,userName_hr,passWord_hr);


    }

@AfterClass
public void tearDown(){
        DB_Util.destroy();
}



@Test
    public void firstCountry(){

String expectedValue = "Argentina";
DB_Util.runQuery("select COUNTRY_NAME from countries where rownum = 1");
String  actualResult = DB_Util.getCellValue(1,1);
    System.out.println(actualResult);
    Assert.assertEquals(expectedValue,expectedValue);

}



@Test
    public void test2(){
        //19. verify employees table has 107 row (using db_util class)
      int expectedValue = 107;
      DB_Util.runQuery("select * from employees");
      int actualValue = DB_Util.getRowCount();
      Assert.assertEquals(actualValue,expectedValue);

}
@Test
    public void getAllData(){
   //20. get all data from locations table (using db_util class)
DB_Util.runQuery("select * from locations");
DB_Util.displayAllData();



}



}
