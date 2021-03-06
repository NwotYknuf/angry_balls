package angry_balls.controleur;

import java.util.Vector;;

public class Observable{

    protected Vector<Observeur> observers;
    private boolean aChange;

    public Observable(){
        observers = new Vector<Observeur>();
        aChange = false;
    }

    protected void setChange(){
        aChange = true;
        
    }

    protected void resetChange(){
        aChange = false;
    }

    public boolean aChange(){
        return aChange;
    }

    public void ajouterObserveur(Observeur o){
        observers.add(o);
    }

    public void notifierObserveurs(Object o){
        for (Observeur obs : observers) {
            obs.update(this, o);
        }
        resetChange();
    }

    public void notifierObserveurs(){
        notifierObserveurs(null);
        resetChange();
    }

}