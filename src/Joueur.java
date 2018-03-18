import java.io.Serializable;
import java.util.*;

public class Joueur implements Serializable{

    private  static  final  long serialVersionUID =  1350092881346723535L;

    private List<Carte> deck;
    private List<Carte> break_zone;
    private List<Carte> damage_zone;
    private List<Avant> terrain_avant;
    private List<Soutien> terrain_soutien;
    private List<Carte> main_joueur;
    private Joueur adversaire;
    private boolean aPiocher;

    public Joueur() {
        aPiocher = false;
        deck = new ArrayList<>();
        break_zone = new ArrayList<>();
        damage_zone = new ArrayList<>();
        terrain_avant = new ArrayList<>();
        terrain_soutien = new ArrayList<>();
        main_joueur = new ArrayList<>();

        //TODO A ENLEVER
        deck.add(new A_172C(this));
        deck.add(new A_172C(this));
        deck.add(new B_131C(this));
        //pioche(5);
    }

    /*public void pioche(int nb_carte){
        for(int i = 0; i < nb_carte; i++) {
            if(gameOverCheck()){
                break;
            }
            main_joueur.add(deck.get(0));
            deck.remove(0);
        }
    }*/

    public Carte[] pioche(int nb_carte){
        Carte cartesPiochee[] = new Carte[nb_carte];
        for(int i = 0; i < nb_carte; i++) {
            if(gameOverCheck()){
                break;
            }
            Carte cartePiochee = deck.get(0);
            main_joueur.add(cartePiochee);
            cartesPiochee[i] = cartePiochee;
            deck.remove(0);
        }
        return cartesPiochee;
    }

    public void melangerDeck()
    {
        List<Carte> deckMelanger = new ArrayList<>(deck);
        Collections.shuffle(deckMelanger);
        deck = deckMelanger;
    }

    public void defausserCarteDeLaMain(){
        System.out.println("Choisissez une carte a défausser");
        int i = 1;
        for(Carte c: main_joueur){
            System.out.println(i + ": " + c.toString());
            i++;
        }
        Scanner sc = new Scanner(System.in);
        int id =  sc.nextInt();
        break_zone.add(main_joueur.remove(id-1));
    }

    public boolean gameOverCheck(){
        // Défaite (true) si deck vide au moment de piocher ou damage_zone.length == 7
        if(deck.size() == 0 || damage_zone.size() >= 7){
            return true;
        }else{
            return false;
        }
    }

    public void damage(){
        damage_zone.add(deck.get(0));
        deck.remove(0);
    }

    public Joueur getAdversaire()
    {
        return adversaire;
    }

    public List<Avant> getTerrain_avant()
    {
        return terrain_avant;
    }

    public List<Soutien> getTerrain_soutien()
    {
        return terrain_soutien;
    }

    public List<Carte> getMain_joueur()
    {
        return main_joueur;
    }

    public List<Carte> getDeck()
    {
        return deck;
    }

    public List<Carte> getBreak_zone() {
        return break_zone;
    }

    public boolean isaPiocher()
    {
        return aPiocher;
    }

    public void setaPiocher(boolean value)
    {
        aPiocher = value;
    }
}
