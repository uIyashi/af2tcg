/**
 * @author Wangon Romain "NekoRomain"
 */

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite contenant qu'une méthode de traitement des messages
 */
public abstract class TraitementMessage
{

    /**
     * Méthode qui va traiter les messages reçu et faire des actions en conséquences
     */
    public static void traitementMessage(Group root, DemiTerrain demiTerrain)
    {
        new Thread(()->
        {
            List<String> messageRecu = new ArrayList<String>();
            String strCourant = "";
            do
            {
                try
                {
                    if(Jeu.actived && !Jeu.socket.isClosed())
                    {
                        String str = Jeu.in.readLine();
                        if(str != null)
                        {
                            messageRecu.add(str);
                        }
                        if(!messageRecu.isEmpty())
                        {
                            strCourant = messageRecu.get(0);
                            messageRecu.remove(0);
                        }
                        if(!strCourant.equals(""))
                        {
                            System.out.println("Message reçu : " + strCourant);
                            String [] resultat = strCourant.split(":");
                            if(resultat[0].equals("addCarte"))
                            {
                                int x = Integer.parseInt(resultat[1]);
                                int y = Integer.parseInt(resultat[2]);
                                Platform.runLater(()->
                                {
                                    addC(root, x, y, resultat[3]);
                                });
                            }
                        }

                        strCourant = "";
                    }
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }while (!strCourant.equals("END") && Jeu.actived && !Jeu.socket.isClosed()); //tant que l'on a pas END ou alors que l'on a pas fermé la fenête du jeu ou que l'autre joueur ne sais pas déco
            System.err.println("Fin MESSAGE\n");
        }).start();

    }

    private static void addC(Group root, int x, int y, String nom)
    {
        ImageView v = new ImageView(ImageCarte.getImage(nom));
        v.setX(x);
        v.setY( y- 400 -v.getImage().getWidth());
        root.getChildren().add(v);
    }
}
