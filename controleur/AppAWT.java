package angry_balls.controleur;

import angry_balls.modele.AnimationBilles;
import angry_balls.vues.CadreAngryBalls;
import angry_balls.modele.*;
import java.util.Vector;
import angry_balls.controleur.ecouteurs.*;
import angry_balls.controleur.evenements.*;

public class AppAWT extends App{

    public AppAWT(AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls, Vector<Bille> billes){

        super(billes, animationBilles);

        ctrBilleLibre = new ControleurBilleLibre(this);
        ctrBilleAttrapee = new ControleurBilleAttrapeeAWT(this, cadreAngryBalls.billard);

        ctrBilleLibre.setSuivant(ctrBilleAttrapee);
        ctrBilleAttrapee.setPrecedent(ctrBilleLibre);

        setControleurCourant(ctrBilleLibre);

        arreter = new DetecteBoutonAWT(cadreAngryBalls.arreterBilles);
        lancer = new DetecteBoutonAWT(cadreAngryBalls.lancerBilles);
        fermer = new DetecteFermerFenetreAWT(cadreAngryBalls);
        billeAttrapee = new DetecteClicGaucheEnfonceAWT(cadreAngryBalls.billard);
        billeRelachee = new DetecteClicGaucheRelacheAWT(cadreAngryBalls.billard);

        arreter.ajouterObserveur(new EcouteurArreter(animationBilles));
        lancer.ajouterObserveur(new EcouteurLancer(animationBilles));
        fermer.ajouterObserveur(new EcouteurFermer(this));
        billeAttrapee.ajouterObserveur(new EcouteurBilleAttrapee(this.getControleurBilleLibre()));
        billeRelachee.ajouterObserveur(new EcouteurBilleRelachee(this.getControleurBilleAttrapee()));
    }
}