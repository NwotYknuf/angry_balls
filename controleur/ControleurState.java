package angry_balls.controleur;

public abstract class ControleurState{

    App app;
    private ControleurState suivant;
    private ControleurState precedent;

    public ControleurState(App app, ControleurState precedent, ControleurState suivant){
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