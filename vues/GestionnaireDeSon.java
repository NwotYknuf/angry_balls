package angry_balls.vues;

import angry_balls.controleur.*;

public abstract class GestionnaireDeSon implements Observeur{

    private final double ATTENUEMENT = 1.3;
    
    private VueBillard billard;

    public GestionnaireDeSon(VueBillard billard){
        this.billard = billard;
    }

    public void update(Observable o, Object arg){
        InfoCollision param_choc = (InfoCollision)(arg);

        //on convertit les données récupérés pour convenir au joueur de son
        param_choc.intensite = Math.tanh(param_choc.intensite * ATTENUEMENT); //retourne une valeur entre 0 et 1 
        param_choc.pos_x = param_choc.pos_x / billard.largeurBillard();// On normalise
        if(param_choc.pos_x < 0){
            param_choc.pos_x = 0;
        }
        if(param_choc.pos_x > 1){
            param_choc.pos_x = 1;
        }
        lanceLeSon(param_choc);
    }

    public abstract void lanceLeSon(InfoCollision info);

}