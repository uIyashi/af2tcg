abstract public class Carte {
    // Modèle général des cartes
    Element couleur;
    int cout;
    String nom;
    Joueur owner;

    public Carte(Joueur owner){
        this.owner = owner;
    }
}
