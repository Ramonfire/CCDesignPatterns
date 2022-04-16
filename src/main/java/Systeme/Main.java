package Systeme;

import Detecteur.detectors.Detectors;
import Singleton.SingletonJDBC;
import Users.proxy;
import Users.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {



        system sys = new system();
       Scanner scS = new Scanner(System.in);
       proxy p = new proxy();
       users verify = new users();
       String state="l";

      while (true) {
          if (state.equals("l")){
           System.out.println("Insert your email");
           String email = scS.nextLine();
           System.out.println("Insert your pasword");
           String password = scS.nextLine();
           verify = p.login(email, password);
           System.out.println(verify.toString());
          state="";
          }
          else {
              System.out.println("To logout press l,to view your alarm history press a, to view your house activity press h," +
                                  "press n to add a new detector,To view your Active Destectors press v");
              state=scS.nextLine();

              switch (state){
                  case"l":continue;
                  case "v":{
                  LinkedList<Detectors> detectors= sys.getDetector();
                  for (Detectors d :detectors){
                      System.out.println(d.getType()+ " "+d.getBrand());

                  }
                  }
                  case "a":
                      sys.getAlarmsHistory();



              }


























          }


   }











   }
    }

