import java.util.ArrayList;

public class B_002C extends Sort{
    /*
    public B_002C(String nom, Element couleur, int cout, Joueur owner) {
        super(nom, couleur, cout, owner);
    }
    */

    private boolean spell(){
        if(owner.adversaire.terrain_soutien.isEmpty() && owner.terrain_avant.isEmpty()){
            return false;
        }else{
            System.out.println("Choose a forward to deal 6000 damage to");
            ArrayList<Avant> choix = new ArrayList<>();
            choix.addAll(owner.adversaire.terrain_avant);
            choix.addAll(owner.terrain_avant);
            int pick = 1;
            for(Avant i: owner.adversaire.terrain_avant) {
                System.out.println(pick + ": " + i.toString_basic());
            }
            return true;
        }
    }
}
