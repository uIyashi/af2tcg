package univ.projet.main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.io.IOException;

public abstract class EnvoieMessage
{

    public static void envoieMessage(String str)
    {
        Jeu.out.println(str);
    }
    public static void envoyeMessagePioche(Carte cartes[])
    {
        envoieMessage("univ.projet.main.Carte");
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(300),
                ae -> {
                    try
                    {
                        Jeu.outToClient.writeObject(cartes);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }));
        timeline.play();

    }

    public static void carteJouerAvant(Carte c, int i)
    {
        envoieMessage("Jouer:" + i);
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(300),
                ae -> {
                    try
                    {
                        Jeu.outToClient.writeObject(c);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }));
        timeline.play();
    }
}
