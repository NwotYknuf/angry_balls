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
    private DetecteEvenement billeAttrapee;
    private DetecteEvenement billeRelachee;
    private DetecteEvenement arreter;
    private DetecteEvenement lancer;
    private DetecteEvenement fermer;
    private BilleDynamique billeCourante = null;

    private Vector<Bille> billes;

    public App(AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls, Vector<Bille> billes){

        this.animationBilles = animationBilles;
        this.cadreAngryBalls = cadreAngryBalls;
        this.billes = billes;
        
        ControleurBilleLibre ctrBilleLibre = new ControleurBilleLibre(this);
        ControleurBilleAttrapee ctrBilleAttrapee = new ControleurBilleAttrapee(this);

        ctrBilleLibre.setSuivant(ctrBilleAttrapee);
        ctrBilleAttrapee.setPrecedent(ctrBilleLibre);

        controleurCourant = ctrBilleLibre;

        arreter = new DetecteBoutonAWT(cadreAngryBalls.arreterBilles);
        lancer = new DetecteBoutonAWT(cadreAngryBalls.lancerBilles);
        fermer = new DetecteFermerFenetreAWT(cadreAngryBalls);
        billeAttrapee = new DetecteClicGaucheEnfonceAWT(cadreAngryBalls.billard);
        billeRelachee = new DetecteClicGaucheRelacheAWT(cadreAngryBalls.billard);

        arreter.ajouterObserveur(new EcouteurArreter(animationBilles));
        lancer.ajouterObserveur(new EcouteurLancer(animationBilles));
        fermer.ajouterObserveur(new EcouteurFermer());
        billeAttrapee.ajouterObserveur(new EcouteurBilleAttrapee(ctrBilleLibre));
        billeRelachee.ajouterObserveur(new EcouteurBilleRelachee(ctrBilleAttrapee));

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