package angry_balls.modele.comportement;

import angry_balls.modele.*;
import angry_balls.mesmaths.cinematique.Collisions;

public class Rebond extends ComportementCollision{

    public Rebond(Bille bille){
        super(bille);
    }

    public Rebond(Bille bille, String nom){
        super(bille, nom);
    }

    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur){

        Bille billeCourante = this.getBilleCourante();

        Collisions.collisionBilleContourAvecRebond(
            billeCourante.getPosition(), 
            billeCourante.getRayon(), 
            billeCourante.getVitesse(),
            abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }

}
