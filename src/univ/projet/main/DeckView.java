package univ.projet.main;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import univ.projet.ressource_cartes.ImageCarte;

/**
 * Classe qui contient la view pour afficher le deck à l'écran et ajouter les animations concerner
 * @author Wangon Romain "NekoRomain"
 */

public class DeckView
{
    private DemiTerrain demiTerrain;
    private ImageView carteDeckView;

    public DeckView(Group root, DemiTerrain demiTerrain, boolean adversaire)
    {
        this.demiTerrain = demiTerrain;
         initialisation(root, adversaire);
    }

    public ImageView getCarteDeckView()
    {
        return carteDeckView;
    }

    private void initialisation(Group root, boolean adversaire)
    {
        if(!adversaire)
        {
            carteDeckView = new ImageView(ImageCarte.DECK_FULL.getImage());
            carteDeckView.setX(793); carteDeckView.setY(525);
            root.getChildren().add(carteDeckView);
            carteDeckView.setOnMouseReleased(event ->
            {
                if(!demiTerrain.getOwner().isaPiocher() && demiTerrain.getOwner().getMain_joueur().size() < 7)
                {
                    Joueur j = demiTerrain.getOwner();
                    if(j.getDeck().size() > 0)
                    {
                        if(j != null)
                        {
                            Carte cj[] = j.pioche(1);
                            for(Carte c : cj)
                                demiTerrain.addCarteMainView(root, c, adversaire);
                            EnvoieMessage.envoyeMessagePioche(cj);

                        }
                        if(j.getDeck().size() == 0)
                        {
                            carteDeckView.setVisible(false);
                        }
                    }
                    j.setaPiocher(true);
                }


            });
        }
        else
        {
            carteDeckView = new ImageView(ImageCarte.DECK_FULL.getImage());
            carteDeckView.setX(33); carteDeckView.setY(153);
            root.getChildren().add(carteDeckView);
        }
    }
}
