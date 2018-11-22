package angry_balls.controleur.ecouteurs;
import angry_balls.controleur.*;
import angry_balls.mesmaths.geometrie.base.Vecteur;


public class EcouteurMouvement implements Observeur {
    private ControleurBilleAttrapee controleur;

    public EcouteurMouvement(ControleurBilleAttrapee controleur) {
        this.controleur = controleur;
    }

    public void update(Observable o, Object arg) {
        Vecteur pos = (Vecteur)arg;
        controleur.nouvellePositionSouris(pos);
    }
}
