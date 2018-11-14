package angry_balls.controleur;

public abstract class DetecteEvenement extends Observable{

    public DetecteEvenement(){

    }

    public void bouttonPresse(){
        this.setChange();
        this.notifierObserveurs();
    }

}