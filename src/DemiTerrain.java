import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
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
    private DeckView deckView;

    private Joueur owner;
    private List<CarteViewJoueur> mainView;


    //TODO enlever le constructeur debug Terrain
    //constructeur débug
    public DemiTerrain(Group root)
    {
        owner = null;
        breakZone = new BreakZone();
        damageZone = new DamageZone();
        zoneArriere = new ZoneTerrainArriere(root, false);
        zoneAvant = new ZoneTerrainAvant(root, false);
        mainView = new ArrayList<CarteViewJoueur>();
        deckView = new DeckView(root, this, false);
    }

    /**
     * Constructeur : Va créer les zones et va associé un joueur au terrain
     * @param root le group defaut
     * @param player le joueur qui va posséder le terrain
     * @param adversaire si le joueur qui possède le demiTerrai est l'adversaire
     */
    public DemiTerrain(Group root, Joueur player, boolean adversaire)
    {

        owner = player;
        breakZone = new BreakZone();
        damageZone = new DamageZone();
        zoneArriere = new ZoneTerrainArriere(root, adversaire);
        zoneAvant = new ZoneTerrainAvant(root, adversaire);
        mainView = new ArrayList<CarteViewJoueur>();
        deckView = new DeckView(root, this, adversaire);
    }

    public List<CarteViewJoueur> getMainView()
    {
        return mainView;
    }


    /**
     * Méthode qui va ajouter une ImageView pour afficher la carte passer en paramètre
     * @param root le groupe qui va contenir les ImageView
     * @param carte la carte à afficher
     */
    public void addCarteMainView(Group root, Carte carte, boolean adversaire)
    {
        CarteViewJoueur iView = new CarteViewJoueur(root, this, carte, 157 + mainView.size()* 86,664, adversaire);
        mainView.add(iView);
        //TODO a modifier
        //Jeu.envoieMessage("Carte:");



    }



    /**
     * Methode que va déplacer les cartes dans la main après en avoir jouer une
     * @param i l'indice de la carte jouer
     */
    public void miseAJourMainSelonIndice(int i)
    {
        for(int j = i; j <mainView.size(); j++)
            mainView.get(j).deplacerView(mainView.get(j).getCarteView().getX() - 86, 664);

    }

    public DeckView getDeckView()
    {
        return deckView;
    }

    public Joueur getOwner()
    {
        return owner;
    }

    public BreakZone getBreakZone()
    {
        return breakZone;
    }

    public ZoneTerrainAvant getZoneAvant()
    {
        return zoneAvant;
    }
}
