package angry_balls.controleur.ecouteurs;
import angry_balls.controleur.*;

public class EcouteurFermer implements Observeur {

    public EcouteurFermer() {
    }

    public void update(Observable o, Object arg) {
        System.exit(0);
    }

}
