import java.io.Serializable;
import java.util.List;

/**
 * Classe abstraite représentant une zone d'un joueur
 * @author Wangon Romain "NekoRomain"
 */
abstract public class Zone implements Serializable
{

    List<Carte> zone;

    /**
     * Méthode qui ajoute une carte à la zone
     * @param carte la carte à ajouter
     */
    public void ajouteCarte(Carte carte)
    {
        zone.add(carte);
    }

    /**
     * Méthode qui donne le nombre de carte dans la zone
     * @return
     */
    public int tailleListe()
    {
        return zone.size();
    }

    public List<Carte> getBreak_zone()
    {
        return zone;
    }

    public void setBreak_zone(List<Carte> break_zone)
    {
        this.zone = break_zone;
    }
}
