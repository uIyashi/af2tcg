abstract public class Avant extends Carte {
    private  static  final  long serialVersionUID =  1350092881346723536L;
    // Avant: Carte qui attaquent et défendent
    protected int puissance;
    protected String categorie = "Standard";
    protected int damage = 0; // si damage >= puissance, break
    protected boolean initiative = false; // Si true et défenseur == false, attaque en premier durant le calcul des dégâts
    protected boolean celerite = false; // Si true: peut attaquer et utiliser les compétences dull directement
    protected boolean bravoure =false; // Si true: ne dull pas après attaque

    public Avant(Joueur owner){
        super(owner);
        this.puissance = 1000;
        this.damage = 0;
        type = "avant";
    }

    public void setDamage(int dmg){
        damage = damage + dmg;
    }

    public String toString_full(){
        return "[" + nom + " ~" + categorie + "~ #" + "] " + cout + " " + couleur + " (Bra: " + bravoure + "; Ini: " + initiative + "; Cel: " + celerite + ")";
    }

    public String toString(){
        return "[" + nom + " ~" + categorie + "~ | " + couleur + " " + cout + " | " + puissance + "]";
    }
}