package angry_balls.controleur;

import angry_balls.modele.AnimationBilles;

public class EcouteurLancer implements Observeur {
    private AnimationBilles animationBilles;

    public EcouteurLancer(AnimationBilles animationBilles) {
        this.animationBilles = animationBilles;
    }

    public void update(Observable o, Object arg) {
        animationBilles.lancerAnimation();
    }
}
