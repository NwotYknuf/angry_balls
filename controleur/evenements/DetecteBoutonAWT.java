package angry_balls.controleur.evenements;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetecteBoutonAWT extends DetecteEvenement{

    private class EventBoutonPresse implements ActionListener{

        private DetecteEvenement detecteBoutton;

        public EventBoutonPresse(DetecteEvenement detecteBoutton){
            this.detecteBoutton = detecteBoutton;
        }

        public void actionPerformed(ActionEvent e){
            detecteBoutton.evenementDeclenche();
        }

    }

    public DetecteBoutonAWT(Button button){
        button.addActionListener(
            new EventBoutonPresse(this) );
    }

}