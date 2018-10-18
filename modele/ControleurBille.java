package angry_balls.modele;

public abstract class ControleurBille{

    private BillePrehensible bille;
    private ControleurBille suivant;
    private ControleurBille precedent;

    public ControleurBille(BillePrehensible bille, ControleurBille precedant, ControleurBille suivant){
        this.suivant = suivant;
        this.precedent = precedant;
        this.bille = bille;
    }

    public abstract void actionDetectee();

    public abstract void traite();

    public abstract void etatSuivant();

    public abstract void etatPrecedant();

}