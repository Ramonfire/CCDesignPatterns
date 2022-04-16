package Detecteur.detectors;

import StructureClasses.Alert;
import StructureClasses.Messages;

public  abstract class Detectors {
    private Long identifiant;
    private String brand;
    private String type;
    private  Messages message;
    private Alert alert;


    private Boolean receiveAlert(Long from,Alert alert){
        Boolean value= Boolean.FALSE;


        return  value;
    }

    private String SendAlert(Alert alert,Long To){
        String response= "Error";

        return  response;
    }

    private void notifieSystem(){

    }


}
