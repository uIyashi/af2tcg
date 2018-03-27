import javafx.scene.Group;

/**
 * Classe représsantant la zone avant du joueur
 */

public class ZoneTerrainAvant
{

    private final int EMPLACEMENT_AVANT_MAX = 7; //nombre d'emplacement de carte Avant
    private EmplacementCarteAvant terrainAvant[]; //tableau d'emplacement de carte Avant
    //TODO initilaliser les zones et bien les positionner sur l'ecran dans le constructeur

    public ZoneTerrainAvant(Group root, boolean adversaire)
    {
        terrainAvant = new EmplacementCarteAvant[EMPLACEMENT_AVANT_MAX];
        if(!adversaire)
        {
            for(int i = 0; i < EMPLACEMENT_AVANT_MAX; i++)
                terrainAvant[i] = new EmplacementCarteAvant(root, 157 + i* 86, 407,i, false);
        }
        else
        {
            for(int i = 0; i < EMPLACEMENT_AVANT_MAX; i++)
                terrainAvant[i] = new EmplacementCarteAvant(root, 157 + i* 86, 270,i, true);
        }

    }

    public EmplacementCarteAvant[] getTerrainAvant()
    {
        return terrainAvant;
    }
}
