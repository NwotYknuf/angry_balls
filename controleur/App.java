package angry_balls.controleur;

import angry_balls.modele.*;
import angry_balls.vues.GestionnaireDeSon;
import angry_balls.controleur.evenements.*;
import java.util.Vector;
import angry_balls.mesmaths.geometrie.base.Vecteur;

public abstract class App{

    private ControleurState controleurCourant;
    private BilleDynamique billeCourante = null;
    private Vecteur positionBilleAttrapee;
    private Vector<Bille> billes;
    private GestionnaireDeSon gestionnaireDeSon;

    protected ControleurBilleAttrapee ctrBilleAttrapee;
    protected ControleurBilleLibre ctrBilleLibre;
    protected DetectePosition billeAttrapee;
    protected DetecteEvenement billeRelachee;
    protected DetecteEvenement arreter;
    protected DetecteEvenement lancer;
    protected DetecteEvenement fermer;

    public App(Vector<Bille> billes, AnimationBilles anim){
        this.billes = billes;
        gestionnaireDeSon = new GestionnaireDeSon();
        anim.ajouterObserveur(gestionnaireDeSon);
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

    public void arreter(){
        System.exit(0);
    }

    public void setPositionBilleAttrapee(Vecteur pos){
        positionBilleAttrapee = pos;
    }

    public Vecteur getPositionBilleAttrapee(){
        return positionBilleAttrapee;  
    }

}