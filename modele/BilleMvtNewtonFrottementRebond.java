package angry_balls.modele;

import java.awt.Color;
import java.util.Vector;

import angry_balls.mesmaths.cinematique.Collisions;
import angry_balls.mesmaths.geometrie.base.Vecteur;
import angry_balls.mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille rebondissant sur les bords, subissant le frottement dans l'air et subissant l'attraction des autres billes
 * 
 * 
 *  A MODIFIER
 *  
 *  */
public class BilleMvtNewtonFrottementRebond extends Bille
{

public BilleMvtNewtonFrottementRebond(Vecteur centre, double rayon,
        Vecteur vitesse, Color couleur)
{
super(centre, rayon, vitesse, couleur);
}




/* (non-Javadoc)
 * @see decorateur_angryballs.modele.Bille#gestionAcc�l�ration(java.util.Vector)
 */
@Override
public void gestionAcceleration(Vector<Bille> billes)
{
super.gestionAcceleration(billes);                              // remise � z�ro du vecteur acc�l�ration
this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes));     // contribution de l'acc�l�ration due � l'attraction des autres billes
this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'acc�l�ration due au frottement dans l'air
}




@Override
public void collisionContour(double abscisseCoinHautGauche,
        double ordonneeCoinHautGauche, double largeur, double hauteur)
{
Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);

}

}
