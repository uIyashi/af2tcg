import java.util.Scanner;

public class C_015R extends Soutien {
    public C_015R(Joueur owner){
        super(owner);
        this.nom = "Suppresseur";
        this.couleur = Element.ROUGE;
    }

    public boolean entersTheField(){
        if(owner.adversaire.terrain_avant.size() == 0){
            return true;
        }
        int dmg = 3000 + owner.adversaire.main_joueur.size() * 1000;
        System.out.println("Choisissez 1 avant de l'adversaire. " +  dmg + " dégâts lui seront infligés");
        int i = 1;
        for(Avant av: owner.adversaire.terrain_avant){
            System.out.println(i + ": " + av.toString_full());
            i++;
        }
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        owner.adversaire.terrain_avant.get(i-1).setDamage(dmg);
        return true;
    }

    public boolean exBurst(){
        entersTheField();
        return true;
    }
}
