package electricity.bill.generator;

import java.sql.*;

public class Conn {
 
    Connection c;
    Statement s;
    Conn(){
        try{
       c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "Mynewproject");
       s = c.createStatement();
       }catch(Exception e){
       e.printStackTrace();
       }
    }
}
