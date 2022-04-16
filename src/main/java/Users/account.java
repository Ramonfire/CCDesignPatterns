package Users;

import StructureClasses.Visiteur;
import StructureClasses.activity;

import java.util.LinkedList;


public abstract class account {
    
    
    public users login(){
       users logged =new users();
        return  logged;
    }

    public void logout(){
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

}
