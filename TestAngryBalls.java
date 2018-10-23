package angry_balls;

import java.awt.Color;
import java.util.Vector;

import angry_balls.mesmaths.geometrie.base.Vecteur;

import angry_balls.modele.Bille;
import angry_balls.modele.BilleDynamique;
import angry_balls.modele.comportement.*;
import angry_balls.modele.maladroit.*;
import angry_balls.vues.CadreAngryBalls;
import angry_balls.vues.VueBillard;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement
 * different
 * 
 * Ideal pour mettre en place le DP decorator
 */
public class TestAngryBalls {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // ------------------- creation de la liste (pour l'instant vide) des billes
        // -----------------------

        Vector<Bille> billes = new Vector<Bille>();

        // ---------------- creation de la vue responsable du dessin des billes
        // -------------------------

        CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                "Animation de billes ayant des comportements differents. Situation ideale pour mettre en place le DP Decorator",
                billes);

        cadre.montrer(); // on rend visible la vue

        // ------------- remplissage de la liste avec 4 billes
        // -------------------------------

        double xMax, yMax;
        double vMax = 0.1;
        xMax = cadre.largeurBillard(); // abscisse maximal
        yMax = cadre.hauteurBillard(); // ordonnee maximale

        double rayon = 0.05 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le meme rayon, mais
                                                    // ce n'est pas obligatoire

        Vecteur p0, p1, p2, p3, p4, v0, v1, v2, v3, v4; // les positions des centres des billes et les vecteurs vitesse
                                                        // au demarrage.
                                                        // Elles vont etre choisies aleatoirement

        // ------------------- cr�ation des vecteurs position des billes
        // ---------------------------------

        p0 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
        p1 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
        p2 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
        p3 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
        p4 = Vecteur.creationAleatoire(0, 0, xMax, yMax);

        // ------------------- cr�ation des vecteurs vitesse des billes
        // ---------------------------------

        v0 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
        v1 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, 0);
        v2 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
        v3 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
        v4 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);

        // --------------- ici commence la partie � changer
        // ---------------------------------
        /*
        billes.add(new BilleMvtRURebond(p0, rayon, v0, Color.red));
        billes.add(new BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0, 0.001), Color.yellow));
        billes.add(new BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
        billes.add(new BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
        billes.add(new BilleMvtNewtonArret(p4, rayon, v4, Color.black));
        */

        BilleDynamique bille1 = new BilleDynamique(p0, rayon, v0, Color.red);
        bille1.ajouterComportementAcceleration(new MouvementRectiligne(bille1));
        bille1.ajouterComportementCollision(new Rebond(bille1));
       
        BilleDynamique bille2 = new BilleDynamique(p1, rayon, v1, Color.yellow);
        bille2.ajouterComportementAcceleration(new MouvementPesanteur(bille2, new Vecteur(0, 0.001)));
        bille2.ajouterComportementAcceleration(new MouvementFrottementVisqueux(bille2));
        bille2.ajouterComportementCollision(new Rebond(bille2));

        BilleDynamique bille3 = new BilleDynamique(p2, rayon, v2, Color.green);
        bille3.ajouterComportementAcceleration(new MouvementNewton(bille3));
        bille3.ajouterComportementAcceleration(new MouvementFrottementVisqueux(bille3));
        bille3.ajouterComportementCollision(new Rebond(bille3));

        BilleDynamique bille4 = new BilleDynamique(p3, rayon, v3, Color.cyan);
        bille4.ajouterComportementAcceleration(new MouvementRectiligne(bille4));
        bille4.ajouterComportementCollision(new PasseMuraille(bille4));

        BilleDynamique bille5 = new BilleDynamique(p4, rayon, v4, Color.black);
        bille5.ajouterComportementAcceleration(new MouvementNewton(bille5));
        bille5.ajouterComportementCollision(new Bloque(bille5));

        billes.add(bille1);
        billes.add(bille2);
        billes.add(bille3);
        billes.add(bille4);
        billes.add(bille5);

        // ---------------------- ici finit la partie � changer
        // -------------------------------------------------------------

        System.out.println("billes = " + billes);

        // -------------------- cr�ation de l'objet responsable de l'animation (c'est un
        // thread s�par�) -----------------------

        AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

        // ----------------------- mise en place des �couteurs de boutons qui permettent
        // de contr�ler (un peu...) l'application -----------------

        EcouteurBoutonLancer ecouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
        EcouteurBoutonArreter ecouteurBoutonArreter = new EcouteurBoutonArreter(animationBilles);

        // ------------------------- activation des �couteurs des boutons et �a tourne
        // tout seul ------------------------------

        cadre.lancerBilles.addActionListener(ecouteurBoutonLancer); // maladroit : a changer
        cadre.arreterBilles.addActionListener(ecouteurBoutonArreter); // maladroit : a changer

    }

}
