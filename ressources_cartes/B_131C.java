import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class B_131C extends Avant {

    private  static  final  long serialVersionUID =  1350092821346723536L;
    public B_131C(Joueur owner) {
        super(owner);
        this.nom = "Paladin";
        this.puissance = 8000;
        this.couleur = Element.BLEU;
        imageReference = ImageCarte.CARTE_B_131C.name();
    }

}
