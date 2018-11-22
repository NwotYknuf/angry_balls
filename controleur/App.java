package angry_balls.controleur;

import angry_balls.modele.*;
import angry_balls.controleur.evenements.*;
import java.util.Vector;

public abstract class App{

    private ControleurState controleurCourant;
    private ControleurBilleAttrapee ctrBilleAttrapee;
    private ControleurBilleLibre ctrBilleLibre;
    private BilleDynamique billeCourante = null;
    private Vector<Bille> billes;

    protected DetecteEvenement billeAttrapee;
    protected DetecteEvenement billeRelachee;
    protected DetecteEvenement arreter;
    protected DetecteEvenement lancer;
    protected DetecteEvenement fermer;

    public App(Vector<Bille> billes){
        this.billes = billes;

        ctrBilleLibre = new ControleurBilleLibre(this);
        ctrBilleAttrapee = new ControleurBilleAttrapee(this);

        ctrBilleLibre.setSuivant(ctrBilleAttrapee);
        ctrBilleAttrapee.setPrecedent(ctrBilleLibre);

        controleurCourant = ctrBilleLibre;
    }

    public ControleurBilleAttrapee getControleurBilleAttrapee(){
        return ctrBilleAttrapee;
    }

    public ControleurBilleLibre getControleurBilleLibre(){
        return ctrBilleLibre;
    }

    public void setControleurCourant(ControleurState controleur){
        controleurCourant = controleur;
    }

    public Vector<Bille> getBilles(){
        return billes;
    }

    public void setBilleCourante(BilleDynamique bille){
        this.billeCourante = bille;
    }

    public BilleDynamique getBilleCourante(){
        return billeCourante;
    }

    public ControleurState getControleurCourant(){
        return controleurCourant;
    }

}