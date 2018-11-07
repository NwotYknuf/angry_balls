package angry_balls.controleur;

import javax.xml.bind.Marshaller.Listener;

import angry_balls.AnimationBilles;
import angry_balls.outilsvues.EcouteurTerminaison;
import angry_balls.vues.CadreAngryBalls;

public class App{

    private ControleurState controleurCourant;
    private AnimationBilles animationBilles;
    private CadreAngryBalls cadreAngryBalls;

    private Listener l;

    public App(AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls){

        this.animationBilles = animationBilles;
        this.cadreAngryBalls = cadreAngryBalls;
        
        ControleurBilleLibre bl = new ControleurBilleLibre(this);
        ControleurBilleAttrapee ba = new ControleurBilleAttrapee(this);

        bl.setSuivant(ba);
        ba.setPrecedent(bl);

        controleurCourant = bl;

        cadreAngryBalls.lancerBilles.addActionListener(new EcouteurBoutonLancer(animationBilles));
        cadreAngryBalls.arreterBilles.addActionListener(new EcouteurBoutonArreter(animationBilles));
        cadreAngryBalls.addWindowListener(new EcouteurTerminaison(cadreAngryBalls));


    }

    public void setControleurCourant(ControleurState controleur){
        controleurCourant = controleur;
    }





}