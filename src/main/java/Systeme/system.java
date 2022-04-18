package Systeme;

import Detecteur.detectors.AbstractDecorator;
import Detecteur.detectors.AbstractMediator;
import Detecteur.detectors.Detectors;
import Detecteur.detectors.implementsDetecteur.*;
import Singleton.SingletonJDBC;
import StructureClasses.Alert;
import StructureClasses.Messages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class system {
    private Detectors sound=new GeneralDetector();
    private AbstractDecorator newDetectors= new BasicDecorator(new GeneralDetector());
    private LinkedList<Detectors> detectors = new LinkedList<>();
    private  LinkedList<Messages> messages = new LinkedList<>();
    private AbstractMediator mediator = new ConcreteMediator();


    public LinkedList<Detectors> getDetector() {

        try{
            Connection conn = SingletonJDBC.getConnection();
            String querry = "select * from detectors";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);

            ResultSet r = pstmt.executeQuery();
            while (r.next()){
             GeneralDetector generalDetector = new GeneralDetector();
             generalDetector.setIdentifiant((Integer) r.getObject("id"));
             generalDetector.setBrand((String) r.getObject("Brand"));
             generalDetector.setType((String) r.getObject("Type"));
            detectors.add(generalDetector);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return detectors;
    }



    public LinkedList<Messages> getAlarmsHistory() {
        try{
        Connection conn = SingletonJDBC.getConnection();
        String querry = "select * from messages";
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);

        ResultSet r = pstmt.executeQuery();
        while (r.next()){
            Messages message = new Messages();
            message.setData(""+ r.getObject("Data"));
            message.setTypeAlarm( ""+r.getObject("Type"));
            messages.add(message);
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
        return  this.messages;
    }


    public void SetNewDetector(String name, String type) {
        Detectors d = new GeneralDetector();
        d.setBrand(name);
        d.setType(type);
        try{
            Connection conn = SingletonJDBC.getConnection();
            String querry = "insert into detectors values (null,?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);
            pstmt.setString(1,name);
            pstmt.setString(2,type);

            int r = pstmt.executeUpdate();
            if (r==1){
                System.out.println("Done succesfully");;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

   public void EmulationEnvoyeMessageEntreAlarm(){
       LinkedList<Detectors> detectors= getDetector();
        Alert alert = detectors.get(0).SendAlert(Long.valueOf(1),"test");
        alert.MessageAlert="test";
       System.out.println(alert.MessageAlert);
        mediator.TransmettreAlert(alert,this.detectors);

       try{
           Connection conn = SingletonJDBC.getConnection();
           String querry = "insert into messages values (?,?,null,?)";
           PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(querry);
           pstmt.setString(1, alert.MessageAlert);
           pstmt.setString(2,"test");
           pstmt.setLong(3,alert.origin);


           int r = pstmt.executeUpdate();
           if (r==1){
               System.out.println("Done succesfully");;
           }
       }catch (SQLException e){
           e.printStackTrace();
       }

    }
}

