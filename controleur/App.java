package angry_balls.controleur;

import angry_balls.modele.AnimationBilles;
import angry_balls.vues.CadreAngryBalls;

public class App{

    private ControleurState controleurCourant;
    private AnimationBilles animationBilles;
    private CadreAngryBalls cadreAngryBalls;
    private DetecteBoutton arreter;
    private DetecteBoutton lancer;
    private DetecteBoutton fermer;

    public App(AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls){

        this.animationBilles = animationBilles;
        this.cadreAngryBalls = cadreAngryBalls;
        
        ControleurBilleLibre bl = new ControleurBilleLibre(this);
        ControleurBilleAttrapee ba = new ControleurBilleAttrapee(this);

        bl.setSuivant(ba);
        ba.setPrecedent(bl);

        controleurCourant = bl;

        arreter = new DetecteBouttonAWT(cadreAngryBalls.arreterBilles);
        lancer = new DetecteBouttonAWT(cadreAngryBalls.lancerBilles);
        fermer = new DetecteBouttonFermerAWT(cadreAngryBalls);

        //ajouter les observables

        arreter.ajouterObserveur(new EcouteurBoutonArreter(animationBilles));
        lancer.ajouterObserveur(new EcouteurBoutonLancer(animationBilles));
        fermer.ajouterObserveur(new EcouteurTerminaison());

    }

    public void setControleurCourant(ControleurState controleur){
        controleurCourant = controleur;
    }

}