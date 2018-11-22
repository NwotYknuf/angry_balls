package angry_balls.controleur.ecouteurs;
import angry_balls.controleur.*;

public class EcouteurFermer implements Observeur {

    private App app;

    public EcouteurFermer(App app) {
        this.app = app;
    }

    public void update(Observable o, Object arg) {
        app.arreter();
    }

}
