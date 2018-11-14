package angry_balls.controleur;

import java.awt.Window;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class DetecteFermerFenetreAWT extends DetecteEvenement {

    private class EventWindowClosed implements WindowListener {

        private DetecteEvenement detecteBoutton;

        public EventWindowClosed(DetecteEvenement detecteBoutton) {
            this.detecteBoutton = detecteBoutton;
        }

        @Override
        public void windowActivated(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowClosed(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowClosing(WindowEvent arg0) {
            detecteBoutton.bouttonPresse();
        }

        @Override
        public void windowDeactivated(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowDeiconified(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowIconified(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowOpened(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

    }

    public DetecteFermerFenetreAWT(Window window) {
        window.addWindowListener(new EventWindowClosed(this));
    }

}