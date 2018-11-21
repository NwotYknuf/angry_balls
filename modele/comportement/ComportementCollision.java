package angry_balls.modele.comportement;

import angry_balls.modele.*;
public abstract class ComportementCollision extends Comportement{

    private Bille billeCourante;

    public ComportementCollision(Bille billeCourante){
        this.billeCourante = billeCourante;
    }

    public ComportementCollision(Bille billeCourrante, String nom){
        super(nom);
        this.billeCourante = billeCourrante;
    }

    public Bille getBilleCourante(){
        return billeCourante;
    }

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,double hauteur);

}