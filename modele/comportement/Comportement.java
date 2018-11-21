package angry_balls.modele.comportement;

public abstract class Comportement{

    private String nom;

    public Comportement(){
        nom = "Pas de nom";
    }

    public Comportement(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return nom;
    }

    public boolean equals(Object o){

        if(this == o){
            return true;
        }

        if( !(o instanceof ComportementAcceleration)){
            return false;
        }

        Comportement c = (Comportement)o;

        return c.nom.equals(this.nom);

    }

}