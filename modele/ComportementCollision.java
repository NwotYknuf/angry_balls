package angry_balls.modele;

public abstract class ComportementCollision{

    private Bille billeCourrante;

    ComportementCollision(Bille billeCourante){
        this.billeCourrante = billeCourrante;
    }

    public Bille getBilleCourrante(){
        return billeCourrante;
    }

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,double hauteur);

}