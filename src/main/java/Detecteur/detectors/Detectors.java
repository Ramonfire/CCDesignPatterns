package Detecteur.detectors;

import StructureClasses.Alert;
import StructureClasses.Messages;

public  abstract class Detectors {
    private int identifiant;
    private String brand;
    private String type;
    private  Messages message;
    private Alert alert;
    private int cmp=0;

    public Detectors() {
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = cmp++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Messages getMessage() {
        return message;
    }

    public void setMessage(Messages message) {
        this.message = message;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public void receiveAlert( Alert alert){
        this.alert=alert;
        System.out.println("received an alerm from " +alert.origin);
        System.out.println("Content : " + alert.MessageAlert);
    }

    public Alert SendAlert(Long destinataire,String data){
        Alert alert1=new Alert();
        alert1.MessageAlert=data;
        alert1.Destinataire=destinataire;
        alert1.origin=Long.valueOf(this.getIdentifiant());
        return  alert1;
    }

    public void notifieSystem(){

    }


}
