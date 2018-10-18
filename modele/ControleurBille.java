package angry_balls.modele;

public abstract class ControleurBille{

    private BillePrehensible bille;
    private ControleurBille suivant;
    private ControleurBille precedent;

    public ControleurBille(BillePrehensible bille, ControleurBille precedent, ControleurBille suivant){
        this.suivant = suivant;
        this.precedent = precedent;
        this.bille = bille;
    }

    public abstract void actionDetectee();

    public abstract void traite();

    public abstract void etatSuivant();

    public abstract void etatPrecedent();

}