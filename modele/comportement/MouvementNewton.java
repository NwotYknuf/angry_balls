package angry_balls.modele.comportement;

import java.util.Vector;

import angry_balls.modele.*;
import angry_balls.modele.OutilsBille;

public class MouvementNewton extends ComportementAcceleration{

    public MouvementNewton(Bille bille){
        super(bille);  
    }

    public void gestionAcceleration(Vector<Bille> billes){
        this.getBilleCourante().getAcceleration().ajoute(
            OutilsBille.gestionAccelerationNewton(this.getBilleCourante(), billes));
    }

}