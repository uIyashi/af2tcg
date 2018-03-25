import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Scanner;

public class B_002C extends Sort{
    private  static  final  long serialVersionUID =  1450092881346723536L;
    public B_002C(Joueur owner){
        super(owner);
        nom = "Boule de feu LV1";
        couleur = Element.ROUGE;
    }

    @Override
    public boolean spell(){
        if(owner.getAdversaire().getTerrain_soutien().isEmpty() && owner.getTerrain_avant().isEmpty()){
            return false;
        }else{
            System.out.println("Choisissez un Avant. Il reçoit 6000 points de dégâts.");
            ArrayList<Avant> choix = new ArrayList<>();
            choix.addAll(owner.getAdversaire().getTerrain_avant());
            choix.addAll(owner.getTerrain_avant());
            int pick = 1;
            for(Avant i: owner.getAdversaire().getTerrain_avant()) {
                System.out.println(pick + ": " + i.toString_full());
            }
            Scanner sc = new Scanner(System.in);
            int r = sc.nextInt();
            if(r >= 1 && r < choix.size()){
                choix.get(r).setDamage(6000);
            }else{
                return false;
            }
            return true;
        }
    }


}
