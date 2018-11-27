package angry_balls.vues;

import java.util.HashMap;
import java.io.*;

public class GestionnaireDeSonJavax extends GestionnaireDeSon{

    private HashMap<String, File> sons;

    public GestionnaireDeSonJavax(VueBillard billard){
        super(billard);

        sons = new HashMap<String,File>();

        ClassLoader classLoader = getClass().getClassLoader();
        File billeBille = new File(classLoader.getResource("./billebille.wav").getPath());
        File billeMur = new File(classLoader.getResource("./billemur.wav").getPath());

        sons.put("BilleBille", billeBille);
        sons.put("BilleMur", billeMur);
    }

    @Override
    public void lanceLeSon(InfoCollision info){
        JoueurSonJavax joueur = new JoueurSonJavax(sons.get(info.type), info.intensite, info.pos_x);
        Thread thread = new Thread(joueur);
        thread.start();
    }

}