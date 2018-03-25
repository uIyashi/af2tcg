import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *  Classe possédant les 2 demiTerrain
 */
public class Terrain
{
    private ImageView imageTerrain;
    private DemiTerrain demiTerrainJoueur;
    private DemiTerrain demiTerrainAdversaire;


    public Terrain(Group root, Joueur joueur1)
    {
        imageTerrain = new ImageView(new Image("terrain.jpg"));
        root.getChildren().add(0, imageTerrain);
        demiTerrainJoueur = new DemiTerrain(root, joueur1, false);
        demiTerrainAdversaire = new DemiTerrain(root, new Joueur(), true);
    }

    public DemiTerrain getDemiTerrainAdversaire()
    {
        return demiTerrainAdversaire;
    }

    public DemiTerrain getDemiTerrainJoueur()
    {
        return demiTerrainJoueur;
    }

    public ImageView getImageTerrain()
    {
        return imageTerrain;
    }

}
