package Systeme;

import Singleton.SingletonJDBC;
import Users.proxy;
import Users.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {




       Scanner scS = new Scanner(System.in);
       proxy p = new proxy();
       users verify = null;

      // while (true) {

           verify = new users();
           System.out.println("Insert your email");
           String email = scS.nextLine();
           System.out.println("Insert your pasword");
           String password = scS.nextLine();
           verify = p.login(email, password);
           System.out.println(verify.toString());


  // }











   }
    }

