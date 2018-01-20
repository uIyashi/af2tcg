abstract public class Avant extends Carte {
    // Avant: Carte qui attaquent et défendent
    int puissance;
    String categorie;
    int damage; // si damage >= puissance, break
    boolean initiative; // Si true et défenseur == false, attaque en premier durant le calcul des dégâts
    boolean celerite; // Si true: peut attaquer et utiliser les compétences dull directement
    boolean bravoure; // Si true: ne dull pas après attaque
    /*
    public Avant(String nom, Element couleur, int cout, int puissance, String categorie, Joueur owner){
        super(nom, couleur, cout, owner);
        this.puissance = puissance;
        this.categorie = categorie;
        this.damage = 0;
        this.initiative = false;
        this.celerite = false;
        this.bravoure = false;
    }
    */

    public void setDamage(int dmg){
        damage = damage + dmg;
    }

    public String toString(){
        return "[" + nom + " ~" + categorie + "~ #" + "] " + cout + " " + couleur + " (Bra: " + bravoure + "; Ini: " + initiative + "; Cel: " + celerite + ")";
    }

    public String toString_basic(){
        return "[" + nom + " ~" + categorie + "~ | " + couleur + " " + cout + " | " + puissance + "]";
    }
}