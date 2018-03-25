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

    public Image getImage()
    {
        return ImageCarte.getImage(imageReference);
    }

    public String getType()
    {
        return type;
    }

    public String getImageReference()
    {
        return imageReference;
    }

    public static Carte creationCarte(String nom, Joueur j)
    {
        if(nom.equals(ImageCarte.CARTE_A_172C.name()))
            return new A_172C(j);
        if(nom.equals(ImageCarte.CARTE_B_131C.name()))
            return new B_131C(j);
        return null;
    };
}
