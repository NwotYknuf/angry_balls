package angry_balls.modele;

import angry_balls.mesmaths.geometrie.base.Vecteur;
import java.awt.Color;

public class BillePrehensible extends BilleDynamique{

    private ControleurBille controleur;

    public BillePrehensible(Vecteur position, double rayon, Vecteur vitesse, Color couleur){
        super(position, rayon, vitesse, couleur);
    }

    public void setControleurCourrant(ControleurBille controleur){
        this.controleur = controleur;
    }

}
