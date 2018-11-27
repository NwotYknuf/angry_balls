package angry_balls.modele.comportement;

import angry_balls.modele.*;
import angry_balls.vues.InfoCollision;
import angry_balls.mesmaths.cinematique.Collisions;
import angry_balls.mesmaths.geometrie.base.Vecteur;

public class Rebond extends ComportementCollision{

    public Rebond(Bille bille){
        super(bille);
    }

    public Rebond(Bille bille, String nom){
        super(bille, nom);
    }

    public boolean collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur){

        Bille billeCourante = this.getBilleCourante();
        Vecteur vitesse = new Vecteur(billeCourante.getVitesse());

        Collisions.collisionBilleContourAvecRebond(
            billeCourante.getPosition(), 
            billeCourante.getRayon(), 
            billeCourante.getVitesse(),
            abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);

        if(!vitesse.equals(billeCourante.getVitesse())){
            return true;
        }

        return false;

    }

    public boolean collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur, InfoCollision[] info){

        Bille billeCourante = this.getBilleCourante();
        Vecteur vitesse = new Vecteur(billeCourante.getVitesse());        
        info[0] = new InfoCollision("BilleMur", 0.0, 0.0);

        Collisions.collisionBilleContourAvecRebond(
            billeCourante.getPosition(), 
            billeCourante.getRayon(), 
            billeCourante.getVitesse(),
            abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);

        if(!vitesse.equals(billeCourante.getVitesse())){
            //collision

            info[0].pos_x = billeCourante.getPosition().x;

            if(vitesse.x == billeCourante.getVitesse().x){
                //On a tapé le mur du haut ou du bas
                info[0].intensite = Math.abs(vitesse.y);
            }
            else{
                info[0].intensite = Math.abs(vitesse.x);
            }           

            return true;
        }

        return false;

    }

}
