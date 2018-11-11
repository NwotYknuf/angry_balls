package angry_balls.controleur;

import angry_balls.modele.AnimationBilles;

public class EcouteurBoutonLancer implements Observeur {
    private AnimationBilles animationBilles;

    public EcouteurBoutonLancer(AnimationBilles animationBilles) {
        this.animationBilles = animationBilles;
    }

    public void update(Observable o, Object arg) {
        animationBilles.lancerAnimation();
    }
}
