package angry_balls.modele;

import java.awt.Color;
import java.util.Vector;

import angry_balls.mesmaths.cinematique.Collisions;
import angry_balls.mesmaths.geometrie.base.Vecteur;
import angry_balls.mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille s'arr�tant sur les bords et subissant l'attraction des autres billes
 * 
 * 
 * A MODIFIER
 * 
 */

public class BilleMvtNewtonArret extends Bille {

        public BilleMvtNewtonArret(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
                super(position, rayon, vitesse, couleur);
        }

        /*
         * (non-Javadoc)
         * 
         * @see decorateur_angryballs.modele.Bille#gestionAcc�l�ration(java.util.Vector)
         */
        @Override
        public void gestionAcceleration(Vector<Bille> billes) {
                super.gestionAcceleration(billes); // remise � z�ro du vecteur acc�l�ration
                this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes)); // contribution de
                                                                                                    // l'acc�l�ration
                                                                                                    // due �
                                                                                                    // l'attraction des
                                                                                                    // autres billes
        }

        @Override
        public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
                        double hauteur) {
                Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(),
                                this.getVitesse(), abscisseCoinHautGauche, largeur);
                Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(),
                                this.getVitesse(), ordonneeCoinHautGauche, hauteur);
        }

}
