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
    public static void traitementMessage(Group root, Terrain terrain)
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
                            String [] resultat = strCourant.split(":");
                            if(resultat[0].equals("Jouer"))
                            {
                                int i = Integer.parseInt(resultat[1]);
                                try
                                {
                                    Carte c = (Carte)Jeu.inFromClient.readObject();
                                    Platform.runLater(()->
                                    {
                                        carteJouerAvant(c, i, terrain.getDemiTerrainAdversaire());
                                    });
                                }
                                catch (ClassNotFoundException ex)
                                {
                                    ex.printStackTrace();
                                }

                            }
                            if(resultat[0].equals("Carte"))
                            {
                                try
                                {
                                    Carte[] c = (Carte[])Jeu.inFromClient.readObject();
                                    Platform.runLater(()->
                                    {
                                        addC(root, c, terrain.getDemiTerrainAdversaire());
                                    });
                                }
                                catch (ClassNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
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


    private static void addC(Group root, Carte[] c, DemiTerrain terrainAdversaire)
    {
        Joueur ad = terrainAdversaire.getOwner();
        for(Carte cc : c)
        {
            CarteViewJoueur cv = new CarteViewJoueur(root, terrainAdversaire, cc, 157 + terrainAdversaire.getMainView().size()* 86,18, true);
            terrainAdversaire.getMainView().add(cv);
        }


    }

    private static void carteJouerAvant(Carte c, int i, DemiTerrain terrainAdversaire)
    {
        if(c instanceof Avant)
        {
            Avant cAvant = (Avant)c;
            terrainAdversaire.getOwner().getTerrain_avant().add(cAvant);
            terrainAdversaire.getZoneAvant().getTerrainAvant()[i].getEmplacement().setImage(c.getImage());
            terrainAdversaire.getZoneAvant().getTerrainAvant()[i].setCarte(c);
        }
    }

}
