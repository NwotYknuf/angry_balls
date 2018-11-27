package angry_balls.modele.comportement;

import angry_balls.modele.*;
import angry_balls.vues.InfoCollision;
import angry_balls.mesmaths.cinematique.Collisions;

public class PasseMuraille extends ComportementCollision{

    public PasseMuraille(Bille bille){
        super(bille);
    }

    public PasseMuraille(Bille bille, String nom){
        super(bille, nom);
    }

    public boolean collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur){

        Bille billeCourante = this.getBilleCourante();

        Collisions.collisionBilleContourPasseMuraille(
            billeCourante.getPosition(), 
            abscisseCoinHautGauche,ordonneeCoinHautGauche, largeur, hauteur);

        //On a jamais de collision avec le passe muraille
        return false;

    }

    public boolean collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur, InfoCollision[] info){

        Bille billeCourante = this.getBilleCourante();

        Collisions.collisionBilleContourPasseMuraille(
            billeCourante.getPosition(), 
            abscisseCoinHautGauche,ordonneeCoinHautGauche, largeur, hauteur);

        //On a jamais de collision avec le passe muraille
        return false;

    }

}