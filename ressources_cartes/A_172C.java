import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.*;

public class A_172C extends Sort{

    private static final long serialVersionUID = 39393939393939L;

    //static final DataFormat CARTE_FORMAT = new DataFormat("Carte");

    public A_172C(Joueur owner){
        super(owner);
        type = "sort";
        this.nom = "Mal pour deux biens";
        this.couleur = Element.BLEU;
        imageReference = ImageCarte.CARTE_A_172C.name();
    }

    private void initialisation(Group root)
    {

        /*imageCarte.setImage(new Image("Sans titre-2.png")); //image lié à la carte;
        imageCarte.setVisible(true);
        root.getChildren().add(imageCarte);
        setPoint(coordonner, imageCarte.getX(), imageCarte.getY());


        imageCarte.setOnDragDetected(mp->
        {
            imageCarte.setX(mp.getX());
            imageCarte.setY(mp.getY());
            System.err.println("SORTIE");
        });

        imageCarte.setOnMouseReleased(m->
        {
            System.err.println("SORTIE");

        });

       imageCarte.setOnDragDetected(mouseEvent->
       {
           System.err.println("DnD detected");
           final  Dragboard dragBoard = imageCarte.startDragAndDrop(TransferMode.MOVE);
           final ClipboardContent content = new ClipboardContent();
           content.putImage(imageCarte.getImage());
           content.putString(type);
           dragBoard.setContent(content);
           mouseEvent.consume();
       });


       imageCarte.setOnDragOver(event->
       {
           System.err.println("DnD Over detected");
           final Dragboard dragBroard = event.getDragboard();
           final Object source = event.getGestureSource();
           if(source != imageCarte)
               event.acceptTransferModes(TransferMode.MOVE);
           event.consume();
       });

        imageCarte.setOnDragDropped(event->
        {
            System.err.println("DnD Drop detected");
            boolean success = false;
            try
            {
                final Dragboard dragBroard = event.getDragboard();
                imageCarte.setImage(dragBroard.getImage());
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

        imageCarte.setOnDragDone(event ->
        {
            if (event.getTransferMode() == TransferMode.MOVE)
            {
                this.imageCarte.setVisible(false);
                this.imageCarte = null;
                this.owner = null;

            }
            event.consume();
        });*/
    }

    public boolean spell(){
        owner.pioche(2);
        owner.defausserCarteDeLaMain();
        return true;
    }

}
