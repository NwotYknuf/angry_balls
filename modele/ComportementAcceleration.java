package angry_balls.modele;

import java.util.Vector;

public abstract class ComportementAcceleration{

    private Bille billeCourrante;

    ComportementAcceleration(Bille billeCourante){
        this.billeCourrante = billeCourrante;
    }

    public Bille getBilleCourrante(){
        return billeCourrante;
    }

    public abstract void gestionAcceleration(Vector<Bille> billes);

}