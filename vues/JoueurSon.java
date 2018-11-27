package angry_balls.vues;

public abstract class JoueurSon implements Runnable{

    private double intensite;
    private double stereo;

    JoueurSon(double intensite, double stereo){
        this.intensite = intensite;
        this.stereo = stereo;
    }

    @Override
    public void run() {
        jouerSon(intensite, stereo);
    }

    /*
     * intensité : entre 0 et 1 
     * steréo : entre 0 et 1. 0 : son gauche 1 : son à droite
     */
    public abstract void jouerSon(double intensite, double stereo);

}