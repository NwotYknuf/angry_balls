package angry_balls.modele;

import angry_balls.mesmaths.geometrie.base.Vecteur;
import java.util.Vector;
import java.awt.Color;

public abstract class BilleMaladroit extends Bille {

    public BilleMaladroit(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
        super(position, rayon, vitesse, new Vecteur(), couleur);
    }

    public void gestionAcceleration(Vector<Bille> billes) {
        this.getAcceleration().set(Vecteur.VECTEURNUL);
    }

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur);

}