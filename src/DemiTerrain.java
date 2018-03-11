import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui contenir les zones du terrain d'un joueur.
 * Les zones sont :
 * -l'avant
 * -l'arrière
 * -la break zone
 * -la damage zone
 * @author Wangon Romain "NekoRomain"
 */

public class DemiTerrain
{
    BreakZone breakZone;
    DamageZone damageZone;
    ZoneTerrainArriere zoneArriere;
    ZoneTerrainAvant zoneAvant;
    ImageView imageTerrain;
    Joueur owner;
    List<ImageView> mainView;


    //TODO enlever le constructeur debug Terrain
    //constructeur débug
    public DemiTerrain(Group root)
    {
        owner = null;
        breakZone = new BreakZone();
        damageZone = new DamageZone();
        zoneArriere = new ZoneTerrainArriere(root);
        zoneAvant = new ZoneTerrainAvant(root);
        initialisation(root);
    }
    /**
     * Constructeur : Va créer les zones et va associé un joueur au terrain
     * @param player joueur à qui appartient ce terrain
     */
    public DemiTerrain(Group root, Joueur player)
    {

        owner = player;
        breakZone = new BreakZone();
        damageZone = new DamageZone();
        zoneArriere = new ZoneTerrainArriere(root);
        zoneAvant = new ZoneTerrainAvant(root);
        mainView = new ArrayList<ImageView>();
        initialisation(root);
    }

    /**
     * Méthode privé d'initalisation de l'imageView
     * @param root group de la fenêtre de jeu
     */
    private void initialisation(Group root)
    {
        mainView = new ArrayList<ImageView>();
        imageTerrain = new ImageView(new Image("terrain.jpg"));
        root.getChildren().add(imageTerrain);
    }

    public void addCarteMainView(Carte c)
    {

    }

}
