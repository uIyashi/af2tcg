import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représsantant la zone avant du joueur
 */

public class ZoneTerrainAvant
{

    private final int EMPLACEMENT_AVANT_MAX = 7; //nombre d'emplacement de carte Avant
    EmplacementCarteAvant terrainAvant[]; //tableau d'emplacement de carte Avant
    //TODO initilaliser les zones et bien les positionner sur l'ecran dans le constructeur

    public ZoneTerrainAvant(Group root)
    {
        terrainAvant = new EmplacementCarteAvant[EMPLACEMENT_AVANT_MAX];
        for(int i = 0; i < EMPLACEMENT_AVANT_MAX; i++)
            terrainAvant[i] = new EmplacementCarteAvant(root, 224 + i* 123, 381);
    }
}
