package angry_balls.controleur;

public abstract class ControleurState{

    App app;
    private ControleurState suivant;
    private ControleurState precedent;

    public ControleurState(App app){
        this.app = app;
    }

    public void setSuivant(ControleurState c){
        suivant = c;
    }

    public void setPrecedent(ControleurState c){
        precedent = c;
    }

    public abstract void actionDetectee();

    public abstract void traite();

    public void etatSuivant(){
        if(suivant != null){
            app.setControleurCourant(suivant);
        }
    }

    public void etatPrecedent(){
        if(precedent != null){
            app.setControleurCourant(precedent);
        }
    }

}