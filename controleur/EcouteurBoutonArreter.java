package angry_balls.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import angry_balls.modele.AnimationBilles;

/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class EcouteurBoutonArreter implements ActionListener
{
AnimationBilles animationBilles;

public EcouteurBoutonArreter(AnimationBilles animationBilles)
    {
    this.animationBilles = animationBilles;
    }

@Override
public void actionPerformed(ActionEvent e)
{
this.animationBilles.arreterAnimation();
}

}
