package angry_balls.modele.comportement;

import java.util.Vector;
import angry_balls.modele.*;

public abstract class ComportementAcceleration extends Comportement{

    private Bille billeCourante;

    public ComportementAcceleration(Bille billeCourante){
        this.billeCourante = billeCourante;
    }

    public ComportementAcceleration(Bille billeCourrante, String nom){
        super(nom);
        this.billeCourante = billeCourrante;
    }
    
    public Bille getBilleCourante(){
        return billeCourante;
    }

    public abstract void gestionAcceleration(Vector<Bille> billes);

}