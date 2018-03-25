import javafx.scene.Group;

/**
 * Classe représantant la zone arrière d'un joueur
 * @author Wangon Romain "NekoRomain"
 */

public class ZoneTerrainArriere
{
    final int EMPLACEMENT_SOUTIEN_MAX = 5; //nombre d'emplacement de carte soutient
    EmplacementCarteSoutien terrainArriere[]; //tableau d'emplacement de carte soutient

    public ZoneTerrainArriere(Group root, boolean adversaire)
    {
        terrainArriere = new EmplacementCarteSoutien[EMPLACEMENT_SOUTIEN_MAX];
        for(int i = 0; i < EMPLACEMENT_SOUTIEN_MAX; i++)
        {
            //terrainArriere[i] = new EmplacementCarteSoutien(root);
        }

    }
}
