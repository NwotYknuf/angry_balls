package angry_balls.modele.comportement;

import angry_balls.modele.*;
import angry_balls.vues.InfoCollision;
import angry_balls.mesmaths.cinematique.Collisions;
import angry_balls.mesmaths.geometrie.base.Vecteur;

public class Bloque extends ComportementCollision{

    public Bloque(Bille bille){
        super(bille);
    }

    public Bloque(Bille bille, String nom){
        super(bille, nom);
    }

    public boolean collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur){

        Bille billeCourante = this.getBilleCourante();
        Vecteur vitesse = new Vecteur(billeCourante.getVitesse());
        boolean collision = false;

        Collisions.collisionBilleContourAvecArretHorizontal(
            billeCourante.getPosition(), 
            billeCourante.getRayon(),
            billeCourante.getVitesse(), 
            abscisseCoinHautGauche, largeur);

        if(vitesse.x != billeCourante.getVitesse().x){
            collision = true;
        }
        

        Collisions.collisionBilleContourAvecArretVertical(
            billeCourante.getPosition(), 
            billeCourante.getRayon(),
            billeCourante.getVitesse(), 
            ordonneeCoinHautGauche, hauteur);


        if(vitesse.y != billeCourante.getVitesse().y){
            collision = true;
        }
        
        return collision;
    }

    public boolean collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur, InfoCollision[] info){

        Bille billeCourante = this.getBilleCourante();
        Vecteur vitesse = new Vecteur(billeCourante.getVitesse());
        boolean collision = false;
        info[0] = new InfoCollision("BilleMur", 0.0, 0.0);

        Collisions.collisionBilleContourAvecArretHorizontal(
            billeCourante.getPosition(), 
            billeCourante.getRayon(),
            billeCourante.getVitesse(), 
            abscisseCoinHautGauche, largeur);

        if(vitesse.x != billeCourante.getVitesse().x){
            collision = true;
            //collision contre mur gauche ou droite
            info[0].pos_x = billeCourante.getPosition().x;
            info[0].intensite = Math.abs(vitesse.x);
        }
        

        Collisions.collisionBilleContourAvecArretVertical(
            billeCourante.getPosition(), 
            billeCourante.getRayon(),
            billeCourante.getVitesse(), 
            ordonneeCoinHautGauche, hauteur);


        if(vitesse.y != billeCourante.getVitesse().y){
            collision = true;
            //collision contre mur gauche ou droite
            info[0].pos_x = billeCourante.getPosition().x;
            info[0].intensite = Math.abs(vitesse.y);
        }
        
        return collision;
    }

}