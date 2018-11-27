package angry_balls.modele;

import java.util.Vector;
import angry_balls.mesmaths.geometrie.base.Vecteur;
import java.awt.Color;
import angry_balls.modele.comportement.*;
import angry_balls.vues.InfoCollision;


public class BilleDynamique extends Bille {

    private Vector<ComportementCollision> comportementsCollision;
    private Vector<ComportementAcceleration> comportementsAcceleration;

    public BilleDynamique(Vecteur position, double rayon, Vecteur vitesse, Color couleur){
        super(position, rayon, vitesse, couleur);
        comportementsAcceleration = new Vector<ComportementAcceleration>();
        comportementsCollision = new Vector<ComportementCollision>();
    }

    public void ajouterComportementCollision(ComportementCollision c){
        comportementsCollision.add(c);
    }

    public void supprimerComportementCollision(ComportementCollision comportement){
        comportementsCollision.remove(comportement);
    }

    public void supprimerComportementAcceleration(ComportementAcceleration comportement){
        comportementsAcceleration.remove(comportement);
    }

    public void ajouterComportementAcceleration(ComportementAcceleration c){
        comportementsAcceleration.add(c);
    }

    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur){
        
        for (ComportementCollision comportement : comportementsCollision) {
            comportement.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
        }
    }

    public boolean collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur, InfoCollision[] info){
        
        boolean collision = false;

        for (ComportementCollision comportement : comportementsCollision) {

            if(comportement.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur, info)){
                collision = true;
            }
        }

        return collision;

    }

    public void gestionAcceleration(Vector<Bille> billes){
        
        this.getAcceleration().set(Vecteur.VECTEURNUL);

        for (ComportementAcceleration comportement : comportementsAcceleration) {
            comportement.gestionAcceleration(billes);
        }
    }

}