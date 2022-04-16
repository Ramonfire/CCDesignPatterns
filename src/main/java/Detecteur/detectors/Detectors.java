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

    private Boolean receiveAlert( Alert alert){
        Boolean value= Boolean.FALSE;


        return  value;
    }

    private String SendAlert(Alert alert){
        String response= "Error";

        return  response;
    }

    private void notifieSystem(){

    }


}
