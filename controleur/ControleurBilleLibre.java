package angry_balls.controleur;

import angry_balls.mesmaths.geometrie.base.Vecteur;

public class ControleurBilleLibre extends ControleurState {

    private DetecteBoutton cliqueGauche;

    public ControleurBilleLibre(App app){
        super(app);
    }

    public ControleurBilleLibre(App app, ControleurState s, ControleurState p){
        super(app, s, p);  
    }

    public void actionDetectee(Vecteur pos) {

        System.out.println("Click en : " + pos.toString());
        //On regarde si on a cliqué sur une bille

        //On passe dans l'état suivant et on ajoute un comportement à la bille concernée
    }

    public void traite() {
        //Rien de spéciale à faire ici, on observe juste les billes
    }

}