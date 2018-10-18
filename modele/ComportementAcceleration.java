package angry_balls.modele;

import java.util.Vector;

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