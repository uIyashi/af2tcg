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
    private BreakZone breakZone;
    private DamageZone damageZone;
    private ZoneTerrainArriere zoneArriere;
    private ZoneTerrainAvant zoneAvant;
    private ImageView imageTerrain;
    private Joueur owner;
    private List<CarteViewJoueur> mainView;


    //TODO enlever le constructeur debug Terrain
    //constructeur débug
    public DemiTerrain(Group root)
    {
        owner = null;
        breakZone = new BreakZone();
        damageZone = new DamageZone();
        zoneArriere = new ZoneTerrainArriere(root);
        zoneAvant = new ZoneTerrainAvant(root);
        mainView = new ArrayList<CarteViewJoueur>();
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

        initialisation(root);
    }

    public List<CarteViewJoueur> getMainView()
    {
        return mainView;
    }

    /**
     * Méthode privé d'initalisation de l'imageView
     * @param root group de la fenêtre de jeu
     */
    private void initialisation(Group root)
    {
        imageTerrain = new ImageView(new Image("terrain.jpg"));
        root.getChildren().add(0, imageTerrain);
    }

    /**
     * Méthode qui va ajouter une ImageView pour afficher la carte passer en paramètre
     * @param root le groupe qui va contenir les ImageView
     * @param carte la carte à afficher
     */
    public void addCarteMainView(Group root, Carte carte)
    {
        CarteViewJoueur iView = new CarteViewJoueur(root, this, carte, 194 + mainView.size()* 110,730);
        mainView.add(iView);
    }

    public ImageView getImageTerrain()
    {
        return imageTerrain;
    }

    /**
     * Methode que va déplacer les cartes dans la main après en avoir jouer une
     * @param i l'indice de la carte jouer
     */
    public void miseAJourMainSelonIndice(int i)
    {
        for(int j = i; j <mainView.size(); j++)
            mainView.get(j).deplacerView(mainView.get(j).getCarteView().getX() - 110, 730);

    }
}
