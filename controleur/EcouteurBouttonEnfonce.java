package angry_balls.controleur;

import angry_balls.mesmaths.geometrie.base.Vecteur;

public class EcouteurBouttonEnfonce implements Observeur{

    private ControleurBilleLibre controleur;

    public EcouteurBouttonEnfonce(ControleurBilleLibre controleur){
        this.controleur = controleur;
    }

    public void update(Observable o, Object arg){
        Vecteur pos = (Vecteur)arg;
        controleur.actionDetectee(pos);
    }

}