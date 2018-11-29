package angry_balls.vues;

import java.util.HashMap;
import java.io.*;

public class GestionnaireDeSonJavax extends GestionnaireDeSon{

    private HashMap<String, String> sons;

    public GestionnaireDeSonJavax(VueBillard billard){
        super(billard);

        sons = new HashMap<String,String>();

        sons.put("BilleBille", "billeBille.wav");
        sons.put("BilleMur", "billeMur.wav");
    }

    @Override
    public void lanceLeSon(InfoCollision info){
        JoueurSonJavax joueur = new JoueurSonJavax(sons.get(info.type), info.intensite, info.pos_x);
        Thread thread = new Thread(joueur);
        thread.start();
    }

}