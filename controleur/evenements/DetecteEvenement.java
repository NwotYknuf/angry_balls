package angry_balls.controleur.evenements;

import angry_balls.controleur.*;
public abstract class DetecteEvenement extends Observable{

    public DetecteEvenement(){

    }

    public void evenementDeclenche(){
        this.setChange();
        this.notifierObserveurs();
    }

}