package univ.projet.main;

import javafx.scene.Group;

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
    public static EmplacementCarteAvant carteAvantAttaque;

    private Joueur owner;
    private List<CarteViewJoueur> mainView;


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
        //univ.projet.main.Jeu.envoieMessage("univ.projet.main.Carte:");



    }



    /**
     * Methode que va déplacer les cartes dans la main après en avoir jouer une
     * @param i l'indice de la carte jouer
     */
    public void miseAJourMainSelonIndice(int i, boolean adversaire)
    {
        for(int j = i; j <mainView.size(); j++)
        {
            if(!adversaire)
                mainView.get(j).deplacerView(mainView.get(j).getCarteView().getX() - 86, 664);
            else
                mainView.get(j).deplacerView(mainView.get(j).getCarteView().getX() - 86, 18);
        }


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

    public CarteViewJoueur viewCarteMain(Carte c)
    {
        for(int i = 0; i < mainView.size(); i++)
        {
            if(mainView.get(i).getCarte().getId() == c.getId())
            {
                return mainView.get(i);
            }
        }
        return null;
    }

    public void removeWithId(Carte c)
    {
        CarteViewJoueur cv = null;
        for(int i = 0; i < mainView.size(); i++)
        {
            if(mainView.get(i).getCarte().getId() == c.getId())
            {
                 cv = mainView.get(i);
            }
        }
        if(cv != null)
            mainView.remove(cv);
    }


}
