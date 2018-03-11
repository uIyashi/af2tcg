import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur {

    List<Carte> deck;
    List<Carte> break_zone;
    List<Carte> damage_zone;
    List<Avant> terrain_avant;
    List<Soutien> terrain_soutien;
    List<Carte> main_joueur;
    Joueur adversaire;

    //test
    BreakZone breakZone;
    DamageZone damageZone;

    public Joueur() {
        deck = new ArrayList<>();
        break_zone = new ArrayList<>();
        damage_zone = new ArrayList<>();
        terrain_avant = new ArrayList<>();
        terrain_soutien = new ArrayList<>();
        main_joueur = new ArrayList<>();

        pioche(5);
    }

    public void pioche(int nb_carte){
        for(int i = 0; i < nb_carte; i++) {
            if(gameOverCheck()){
                break;
            }
            main_joueur.add(deck.get(0));
            deck.remove(0);
        }
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
}
