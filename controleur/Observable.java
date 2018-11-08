package angry_balls.controleur;

import java.util.Vector;;

public abstract class Observable{

    private Vector<Observeur> observers;
    private boolean aChange;

    public Observable(){
        observers = new Vector<Observeur>();
        aChange = false;
    }

    protected void setChange(){
        aChange = true;
    }

    public void ajouterObserveur(Observeur o){
        observers.add(o);
    }

    public abstract void notifierObserveurs();

    public abstract void notifierObserveurs(Object o);


}