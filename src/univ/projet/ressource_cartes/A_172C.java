package univ.projet.ressource_cartes;

import univ.projet.main.*;

public class A_172C extends Sort
{

    private static final long serialVersionUID = 39393939393939L;

    //static final DataFormat CARTE_FORMAT = new DataFormat("univ.projet.main.Carte");

    public A_172C(Joueur owner){
        super(owner);

        this.nom = "Mal pour deux biens";
        this.couleur = Element.BLEU;
        imageReference = ImageCarte.CARTE_A_172C.name();
    }

    @Override
    public boolean spell(){
        owner.pioche(2);
        owner.defausserCarteDeLaMain();
        return true;
    }


}
