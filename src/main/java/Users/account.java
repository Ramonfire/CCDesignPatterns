package Users;

import Singleton.SingletonJDBC;
import StructureClasses.Visiteur;
import StructureClasses.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public abstract class account {
    
    
    public users login(String email,String password){
       users logged =new users();


        try{
            Connection conn = SingletonJDBC.getConnection();
            String querry = "select * from users where email=? and password=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);
            pstmt.setString(1,email);
            pstmt.setString(2,password );

            ResultSet r = pstmt.executeQuery();
                if (r.next()){
                    System.out.println("success");
                    logged.setUsername((String) r.getObject("email"));
                    logged.setPassword((String) r.getObject("password"));
                    logged.setFirstName((String) r.getObject("name"));
                    logged.setLastName((String) r.getObject("familyname"));

                }else {System.out.println("failure");}
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  logged;
    }

    public users logout(){
        return new users();
    }

    public  void verifyalarms(){

    }

    public String ChangeAdmin(){
       String response= "Error";

       return  response;
    }

    public LinkedList<users> ViewUsers(){
       LinkedList<users> Utilisateurs=new LinkedList<users>();

       return  Utilisateurs;
    }

    public String AddUser(users users){
        String response= "Error";

        return response;
    }

    public LinkedList<activity> ViewActivity(){
    LinkedList<activity> activities = new LinkedList<activity>();


    return  activities;
  }

    public  String ActiverAlarm(){
       String response="Error";

       return  response;
}

    public  String DesactiverAlarm(){
        String response="Error";

        return  response;
    }

    public void Ecouter(){

    }

    public  void Observer(){

    }

    public LinkedList<Visiteur> VerifierVisiteurs(){
        LinkedList<Visiteur> visiteurs=new LinkedList<Visiteur>();

        return visiteurs;
    }

    public  String DesactiverDetecteur(){
        String response="Error";

        return  response;
    }
public boolean isLoggedin(users user){
        return  false;
}

}
