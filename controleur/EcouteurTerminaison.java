package angry_balls.controleur;

public class EcouteurTerminaison implements Observeur {

    public EcouteurTerminaison() {
    }

    public void update(Observable o, Object arg) {
        System.exit(0);
    }

}
