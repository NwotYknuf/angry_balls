package angry_balls.controleur;

import angry_balls.mesmaths.geometrie.base.Vecteur;

public abstract class EtatApp extends Observable{

    private boolean lancerPresse = false;
    private boolean arreterPresse = false;
    private boolean fermerFenetre = false;
    private Vecteur posCliquee = null;

    public EtatApp(){

    }

    public void setLancerPresse() {
        lancerPresse = true;
        this.setChange();
        this.notifierObserveurs(this);
        lancerPresse = false;
    }

    public void setArreterPresse(){
        arreterPresse = true;
        this.setChange();
        this.notifierObserveurs(this);
        arreterPresse = false;
    }

    public void setFermerFenetre(){
        fermerFenetre = true;
        this.setChange();
        this.notifierObserveurs(this);
        fermerFenetre = false;
    }

    public void setPosCliquee(Vecteur v){
        posCliquee = v;
        this.setChange();
        this.notifierObserveurs(this);
        posCliquee = null;
    }

    public boolean getLancerPresse(){
        return lancerPresse;
    }

    public boolean getArreterPresse(){
        return arreterPresse;
    }

    public boolean getFermerFenetre(){
        return fermerFenetre;
    }

    public Vecteur getPosCliquee(){
        return posCliquee;
    }


}