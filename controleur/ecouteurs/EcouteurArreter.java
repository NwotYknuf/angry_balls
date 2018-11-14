package angry_balls.controleur.ecouteurs;
import angry_balls.controleur.*;

import angry_balls.modele.AnimationBilles;

public class EcouteurArreter implements Observeur {

    private AnimationBilles animationBilles;

    public EcouteurArreter(AnimationBilles animationBilles) {
        this.animationBilles = animationBilles;
    }

    public void update(Observable o, Object arg) {
        animationBilles.arreterAnimation();
    }

}
