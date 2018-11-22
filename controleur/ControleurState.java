package angry_balls.controleur;

import angry_balls.mesmaths.geometrie.base.Vecteur;

public abstract class ControleurState{

    App app;
    private ControleurState suivant;
    private ControleurState precedent;

    public ControleurState(App app){
        this.app = app;
    }

    public ControleurState(App app, ControleurState s, ControleurState p){
        this.app = app;
        suivant = s;
        precedent = p;
    }

    public void setSuivant(ControleurState c){
        suivant = c;
    }

    public void setPrecedent(ControleurState c){
        precedent = c;
    }

    public abstract void actionDetectee(Vecteur pos);

    public abstract void traite();

    public void etatSuivant(){
        if(suivant != null){
            app.setControleurCourant(suivant);
            suivant.surChangement();
        }
    }

    public void etatPrecedent(){
        if(precedent != null){
            app.setControleurCourant(precedent);
            precedent.surChangement();
        }
    }

    public abstract void surChangement();

}