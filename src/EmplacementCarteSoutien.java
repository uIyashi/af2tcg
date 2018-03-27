import javafx.scene.Group;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class EmplacementCarteSoutien extends EmplacementCarteTerrain
{
    /**
     * Constructeur : va créer une ImageView qui sera placer au bon emplacement pour accueillir une carte de type Soutient
     * @param root le group principale où vont être mis les EmplacementCarteSoutien
     * @param x la coordonnée x de l'enplacement
     * @param y la coordonnée y de l'enplacement
     */
    public EmplacementCarteSoutien(Group root, int x, int y, int ind)
    {
        super(root, x, y, ind);
        /*--Mise en place des évènement pour les Drag'nDrop--*/
        //lorsque qu'on survole l'ImageView pendant un D'nD
        //TODO Modifier le drag and drop pour récupe la carte pour lancer les bonne méthode
        emplacement.setOnDragOver(event -> {
            System.err.println("DnD Over detected");
            final Dragboard dragBroard = event.getDragboard();
            final Object o = event.getGestureSource();
            if (o != emplacement && (dragBroard.getString() == "soutien")) event.acceptTransferModes(TransferMode.MOVE);
            event.consume();
        });

        emplacement.setOnDragDropped(event -> {
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
