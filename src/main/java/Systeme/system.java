package Systeme;

import Detecteur.detectors.AbstractDecorator;
import Detecteur.detectors.Detectors;
import Detecteur.detectors.implementsDetecteur.*;
import Singleton.SingletonJDBC;

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

    public void getAlarmsHistory() {

    }
}
