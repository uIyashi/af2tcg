abstract public class Sort extends Carte {

    private  static  final  long serialVersionUID =  2350092881346723536L;

    public Sort(Joueur owner) {
        super(owner);
        type = "sort";
    }

    public boolean spell(){
        // Rien
        return true;
    }
}
