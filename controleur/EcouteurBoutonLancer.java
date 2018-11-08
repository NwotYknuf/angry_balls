package angry_balls.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import angry_balls.modele.AnimationBilles;

/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */
public class EcouteurBoutonLancer implements ActionListener
{
EtatApp etat;



/**
 * @param animationsBilles
 */
public EcouteurBoutonLancer(EtatApp etat)
{
this.etat = etat;
}



@Override
public void actionPerformed(ActionEvent arg0)
{
this.etat.setLancerPresse();
}

}
