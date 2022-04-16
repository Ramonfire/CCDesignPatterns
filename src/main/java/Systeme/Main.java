package Systeme;

import Singleton.SingletonJDBC;
import Users.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
   public static void main(String[] args) {

        int r=0;
       users test=new users();
       test.setUsername("test");
       test.setPassword("test");
       test.setFirstName("test");
       test.setLastName("test");

       try{
           Connection conn = SingletonJDBC.getConnection();
           String querry = "insert into users values(null, ?, ?, ?, ?)";
           PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);
           pstmt.setString(1, test.getUsername());
           pstmt.setString(2,test.getPassword() );
           pstmt.setString(3, test.getFirstName());
           pstmt.setString(4, test.getLastName());

           r = pstmt.executeUpdate();
           if (r==1){
               System.out.println("success");
           }else System.out.println("failure");
       }catch (SQLException e){
           e.printStackTrace();
       }
   }
    }

