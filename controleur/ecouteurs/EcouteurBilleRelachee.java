package angry_balls.controleur.ecouteurs;

import angry_balls.controleur.Observable;
import angry_balls.controleur.Observeur;
import angry_balls.controleur.ControleurBilleAttrapee;

public class EcouteurBilleRelachee implements Observeur{

    private ControleurBilleAttrapee controleur;

    public EcouteurBilleRelachee(ControleurBilleAttrapee controleur){
        this.controleur = controleur;
    }

    public void update(Observable o, Object arg){
        controleur.actionDetectee(null);
    }

}
