import javafx.scene.Group;
import javafx.scene.image.ImageView;

/**
 * Classe qui contient la view pour afficher le deck à l'écran et ajouter les animations concerner
 * @author Wangon Romain "NekoRomain"
 */

public class DeckView
{
    private DemiTerrain demiTerrain;
    private ImageView carteDeckView;

    public DeckView(Group root, DemiTerrain demiTerrain)
    {
        this.demiTerrain = demiTerrain;
         initialisation(root);
    }

    public ImageView getCarteDeckView()
    {
        return carteDeckView;
    }

    private void initialisation(Group root)
    {
        carteDeckView = new ImageView(ImageCarte.DECK_FULL.getImage());
        carteDeckView.setX(1133); carteDeckView.setY(550);
        root.getChildren().add(carteDeckView);

        carteDeckView.setOnMouseReleased(event ->
        {
            if(!demiTerrain.getOwner().isaPiocher())
            {
                 Joueur j = demiTerrain.getOwner();
                  if(j.getDeck().size() > 0)
                {
                    if(j != null)
                    {
                        for(Carte c : j.pioche(1))
                            demiTerrain.addCarteMainView(root, c);
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
}
