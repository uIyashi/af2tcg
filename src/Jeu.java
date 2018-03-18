import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Classe principale.
 */

public class Jeu extends Application
{
    public static DescriptionView carteDescriptionBox;

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
        Scene theScene = new Scene(root, 1280, 920);
        primaryStage.setScene(theScene);
        carteDescriptionBox = new DescriptionView(root);
        Joueur j = new Joueur();
        j.melangerDeck();
        DemiTerrain test = new DemiTerrain(root, j);

        EmplacementCarteAvant e = new EmplacementCarteAvant(root, 224, 381);
        for(int i =0; i< 8; i++)
        {
            if(i < 4)
                test.addCarteMainView(root, new A_172C(j));
            else
                test.addCarteMainView(root, new B_131C(j));
        }
       // Carte c = new A_172C(j);
        //Carte c2 = new B_131C(j);
        //test.addCarteMainView(root, c);
        //test.addCarteMainView(root, c2);
        primaryStage.show();
    }
}
