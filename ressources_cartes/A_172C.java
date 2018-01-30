public class A_172C extends Sort{
    public A_172C(Joueur owner){
        super(owner);
        this.nom = "Mal pour deux biens";
    }

    public boolean spell(){
        owner.pioche(2);
        owner.defausserCarteDeLaMain();
        return true;
    }
}
