package angry_balls.modele;

import java.util.Vector;
import angry_balls.mesmaths.geometrie.base.Vecteur;
import java.awt.Color;


public class BilleDynamique extends Bille {

    private Vector<ComportementCollision> comportementsCollision;
    private Vector<ComportementAcceleration> comportementAccelerations;

    public BilleDynamique(Vecteur position, double rayon, Vecteur vitesse, Color couleur){
        super(position, rayon, vitesse, couleur);
        comportementAccelerations = new Vector<ComportementAcceleration>();
        comportementsCollision = new Vector<ComportementCollision>();
    }

    public void ajouterComportementCollision(ComportementCollision c){
        comportementsCollision.add(c);
    }

    public void ajouterComportementAcceleration(ComportementAcceleration c){
        comportementAccelerations.add(c);
    }

    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur){
        //TODO implementer
    }

    public void gestionAcceleration(Vector<Bille> billes){
        //TODO implementer
    }

}