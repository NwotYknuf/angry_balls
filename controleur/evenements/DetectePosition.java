package angry_balls.controleur.evenements;

import angry_balls.controleur.Observable;
import angry_balls.mesmaths.geometrie.base.Vecteur;

public class DetectePosition extends Observable{

    public DetectePosition(){

    }

    public void evenementA_LaPosition(Vecteur pos){
        this.setChange();
        this.notifierObserveurs(pos);
    }
    
}
