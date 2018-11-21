package angry_balls.controleur;

import angry_balls.modele.AnimationBilles;
import angry_balls.vues.CadreAngryBalls;
import angry_balls.modele.*;
import java.util.Vector;
import angry_balls.controleur.ecouteurs.*;
import angry_balls.controleur.evenements.*;

public class App{

    private ControleurState controleurCourant;
    private AnimationBilles animationBilles;
    private CadreAngryBalls cadreAngryBalls;
    private DetecteEvenement cliqueGauche; //renomer en écouteBilleAttrapée
    private DetecteEvenement arreter;
    private DetecteEvenement lancer;
    private DetecteEvenement fermer;
    private BilleDynamique billeCourante = null;

    private Vector<Bille> billes;

    public App(AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls, Vector<Bille> billes){

        this.animationBilles = animationBilles;
        this.cadreAngryBalls = cadreAngryBalls;
        this.billes = billes;
        
        ControleurBilleLibre bl = new ControleurBilleLibre(this);
        ControleurBilleAttrapee ba = new ControleurBilleAttrapee(this);

        bl.setSuivant(ba);
        ba.setPrecedent(bl);

        controleurCourant = bl;

        arreter = new DetecteBoutonAWT(cadreAngryBalls.arreterBilles);
        lancer = new DetecteBoutonAWT(cadreAngryBalls.lancerBilles);
        fermer = new DetecteFermerFenetreAWT(cadreAngryBalls);
        cliqueGauche = new DetecteClicGaucheEnfonceAWT(cadreAngryBalls.billard);

        //ajouter les observables

        arreter.ajouterObserveur(new EcouteurArreter(animationBilles));
        lancer.ajouterObserveur(new EcouteurLancer(animationBilles));
        fermer.ajouterObserveur(new EcouteurFermer());
        cliqueGauche.ajouterObserveur(new EcouteurBouttonEnfonce(bl));

    }

    public void setControleurCourant(ControleurState controleur){
        controleurCourant = controleur;
    }

    public Vector<Bille> getBilles(){
        return billes;
    }

    public void setBilleCourante(BilleDynamique bille){
        this.billeCourante = bille;
    }

    public BilleDynamique getBilleCourante(){
        return billeCourante;
    }

    public ControleurState getControleurCourant(){
        return controleurCourant;
    }

}