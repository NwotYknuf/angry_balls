package angry_balls.controleur;

import angry_balls.controleur.evenements.DetectePosition;
import angry_balls.mesmaths.geometrie.base.Vecteur;

import angry_balls.modele.comportement.*;

public abstract class ControleurBilleAttrapee extends ControleurState {

    private static final double FORCE_SOURIS = 0.003;

    private MouvementPilote comportement;
    private Vecteur positionPrecedante;

    protected DetectePosition mouvement;


    public ControleurBilleAttrapee(App app){
        super(app);
    }

    public ControleurBilleAttrapee(App app, ControleurState s, ControleurState p){
        super(app, s, p);     
    }

    public void nouvellePositionSouris(Vecteur pos){
        
        Vecteur diff = new Vecteur(pos.x, pos.y);
        diff.retire(positionPrecedante);
        diff.multiplie(FORCE_SOURIS);
        //On envoit la différence au comportement bille piloté
        comportement.setAcceleration(diff);
        //On update l'anciene position
        positionPrecedante = pos;
    }

    public void actionDetectee(Vecteur pos) {

        if(this != app.getControleurCourant()){
            return;
        }

        //On a relaché le clic gauche, on supprime le comportement piloté et on change le controleur
        System.out.println("Bille relachée");
        app.getBilleCourante().supprimerComportementAcceleration(comportement);
        this.etatPrecedent();
    }

    public void traite() {
        //Envoyer au comportement de la bille un vecteur celon le mouvement de la sourie
        comportement.setAcceleration(new Vecteur(20,20));

    }

    public void surChangement(){
        //ajouter le comportement à la bille
        comportement = new MouvementPilote(app.getBilleCourante(), "Bille attrapée");
        app.getBilleCourante().ajouterComportementAcceleration(comportement);
        //récuperer la position du click
        positionPrecedante = app.getPositionBilleAttrapee();       
    }

}