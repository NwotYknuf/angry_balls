package angry_balls.controleur;

import angry_balls.vues.CadreAngryBalls;

public class EtatAppAWT extends EtatApp{

    private CadreAngryBalls cadre;

    public EtatAppAWT(CadreAngryBalls c){
        cadre = c;
        
        cadre.arreterBilles.addActionListener(
            new EcouteurBoutonArreter(this)
        );

        cadre.lancerBilles.addActionListener(
            new EcouteurBoutonLancer(this)
        );

        cadre.addWindowListener(
            new EcouteurTerminaison(this)
        );
    }

}