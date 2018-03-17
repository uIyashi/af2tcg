
import javafx.scene.Group;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

/**
 * Classe représantnant un emplacement de carte Avant
 * @author Wangon Romain "NekoRomain"
 * @
 */

public class EmplacementCarteAvant extends EmplacementCarteTerrain
{
    /**
     * Constructeur : va créer une ImageView qui sera placer au bon emplacement pour accueillir une carte de type Avant
     * @param root le group principale où vont être mis les EnplacementCarteAvant
     * @param x la coordonnée x de l'enplacement
     * @param y la coordonnée y de l'enplacement
     */
    public EmplacementCarteAvant(Group root, int x, int y)
    {
        super(root, x, y);
        emplacement.setImage(ImageCarte.EMPLACEMENT_AVANT.getImage());
        text.setX(emplacement.getX()+20);
        text.setY(emplacement.getY()+70);

        emplacement.setOnDragOver(event->
        {
            System.err.println("DnD Over detected");
            final Dragboard dragBroard = event.getDragboard();
            final Object o = event.getGestureSource();
            System.err.println(o != emplacement);
            if(o != emplacement && empty && dragBroard.getString() == "avant")
                event.acceptTransferModes(TransferMode.MOVE);
            event.consume();
        });

        emplacement.setOnDragDropped(event->
        {
            System.err.println("DnD Drop detected");
            boolean success = false;
            try
            {
                final Dragboard dragBroard = event.getDragboard();
                Carte carte = (Carte)dragBroard.getContent(CarteViewJoueur.CARTE_FORMAT);
                this.carte = carte;
                if(carte instanceof Avant )
                {
                    Avant cAvant = (Avant)carte;
                    cAvant.owner.getTerrain_avant().add(cAvant);
                }

                emplacement.setImage(carte.getImage());
                System.out.println(dragBroard.getString());
                success = true;
                setEmplacement(empty);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                event.setDropCompleted(success);
                event.consume();
            }
        });
    }




}
