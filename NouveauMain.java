package angry_balls;

import java.awt.Color;
import java.util.Vector;

import angry_balls.mesmaths.geometrie.base.Vecteur;

import angry_balls.modele.Bille;
import angry_balls.modele.BilleDynamique;
import angry_balls.modele.comportement.*;
import angry_balls.vues.CadreAngryBalls;
import angry_balls.controleur.*;
import angry_balls.modele.AnimationBilles;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement
 * different
 * 
 * Ideal pour mettre en place le DP decorator
 */
public class NouveauMain {

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

        // --------------- cr�ation des billes et leurs comportements 
        // ---------------------------------
        
        // ----- Bille Rouge : Mouvements rectiligne et rebond
        BilleDynamique billeRouge = new BilleDynamique(p0, rayon, v0, Color.red);
        billeRouge.ajouterComportementAcceleration(new MouvementRectiligne(billeRouge));
        billeRouge.ajouterComportementCollision(new Rebond(billeRouge));
       
        // ----- Bille Jaune : Mouvements pesanteur, frottement visqueux et rebond
        BilleDynamique billeJaune = new BilleDynamique(p1, rayon, v1, Color.yellow);
        billeJaune.ajouterComportementAcceleration(new MouvementPesanteur(billeJaune, new Vecteur(0, 0.001)));
        billeJaune.ajouterComportementAcceleration(new MouvementFrottementVisqueux(billeJaune));
        billeJaune.ajouterComportementCollision(new Rebond(billeJaune));

        // ----- Bille Verte : Mouvements de Newton, frottement visqueux et rebond
        BilleDynamique billeVerte = new BilleDynamique(p2, rayon, v2, Color.green);
        billeVerte.ajouterComportementAcceleration(new MouvementNewton(billeVerte));
        billeVerte.ajouterComportementAcceleration(new MouvementFrottementVisqueux(billeVerte));
        billeVerte.ajouterComportementCollision(new Rebond(billeVerte));

        // ----- Bille Bleue : Mouvements rectiligne et passe muraille
        BilleDynamique billeBleue = new BilleDynamique(p3, rayon, v3, Color.cyan);
        billeBleue.ajouterComportementAcceleration(new MouvementRectiligne(billeBleue));
        billeBleue.ajouterComportementCollision(new PasseMuraille(billeBleue));

        // ----- Bille Noire : Mouvements de Newton et blocage
        BilleDynamique billeNoire = new BilleDynamique(p4, rayon, v4, Color.black);
        billeNoire.ajouterComportementAcceleration(new MouvementNewton(billeNoire));
        billeNoire.ajouterComportementCollision(new Bloque(billeNoire));

        billes.add(billeRouge);
        billes.add(billeJaune);
        billes.add(billeVerte);
        billes.add(billeBleue);
        billes.add(billeNoire);

        /*
        billes.add(new BilleMvtRURebond(p0, rayon, v0, Color.red));
        billes.add(new BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0, 0.001), Color.yellow));
        billes.add(new BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
        billes.add(new BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
        billes.add(new BilleMvtNewtonArret(p4, rayon, v4, Color.black));
        */

        System.out.println("billes = " + billes);

        // -------------------- cr�ation de l'objet responsable de l'animation (c'est un
        // thread s�par�) -----------------------

        AnimationBilles animationBilles = new AnimationBilles(billes, cadre);
        App app = new AppAWT(animationBilles, cadre, billes);
    }

}
