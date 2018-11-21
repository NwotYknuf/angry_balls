package angry_balls.controleur;

import java.awt.Component;

import angry_balls.mesmaths.geometrie.base.Vecteur;

import angry_balls.modele.comportement.*;

public class ControleurBilleAttrapee extends ControleurState {

    private MouvementPilote comportement;
    //Ecoute une accelaration
    //Ecoute relachement souris

    public ControleurBilleAttrapee(App app){
        super(app);
    }

    public ControleurBilleAttrapee(App app, ControleurState s, ControleurState p){
        super(app, s, p);  
    }

    public void actionDetectee(Vecteur pos) {
        //On a relaché le clic gauche, on supprime le comportement piloté et on change le controleur
        app.getBilleCourante().supprimerComportementAcceleration(comportement);
        this.etatPrecedent();
    }

    public void traite() {
        //Envoyer au comportement de la bille un vecteur celon le mouvement de la sourie

        comportement.setAcceleration(new Vecteur(2,2));

    }

    public void surChangement(){
        comportement = new MouvementPilote(app.getBilleCourante(), "Bille attrapée");
        app.getBilleCourante().ajouterComportementAcceleration(comportement);
        //ajouter le comportement à la bille
    }

}