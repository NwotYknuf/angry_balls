package angry_balls.modele.comportement;

import angry_balls.mesmaths.geometrie.base.Vecteur;
import angry_balls.modele.*;
import java.util.Vector;

public abstract class MouvementPilote extends ComportementAcceleration{

    private Vecteur acceleration;

    public MouvementPilote(Bille billeCourante){
        super(billeCourante);
        acceleration = new Vecteur(0,0);
    }

    public void gestionAcceleration(Vector<Bille> billes){
        this.getBilleCourante().getAcceleration().ajoute(acceleration);
    }

    public void setAcceleration(Vecteur v){
        acceleration = v;
    }
}