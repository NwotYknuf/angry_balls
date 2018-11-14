package angry_balls.controleur;

import angry_balls.mesmaths.geometrie.base.Vecteur;
import angry_balls.modele.Bille;

public class ControleurBilleLibre extends ControleurState {

    private DetecteEvenement cliqueGauche;

    public ControleurBilleLibre(App app){
        super(app);
    }

    public ControleurBilleLibre(App app, ControleurState s, ControleurState p){
        super(app, s, p);  
    }

    public void actionDetectee(Vecteur pos) {

        if(this != app.getControleurCourant()){
            return;
        }

        System.out.println("Click en : " + pos.toString());
        //On regarde si on a cliqué sur une bille

        for(Bille b : app.getBilles()){
            Vecteur posBille = new Vecteur(b.getPosition());
            posBille.retire(pos);

            if(posBille.norme() < b.getRayon()){
                //On a cliqué sur la bille
                System.out.println("Bille attrapée !");
                app.setBilleCourante(b);
                this.etatSuivant();
                break;
            }
        }
        
        //On passe dans l'état suivant et on ajoute un comportement à la bille concernée
    }

    public void traite() {
        //Rien de spéciale à faire ici, on observe juste les billes
    }

}