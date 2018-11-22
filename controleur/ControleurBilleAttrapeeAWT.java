package angry_balls.controleur;

import angry_balls.controleur.ecouteurs.EcouteurMouvement;
import angry_balls.controleur.evenements.DetecteMouvementSourieAWT;
import angry_balls.vues.Billard;

public class ControleurBilleAttrapeeAWT extends ControleurBilleAttrapee{

    public ControleurBilleAttrapeeAWT(App app, Billard billard){
        super(app);
        
        mouvement = new DetecteMouvementSourieAWT(billard);
        mouvement.ajouterObserveur(new EcouteurMouvement(this));
    }

}