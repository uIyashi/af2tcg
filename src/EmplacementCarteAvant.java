import com.sun.prism.GraphicsResource;
import javafx.scene.Group;
import javafx.scene.image.Image;
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
        emplacement.setImage(ImageCarte.EMPLACEMENT_AVANT.get());
        text.setX(emplacement.getX()+20);
        text.setY(emplacement.getY()+70);


        emplacement.setOnDragOver(event->
        {
            System.err.println("DnD Over detected");
            final Dragboard dragBroard = event.getDragboard();
            final Object o = event.getGestureSource();
            if(o != emplacement && (dragBroard.getString() == "sort" || dragBroard.getString() == "avant"))
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
                emplacement.setImage(dragBroard.getImage());
                System.out.println(dragBroard.getString());
                success = true;
            }
            catch (Exception ex)
            {
            }
            finally
            {
                event.setDropCompleted(success);
                event.consume();
            }
        });
    }




}
