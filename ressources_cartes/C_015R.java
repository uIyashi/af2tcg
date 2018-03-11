import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Scanner;

public class C_015R extends Soutien {
    private  static  final  long serialVersionUID =  1350192881346723536L;

    public C_015R(Joueur owner){
        super(owner);
        this.nom = "Suppresseur";
        this.couleur = Element.ROUGE;
    }

    @Override
    public boolean entersTheField(){
        if(owner.getAdversaire().getTerrain_avant().size() == 0){
            return true;
        }
        int dmg = 3000 + owner.getAdversaire().getMain_joueur().size() * 1000;
        System.out.println("Choisissez 1 avant de l'adversaire. " +  dmg + " dégâts lui seront infligés");
        int i = 1;
        for(Avant av: owner.getAdversaire().getTerrain_avant()){
            System.out.println(i + ": " + av.toString_full());
            i++;
        }
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        owner.getAdversaire().getTerrain_avant().get(i-1).setDamage(dmg);
        return true;
    }

    public boolean exBurst(){
        entersTheField();
        return true;
    }
}
