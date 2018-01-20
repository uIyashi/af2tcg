abstract public class Avant extends Carte {
    // Avant: Carte qui attaquent et défendent
    int puissance;
    String categorie = "Standard";
    int damage = 0; // si damage >= puissance, break
    boolean initiative = false; // Si true et défenseur == false, attaque en premier durant le calcul des dégâts
    boolean celerite = false; // Si true: peut attaquer et utiliser les compétences dull directement
    boolean bravoure =false; // Si true: ne dull pas après attaque
    public Avant(Joueur owner){
        super(owner);
        this.puissance = 1000;
        this.damage = 0;
    }

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