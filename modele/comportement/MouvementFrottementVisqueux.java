package angry_balls.modele.comportement;

import java.util.Vector;

import angry_balls.modele.*;
import angry_balls.mesmaths.mecanique.MecaniquePoint;

public class MouvementFrottementVisqueux extends ComportementAcceleration{

    public MouvementFrottementVisqueux(Bille bille){
        super(bille);  
    }

    public void gestionAcceleration(Vector<Bille> billes){

        Bille billeCourrante = this.getBilleCourante();

        billeCourrante.getAcceleration().ajoute(
            MecaniquePoint.freinageFrottement(billeCourrante.masse(), billeCourrante.getVitesse()));
    }

}