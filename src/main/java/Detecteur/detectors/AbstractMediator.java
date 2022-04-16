package Detecteur.detectors;

import StructureClasses.Alert;

import java.util.List;

public abstract class AbstractMediator {

    public void TransmettreAlert(Alert alert, List<Detectors> detectors){
        for (Detectors x :detectors){
            if (alert.Destinataire==x.getIdentifiant()){
                x.receiveAlert(alert);
            }else {continue;}
        }
    }
}
