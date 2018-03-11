import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Classe principale.
 */

public class Jeu extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        /*--------------TEST------------------*/
        primaryStage.setTitle("af2tcg");

        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);

       /* Canvas canvas = new Canvas(1200, 720);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        //gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
        gc.setFont(theFont);
        gc.fillText("Hello Wolrd", 60, 50);
        gc.strokeText("Hello Wolrd", 60, 50);

        Image terrain = new Image("testTerrain.png");
        Image carte = new Image("Sans titre-2.png");
        gc.drawImage(terrain, 0, 0);
        gc.drawImage(carte, 37, 463);*/


        Joueur j = new Joueur();
        DemiTerrain test = new DemiTerrain(root);
        EmplacementCarteAvant e = new EmplacementCarteAvant(root, 224, 381);
        Carte c = new A_172C(j, root);
        Carte c2 = new A_172C(j, root);
        primaryStage.show();
    }
}
