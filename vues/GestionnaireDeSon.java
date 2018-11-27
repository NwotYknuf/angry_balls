package angry_balls.vues;

import angry_balls.controleur.*;

public class GestionnaireDeSon implements Observeur{

    public GestionnaireDeSon(){

    }

    public void update(Observable o, Object arg){
        InfoCollision param_choc = (InfoCollision)(arg);

        System.out.println(param_choc);
    }

}