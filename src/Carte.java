import javafx.scene.image.Image;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

abstract public class Carte implements Serializable{

    private  static  final  long serialVersionUID =  1350092881346723535L;
    // Modèle général des cartes
    protected Element couleur;
    protected int cout;
    protected String nom;
    protected Joueur owner;
    protected String type;
    protected String imageReference;

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

    public String getImageReference()
    {
        return imageReference;
    }

    public String getType()
    {
        return type;
    }
}
