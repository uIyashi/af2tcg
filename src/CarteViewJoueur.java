
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.util.Duration;

/**
 * Classe contenant l'imaView pour afficher un carte du joueur et va contenir les évènement associer
 * @author Wangon Romain "NekoRomain"
 */

public class CarteViewJoueur
{

    private ImageView carteView;
    private DemiTerrain demiTerrainOwner;
    static final DataFormat CARTE_FORMAT = new DataFormat("Carte");

    public CarteViewJoueur(Group root, DemiTerrain demiTerrain, Carte carte, int x, int y)
    {
        carteView = new ImageView(carte.getImage());
        carteView.setX(0);
        carteView.setY(0);
        this.demiTerrainOwner = demiTerrain;
        initialisation(root, carte);

        //animation de tirage de la carte
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(carteView.xProperty(), demiTerrain.getDeckView().getCarteDeckView().getX())),
                new KeyFrame(Duration.ZERO, new KeyValue(carteView.yProperty(), demiTerrain.getDeckView().getCarteDeckView().getY())),
                new KeyFrame(new Duration(500), new KeyValue(carteView.xProperty(), x)),
                new KeyFrame(new Duration(500), new KeyValue(carteView.yProperty(), y))
        );
        timeline.play();
        if(timeline.getStatus() == Animation.Status.STOPPED)
        {
        }


    }

    public ImageView getCarteView()
    {
        return carteView;
    }
    
    private void initialisation(Group root, Carte carte)
    {
        root.getChildren().add(carteView);

        if(carte.type == "avant") //si une carte de type avant
        {
            //Un drag'nDrop est détecté
            carteView.setOnDragDetected(mouseEvent->
            {
                carteView.setVisible(false);
                System.err.println("DnD detected");
                final Dragboard dragBoard = carteView.startDragAndDrop(TransferMode.MOVE);
                final ClipboardContent content = new ClipboardContent();
                content.putImage(carte.getImage());
                content.putString(carte.getType());
                content.put(CARTE_FORMAT, carte);
                dragBoard.setContent(content);
                mouseEvent.consume();
            });

            //Un drag'nDrop est fini avec succès
            carteView.setOnDragDone(event ->
            {
                if (event.getTransferMode() == TransferMode.MOVE)
                {
                    this.carteView.setVisible(false);
                    this.carteView = null;
                    int ind = demiTerrainOwner.getMainView().indexOf(this);
                    demiTerrainOwner.getMainView().remove(this);
                    demiTerrainOwner.miseAJourMainSelonIndice(ind);
                    root.getChildren().remove(carteView);
                }
                else
                    carteView.setVisible(true);
                event.consume();
            });
        }
        else //si une carte de type sort, on lui donne d'autre évènement possible
        {
            carteView.setOnMouseReleased(event ->
            {
                //TODO faire en sort de lancer le sort si possible et de gérer les liste de carte et les pv
                System.err.println("SORT LANCER !");
                this.carteView.setVisible(false);
                this.carteView = null;
                int ind = demiTerrainOwner.getMainView().indexOf(this);
                demiTerrainOwner.getMainView().remove(this);
                demiTerrainOwner.miseAJourMainSelonIndice(ind);
                root.getChildren().remove(carteView);
            });
        }

    }

    /**
     * Méthode qui va déplacer la vue aux coordonnées x et y
     * @param x coordonnée x
     * @param y coordonnée y
     */
    public void deplacerView(double x, double y)
    {
        //animation de tirage de la carte
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(carteView.xProperty(), carteView.getX())),
                new KeyFrame(Duration.ZERO, new KeyValue(carteView.yProperty(), carteView.getY())),
                new KeyFrame(new Duration(50), new KeyValue(carteView.xProperty(), x)),
                new KeyFrame(new Duration(50), new KeyValue(carteView.yProperty(), y))
        );
        timeline.play();
    }

}
