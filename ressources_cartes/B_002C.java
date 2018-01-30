import java.util.ArrayList;
import java.util.Scanner;

public class B_002C extends Sort{
    public B_002C(Joueur owner){
        super(owner);
        nom = "Boule de feu LV1";
    }

    public boolean spell(){
        if(owner.adversaire.terrain_soutien.isEmpty() && owner.terrain_avant.isEmpty()){
            return false;
        }else{
            System.out.println("Choisissez un Avant. Il reçoit 6000 points de dégâts.");
            ArrayList<Avant> choix = new ArrayList<>();
            choix.addAll(owner.adversaire.terrain_avant);
            choix.addAll(owner.terrain_avant);
            int pick = 1;
            for(Avant i: owner.adversaire.terrain_avant) {
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
