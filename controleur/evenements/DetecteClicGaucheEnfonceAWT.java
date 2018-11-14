package angry_balls.controleur.evenements;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import angry_balls.mesmaths.geometrie.base.Vecteur;
import angry_balls.vues.Billard;

public class DetecteClicGaucheEnfonceAWT extends DetecteEvenement{

    private class EventBoutonPresse implements MouseInputListener{
        
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
            detecteBoutton.bouttonPresse(pos);
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

    public void bouttonPresse(Vecteur pos){
        this.setChange();
        this.notifierObserveurs(pos);
    }

}