package angry_balls.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBoutonArreter implements ActionListener
{
    EtatApp etat;

public EcouteurBoutonArreter(EtatApp etat)
    {
        this.etat = etat;
    }

@Override
public void actionPerformed(ActionEvent e)
{
    this.etat.setArreterPresse();
}

}
