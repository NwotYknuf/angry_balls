package angry_balls.modele;

import java.awt.*;
import java.util.Vector;

import angry_balls.mesmaths.cinematique.Cinematique;
import angry_balls.mesmaths.cinematique.Collisions;
import angry_balls.mesmaths.geometrie.base.Geop;
import angry_balls.mesmaths.geometrie.base.Vecteur;

/**
 * Cas g�n�ral d'une bille de billard
 * 
 * A MODIFIER
 * 
 * 
 */
public abstract class Bille {
    // ----------------- classe Bille-------------------------------------

    public Vecteur position; // centre de la bille
    public double rayon; // rayon > 0
    public Vecteur vitesse;
    public Vecteur acceleration;
    public int clef; // identifiant unique de cette bille

    private Color couleur;

    private static int prochaineClef = 0;

    public static double ro = 1; // masse volumique

    /**
     * @param centre
     * @param rayon
     * @param vitesse
     * @param         acc�l�ration
     * @param couleur
     */
    protected Bille(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acceleration, Color couleur) {
        this.position = centre;
        this.rayon = rayon;
        this.vitesse = vitesse;
        this.acceleration = acceleration;
        this.couleur = couleur;
        this.clef = Bille.prochaineClef++;
    }

    /**
     * @param position
     * @param rayon
     * @param vitesse
     * @param couleur
     */
    public Bille(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
        this(position, rayon, vitesse, new Vecteur(), couleur);
    }

    /**
     * @return the position
     */
    public Vecteur getPosition() {
        return this.position;
    }

    /**
     * @return the rayon
     */
    public double getRayon() {
        return this.rayon;
    }

    /**
     * @return the vitesse
     */
    public Vecteur getVitesse() {
        return this.vitesse;
    }

    /**
     * @return the acc�l�ration
     */
    public Vecteur getAcceleration() {
        return this.acceleration;
    }

    /**
     * @return the clef
     */
    public int getClef() {
        return this.clef;
    }

    public double masse() {
        return ro * Geop.volumeSphere(rayon);
    }

    /**
     * mise � jour de position et vitesse � t+deltaT � partir de position et vitesse
     * � l'instant t
     * 
     * modifie le vecteur position et le vecteur vitesse
     * 
     * laisse le vecteur acc�l�ration intact
     *
     * La bille subit par d�faut un mouvement uniform�ment acc�l�r�
     */
    public void deplacer(double deltaT) {
        Cinematique.mouvementUniformementAccelere(this.getPosition(), this.getVitesse(), this.getAcceleration(),
                deltaT);
    }

    /**
     * calcul (c-�-d mise � jour) �ventuel du vecteur acc�l�ration. billes est la
     * liste de toutes les billes en mouvement Cette m�thode peut avoir besoin de
     * "billes" si this subit l'attraction gravitationnelle des autres billes La
     * nature du calcul du vecteur acc�l�ration de la bille est d�finie dans les
     * classes d�riv�es A ce niveau le vecteur acc�l�ration est mis � z�ro (c'est �
     * dire pas d'acc�l�ration)
     */
    public void gestionAcceleration(Vector<Bille> billes) {
        this.getAcceleration().set(Vecteur.VECTEURNUL);
    }

    /**
     * gestion de l'�ventuelle collision de cette bille avec les autres billes
     *
     * billes est la liste de toutes les billes en mouvement
     * 
     * Le comportement par d�faut est le choc parfaitement �lastique (c-�-d rebond
     * sans amortissement)
     * 
     * @return true si il y a collision et dans ce cas les positions et vecteurs
     *         vitesses des 2 billes impliqu�es dans le choc sont modifi�es si
     *         renvoie false, il n'y a pas de collision et les billes sont laiss�es
     *         intactes
     */
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return OutilsBille.gestionCollisionBilleBille(this, billes);
    }

    /**
     * gestion de l'�ventuelle collision de la bille (this) avec le contour
     * rectangulaire de l'�cran d�fini par (abscisseCoinHautGauche,
     * ordonn�eCoinHautGauche, largeur, hauteur)
     * 
     * d�tecte si il y a collision et le cas �ch�ant met � jour position et vitesse
     * 
     * La nature du comportement de la bille en r�ponse � cette collision est
     * d�finie dans les classes d�riv�es
     */
    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
            double hauteur);

    public void dessine(Graphics g) {
        int width, height;
        int xMin, yMin;

        xMin = (int) Math.round(position.x - rayon);
        yMin = (int) Math.round(position.y - rayon);

        width = height = 2 * (int) Math.round(rayon);

        g.setColor(couleur);
        g.fillOval(xMin, yMin, width, height);
        g.setColor(Color.CYAN);
        g.drawOval(xMin, yMin, width, height);
    }

    public String toString() {
        return "centre = " + position + " rayon = " + rayon + " vitesse = " + vitesse + " acc�l�ration = "
                + acceleration + " couleur = " + couleur + "clef = " + clef;
    }

    // ----------------- classe Bille -------------------------------------
}
