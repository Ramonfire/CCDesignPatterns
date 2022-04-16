package Systeme;

import Detecteur.detectors.Detectors;
import Singleton.SingletonJDBC;
import Users.account;
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
       sys.EmulationEnvoyeMessageEntreAlarm();

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
                                  "press n to add a new detector,To view your Active Destectors press v,press u to view user settings");
              state=scS.nextLine();

              switch (state){
                  case"l":continue;
                  case "v":{
                  LinkedList<Detectors> detectors= sys.getDetector();
                  for (Detectors d :detectors){
                      System.out.println(d.getType()+ " "+d.getBrand());
                  }
                  };
                  case "a":{
                      sys.getAlarmsHistory();
                      System.out.println(sys.getAlarmsHistory().toString());};
                  case "n":{
                      Scanner s= new Scanner(System.in);
                      System.out.println("inserer le nom de la marque du detecteur");
                      String name= s.nextLine();
                      System.out.println("inserer le type de cette detecteur(son , audio, facial, incendie)");
                      String type= s.nextLine();
                      System.out.println("operation en cours...");
                      sys.SetNewDetector(name,type);

                  };

                  case "u":{
                      System.out.println("To change admin click on a, to add users click on u, to view users click on v");

                      String uvar=scS.nextLine();



                      switch (uvar) {
                          case "u":{
                              users newuser= new users();
                              System.out.println("insert the users email");
                              newuser.setUsername(scS.nextLine());
                              System.out.println("insert the users email");
                              newuser.setPassword(scS.nextLine());
                              System.out.println("insert first name");
                              newuser.setFirstName(scS.nextLine());
                              System.out.println("insert last name");
                              newuser.setLastName(scS.nextLine());
                              newuser.setAccountType(false);

                          System.out.println(verify.AddUser(newuser));};

                          case "a" :{
                              System.out.println("insert the users email");
                              String mail= scS.nextLine();
                              System.out.println(verify.ChangeAdmin(mail));
                          };

                          case  "v":{
                             LinkedList<users> comptes= verify.ViewUsers();
                             for (users u:comptes){
                                 System.out.println(u.toString());
                             }

                          };


                      };



                  };

















              }


























          }


   }











   }
    }

