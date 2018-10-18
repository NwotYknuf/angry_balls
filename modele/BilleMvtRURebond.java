package angry_balls.modele;

import java.awt.Color;

import angry_balls.mesmaths.cinematique.Collisions;
import angry_balls.mesmaths.geometrie.base.Vecteur;

/**
 * 
 * Bille rebondissant sur les murs et subissant un mouvement rectiligne uniforme
 * (mouvment en ligne droite � vitesse constante)
 * 
 * 
 * A MODIFIER
 * 
 */
public class BilleMvtRURebond extends BilleMaladroit {

        public BilleMvtRURebond(Vecteur centre, double rayon, Vecteur vitesse, Color couleur) {
                super(centre, rayon, vitesse, couleur);

        }

        @Override
        public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
                        double hauteur) {
                Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(),
                                abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);

        }

}
