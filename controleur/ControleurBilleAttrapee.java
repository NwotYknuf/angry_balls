package angry_balls.controleur;

import angry_balls.mesmaths.geometrie.base.Vecteur;

public class ControleurBilleAttrapee extends ControleurState {

    public ControleurBilleAttrapee(App app){
        super(app);
    }

    public ControleurBilleAttrapee(App app, ControleurState s, ControleurState p){
        super(app, s, p);  
    }

    public void actionDetectee(Vecteur pos) {
        //On a relaché le clic gauche, on supprime le comportement piloté et on change le controleur
    }

    public void traite() {
        //Envoyer au comportement de la bille un vecteur celon le mouvement de la sourie
    }

    public void surChangement(){
        //ajouter le comportement à la bille
    }

}