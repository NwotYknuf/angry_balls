package angry_balls.modele.comportement;

import java.util.Vector;
import angry_balls.modele.*;

public abstract class ComportementAcceleration{

    private Bille billeCourante;

    ComportementAcceleration(Bille billeCourante){
        this.billeCourante = billeCourante;
    }

    public Bille getBilleCourante(){
        return billeCourante;
    }

    public abstract void gestionAcceleration(Vector<Bille> billes);

}