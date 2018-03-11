import javafx.scene.image.ImageView;


import java.io.Serializable;

abstract public class Carte implements Serializable{

    private  static  final  long serialVersionUID =  1350092881346723535L;
    // Modèle général des cartes
    protected Element couleur;
    protected int cout;
    protected String nom;
    protected Joueur owner;
    protected String type;

    public Carte(Joueur owner){
        this.owner = owner;
    }

    public String toString(){
        return "[" + nom + " | " + cout + " " + couleur + "]";
    }

    public boolean entersTheField(){
        // Rien
        return true;
    }

}
