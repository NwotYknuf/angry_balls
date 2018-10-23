package angry_balls.modele.comportement;

import java.util.Vector;

import angry_balls.modele.*;
import angry_balls.mesmaths.geometrie.base.Vecteur;

public class MouvementRectiligne extends ComportementAcceleration{

    public MouvementRectiligne(Bille bille){
        super(bille);  
    }

    public void gestionAcceleration(Vector<Bille> billes){
        this.getBilleCourante().getAcceleration().set(Vecteur.VECTEURNUL);
    }

}