package angry_balls.vues;

public class InfoCollision{

    public double intensite;
    public double pos_x;
    public String type;

    public InfoCollision(String type, double intensite, double pos_x){
        this.intensite = intensite;
        this.pos_x = pos_x;
        this.type = type;
    }

    @Override
    public String toString(){
        return "Choc : Type : " + type + " Intensité : " + intensite + " Pos_x : " + pos_x;
    }

}