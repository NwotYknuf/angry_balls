package angry_balls.controleur;

public abstract class DetecteBoutton extends Observable{

    public DetecteBoutton(){

    }

    public void bouttonPresse(){
        this.setChange();
        this.notifierObserveurs();
    }

}