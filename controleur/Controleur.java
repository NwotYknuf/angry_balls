package angry_balls.controleur;

public abstract class Controleur{

    App app;
    private Controleur suivant;
    private Controleur precedent;

    public Controleur(App app, Controleur precedent, Controleur suivant){
        this.suivant = suivant;
        this.precedent = precedent;
        this.app = app;
    }

    public abstract void actionDetectee();

    public abstract void traite();

    public void etatSuivant(){
        app.setControleurCourant(suivant);
    }

    public void etatPrecedent(){
        app.setControleurCourant(precedent);
    }

}