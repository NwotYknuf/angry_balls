package angry_balls.controleur.evenements;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import angry_balls.mesmaths.geometrie.base.Vecteur;
import angry_balls.vues.Billard;

public class DetecteClicGaucheEnfonceAWT extends DetectePosition{

    private class EventBoutonPresse implements MouseListener{
        
        private DetecteClicGaucheEnfonceAWT detecteBoutton;

        public EventBoutonPresse(DetecteClicGaucheEnfonceAWT detecteBoutton){
            this.detecteBoutton = detecteBoutton;
        }

        public void mouseExited(MouseEvent e){
            //Rien
        }

        public void mouseReleased(MouseEvent e){
            //Rien
        }

        public void mouseDragged(MouseEvent e){
            //Rien
        }

        public void mouseClicked(MouseEvent e){
            //Rien
        }

        public void mousePressed(MouseEvent e){
            Vecteur pos = new Vecteur(e.getPoint().x, e.getPoint().y);
            detecteBoutton.evenementA_LaPosition(pos);
        }

        public void mouseEntered(MouseEvent e){
            //Rien
        }

        public void mouseMoved(MouseEvent e){
            //Rien
        }

    }

    public DetecteClicGaucheEnfonceAWT(Billard billard){
        billard.addMouseListener(
            new EventBoutonPresse(this));
    }

}