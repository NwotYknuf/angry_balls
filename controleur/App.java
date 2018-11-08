package angry_balls.controleur;

import angry_balls.modele.AnimationBilles;
import angry_balls.vues.CadreAngryBalls;

public class App extends Observable{

    private ControleurState controleurCourant;
    private AnimationBilles animationBilles;
    private CadreAngryBalls cadreAngryBalls;

    public App(AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls){

        this.animationBilles = animationBilles;
        this.cadreAngryBalls = cadreAngryBalls;
        
        ControleurBilleLibre bl = new ControleurBilleLibre(this);
        ControleurBilleAttrapee ba = new ControleurBilleAttrapee(this);

        bl.setSuivant(ba);
        ba.setPrecedent(bl);

        controleurCourant = bl;

    }

    public void setControleurCourant(ControleurState controleur){
        controleurCourant = controleur;
    }

    public void notifierObserveurs(){
        //TODO
    }

    public void notifierObserveurs(Object arg){
        //TODO
    }

    public void setChange(){
        //TODO
    }



}