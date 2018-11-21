package angry_balls.modele.comportement;

import java.util.Vector;

import angry_balls.modele.*;
import angry_balls.mesmaths.geometrie.base.Vecteur;

public class MouvementPesanteur extends ComportementAcceleration{

    private Vecteur pesanteur;

    public MouvementPesanteur(Bille bille, Vecteur pesanteur){
        super(bille);
        this.pesanteur = pesanteur;
    }

    public MouvementPesanteur(Bille bille, String nom, Vecteur pesanteur){
        super(bille, nom);
        this.pesanteur = pesanteur;
    }

    public void gestionAcceleration(Vector<Bille> billes){
        this.getBilleCourante().getAcceleration().ajoute(
            this.pesanteur);
    }

}