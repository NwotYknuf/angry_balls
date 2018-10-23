package angry_balls.modele.comportement;

import angry_balls.modele.*;
import angry_balls.mesmaths.cinematique.Collisions;

public class Bloque extends ComportementCollision{

    public Bloque(Bille bille){
        super(bille);
    }

    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur){

        Bille billeCourante = this.getBilleCourante();

        Collisions.collisionBilleContourAvecArretHorizontal(
            billeCourante.getPosition(), 
            billeCourante.getRayon(),
            billeCourante.getVitesse(), 
            abscisseCoinHautGauche, largeur);

        Collisions.collisionBilleContourAvecArretVertical(
            billeCourante.getPosition(), 
            billeCourante.getRayon(),
            billeCourante.getVitesse(), 
            ordonneeCoinHautGauche, hauteur);
    }

}