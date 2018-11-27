package angry_balls.vues;

import angry_balls.controleur.*;

public class GestionnaireDeSon implements Observeur{

    public GestionnaireDeSon(){

    }

    public void update(Observable o, Object arg){
        double[] param_choc = (double[])(arg);

        System.out.println("Choc : " + param_choc[0] + ", " + param_choc[1]);
    }

}