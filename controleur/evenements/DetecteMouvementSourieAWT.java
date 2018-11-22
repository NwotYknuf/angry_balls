package angry_balls.controleur.evenements;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import angry_balls.mesmaths.geometrie.base.Vecteur;
import angry_balls.vues.Billard;

public class DetecteMouvementSourieAWT extends DetectePosition{

    private class EventSourisBougee implements MouseMotionListener{
        
        private DetecteMouvementSourieAWT detecteMouvement;

        public EventSourisBougee(DetecteMouvementSourieAWT detecteBoutton){
            this.detecteMouvement = detecteBoutton;
        }

        public void mouseExited(MouseEvent e){
            //Rien
        }

        public void mouseReleased(MouseEvent e){
            //Rien
        }

        public void mouseDragged(MouseEvent e){
            Vecteur mouvement = new Vecteur(e.getPoint().x, e.getPoint().y);
            detecteMouvement.evenementA_LaPosition(mouvement);
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

    public DetecteMouvementSourieAWT(Billard billard){
        billard.addMouseMotionListener(
            new EventSourisBougee(this));
            
    }

}