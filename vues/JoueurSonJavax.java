package angry_balls.vues;

import java.io.*;
import javax.sound.sampled.*;

public class JoueurSonJavax extends JoueurSon{

    private String file;

    public JoueurSonJavax(String file, double intensite, double stereo){
        super(intensite, stereo);
        this.file = file;
    }

    public void jouerSon(double intensite, double stereo){

        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource(file));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            FloatControl pan = (FloatControl)(clip.getControl(FloatControl.Type.PAN));
            FloatControl gain = (FloatControl)(clip.getControl(FloatControl.Type.MASTER_GAIN));

            float min_pan = pan.getMinimum();
            float max_pan = pan.getMaximum();
            float max_gain = gain.getMaximum();
            float min_gain = gain.getMinimum();

            pan.setValue(min_pan + (max_pan - min_pan)*((float)stereo));
            gain.setValue(min_gain + (max_gain - min_gain)*((float)intensite));
            clip.start();
         } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } catch (LineUnavailableException e) {
            e.printStackTrace();
         }
    }

}