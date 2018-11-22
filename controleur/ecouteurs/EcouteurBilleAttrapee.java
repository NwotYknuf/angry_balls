package angry_balls.controleur.ecouteurs;

import angry_balls.controleur.*;
import angry_balls.mesmaths.geometrie.base.Vecteur;

public class EcouteurBilleAttrapee implements Observeur{//renommer en EcouteurBilleAttrape

    private ControleurBilleLibre controleur;

    public EcouteurBilleAttrapee(ControleurBilleLibre controleur){
        this.controleur = controleur;
    }

    public void update(Observable o, Object arg){
        Vecteur pos = (Vecteur)arg;
        controleur.actionDetectee(pos);
    }

}