package angry_balls.vues;

import java.util.Vector;

import angry_balls.modele.Bille;


public class TestCadreAngryBallsSeul
{

/**
 * @param args
 */
public static void main(String[] args)
{
Vector<Bille> billes = new Vector<Bille>();
CadreAngryBalls cadre =new CadreAngryBalls("angry balls", "animation de billes marrantes", billes);
cadre.montrer();
}

}