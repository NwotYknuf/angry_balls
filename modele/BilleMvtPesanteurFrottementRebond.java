package angry_balls.modele;

import java.awt.Color;
import java.util.Vector;

import angry_balls.mesmaths.cinematique.Collisions;
import angry_balls.mesmaths.geometrie.base.Vecteur;
import angry_balls.mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille rebondissant sur les murs, subissant un mouvement rectiligne (mouvement
 * en ligne droite) et subissant le frottement dans l'air
 * 
 * Soumis � un vecteur pesanteur
 * 
 * 
 * A MODIFIER
 * 
 */
public class BilleMvtPesanteurFrottementRebond extends Bille {
        Vecteur pesanteur;

        public BilleMvtPesanteurFrottementRebond(Vecteur position, double rayon, Vecteur vitesse, Vecteur pesanteur,
                        Color couleur) {
                super(position, rayon, vitesse, couleur);
                this.pesanteur = pesanteur;
        }

        /*
         * (non-Javadoc)
         * 
         * @see decorateur_angryballs.modele.Bille#gestionAcc�l�ration(java.util.Vector)
         */
        @Override
        public void gestionAcceleration(Vector<Bille> billes) {
                super.gestionAcceleration(billes); // remise � z�ro du vecteur acc�l�ration
                this.getAcceleration().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
                this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution
                                                                                                                   // de
                                                                                                                   // l'acc�l�ration
                                                                                                                   // due
                                                                                                                   // au
                                                                                                                   // frottement
                                                                                                                   // dans
                                                                                                                   // l'air
        }

        @Override
        public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
                        double hauteur) {
                Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(),
                                abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
        }

}
