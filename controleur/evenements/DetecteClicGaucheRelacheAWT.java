package angry_balls.controleur.evenements;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import angry_balls.vues.Billard;

public class DetecteClicGaucheRelacheAWT extends DetecteEvenement{

    private class EventBoutonRelache implements MouseListener{
        
        private DetecteClicGaucheRelacheAWT detecteBoutton;

        public EventBoutonRelache(DetecteClicGaucheRelacheAWT detecteBoutton){
            this.detecteBoutton = detecteBoutton;
        }

        public void mouseExited(MouseEvent e){
            //Rien
        }

        public void mouseReleased(MouseEvent e){
            detecteBoutton.evenementDeclenche();
        }

        public void mouseDragged(MouseEvent e){
            //Rien
        }

        public void mouseClicked(MouseEvent e){
            //Rien
        }

        public void mousePressed(MouseEvent e){
            //Rien
        }

        public void mouseEntered(MouseEvent e){
            //Rien
        }

        public void mouseMoved(MouseEvent e){
            //Rien
        }

    }

    public DetecteClicGaucheRelacheAWT(Billard billard){
        billard.addMouseListener(
            new EventBoutonRelache(this));
    }

}
