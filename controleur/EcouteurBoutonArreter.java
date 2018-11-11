package angry_balls.controleur;

import angry_balls.modele.AnimationBilles;

public class EcouteurBoutonArreter implements Observeur {

    private AnimationBilles animationBilles;

    public EcouteurBoutonArreter(AnimationBilles animationBilles) {
        this.animationBilles = animationBilles;
    }

    public void update(Observable o, Object arg) {
        animationBilles.arreterAnimation();
    }

}
