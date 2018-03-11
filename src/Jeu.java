import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        Carte c = new A_172C(j);
        Carte c2 = new B_131C(j);
        test.addCarteMainView(root, c);
        test.addCarteMainView(root, c2);
        primaryStage.show();
    }
}
