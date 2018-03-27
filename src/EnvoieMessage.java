import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.util.Duration;

import java.io.IOException;

public abstract class EnvoieMessage
{

    public static void envoieMessage(String str)
    {
        Jeu.out.println(str);
    }
    public static void envoyeMessagePioche(Group root, Carte cartes[], DemiTerrain demiTerrain, boolean adversaire)
    {
        envoieMessage("Carte");
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
}
