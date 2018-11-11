package angry_balls.controleur;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetecteBouttonAWT extends DetecteBoutton{

    private class EventButtonPressed implements ActionListener{

        private DetecteBoutton detecteBoutton;

        public EventButtonPressed(DetecteBoutton detecteBoutton){
            this.detecteBoutton = detecteBoutton;
        }

        public void actionPerformed(ActionEvent e){
            detecteBoutton.bouttonPresse();
        }

    }

    public DetecteBouttonAWT(Button button){
        button.addActionListener(
            new EventButtonPressed(this) );
    }

}