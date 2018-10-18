package angry_balls.modele;

public abstract class ComportementCollision{

    private Bille billeCourante;

    ComportementCollision(Bille billeCourante){
        this.billeCourante = billeCourante;
    }

    public Bille getBilleCourante(){
        return billeCourante;
    }

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,double hauteur);

}