package Detecteur.detectors.implementsDetecteur;

import Detecteur.detectors.AbstractDecorator;
import Detecteur.detectors.Detectors;

public class BasicDecorator extends AbstractDecorator {

    public BasicDecorator(GeneralDetector generalDetector) {
        super(generalDetector);
    }
}
