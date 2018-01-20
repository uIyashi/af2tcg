import java.util.ArrayList;

public class Joueur {
    ArrayList<Carte> deck;
    ArrayList<Carte> break_zone;
    ArrayList<Carte> damage_zone;
    ArrayList<Avant> terrain_avant;
    ArrayList<Soutien> terrain_soutien;
    ArrayList<Carte> main;
    Joueur adversaire;

    public Joueur() {
        deck = new ArrayList<>();
        break_zone = new ArrayList<>();
        damage_zone = new ArrayList<>();
        terrain_avant = new ArrayList<>();
        terrain_soutien = new ArrayList<>();
        main = new ArrayList<>();

        pioche(5);
    }

    public void pioche(int nb_carte){
        for(int i = 0; i < nb_carte; i++) {
            if(gameOverCheck()){
                break;
            }
            main.add(deck.get(0));
            deck.remove(0);
        }
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
