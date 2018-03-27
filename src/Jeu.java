import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * Classe principale.
 */



public class Jeu extends Application
{
    //Attribut global pour la mise en place de l'échange des données
    private static BooleanProperty completedProperty = new SimpleBooleanProperty(false);
    public static ServerSocket serverSocket;
    public static Socket socket;
    public static final int PORT = 3939;
    public static String nomServer;
    public static InputStreamReader socketIn;
    public static BufferedReader in;
    public static OutputStreamWriter socketOut;
    public static PrintWriter out;
    public static DescriptionView carteDescriptionBox;
    public static boolean actived;
    public static ObjectOutputStream outToClient;
    public static ObjectInputStream inFromClient;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        menu(primaryStage);
        primaryStage.setTitle("af2tcg");
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * Méthode qui va dire que le programme est le serveur
     */
    private static void serveur(Group g)
    {
        new Thread(()->
        {
            try
            {
                serverSocket = new ServerSocket(PORT);
                try
                {
                    System.out.println("Attente d'une connexion sur le port " + PORT + "\n");
                    Platform.runLater(()->
                    {
                        Text t = new Text("Attente d'une connexion sur le port " + PORT);
                        t.setFont(new Font("Arial", 40));
                        t.setY(g.getScene().getHeight()/2);
                        t.setWrappingWidth(g.getScene().getWidth());
                        t.setTextAlignment(TextAlignment.CENTER);
                        g.getChildren().add(t);
                    });
                    socket = serverSocket.accept();//attente d'une connexion
                    actived = true;
                    ouvertureFlux();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }).start();

    }

    private static void client(Group g)
    {
        new Thread(()->
        {
            try
            {
                try
                {
                    InetAddress addr = InetAddress.getByName(null);//localhost
                    Platform.runLater(()->
                    {
                        Text t = new Text("Attente d'une connexion sur le serveur " + addr + "sur le port " + PORT);
                        t.setFont(new Font("Arial", 30));
                        t.setY(g.getScene().getHeight()/2);
                        t.setWrappingWidth(g.getScene().getWidth());
                        t.setTextAlignment(TextAlignment.CENTER);
                        g.getChildren().add(t);
                    });
                    socket = new Socket(addr, PORT);//attrente d'une connexion
                    ouvertureFlux();
                    actived = true;

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

    }

    private static void ouvertureFlux()
    {
        try
        {
            System.out.println("Connexion réussit.\n");
            socketIn = new InputStreamReader(socket.getInputStream());
            in = new BufferedReader(socketIn);
            socketOut = new OutputStreamWriter(socket.getOutputStream());
            out = new PrintWriter(new BufferedWriter(socketOut), true);
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
            Platform.runLater(()->completedProperty.setValue(true));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void stop(){
        actived = false;
        try
        {
            outToClient.close();
            inFromClient.close();
            out.close();
            socketOut.close();
            in.close();
            socketIn.close();
            socket.close();
            if(serverSocket != null)
                serverSocket.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void menu(Stage primaryStage)
    {
        primaryStage.setMaxWidth(902);
        primaryStage.setMaxHeight(813);
        primaryStage.setMinWidth(902);
        primaryStage.setMinHeight(813);
        Group menuGroup = new Group();
        Scene menuPrincipale = new Scene(menuGroup, 896, 784);
        primaryStage.setScene(menuPrincipale);
        Button serveurButton = new Button();
        serveurButton.setStyle("-fx-background-image: url('serverButton.png')");
        serveurButton.setMinWidth(296);
        serveurButton.setMinHeight(75);
        serveurButton.setLayoutX(300);
        serveurButton.setLayoutY(437);
        Button clientButton = new Button();
        clientButton.setStyle("-fx-background-image: url('clientButton.png')");
        clientButton.setMinWidth(296);
        clientButton.setMinHeight(75);
        clientButton.setLayoutX(300);
        clientButton.setLayoutY(573);
        menuGroup.getChildren().add(new ImageView(new Image("ecranPrincipale.jpg")));
        menuGroup.getChildren().add(serveurButton);
        menuGroup.getChildren().add(clientButton);

        serveurButton.setOnMouseClicked(event ->
        {
            serveurButton.setVisible(false);
            clientButton.setVisible(false);
            serveur(menuGroup);
        });
        clientButton.setOnMouseClicked(event ->
        {
            serveurButton.setVisible(false);
            clientButton.setVisible(false);
            client(menuGroup);
        });

        completedProperty.addListener((observable, oldvalue, newvalue)->
        {
            if(oldvalue.booleanValue() == false && newvalue.booleanValue() == true)
            {
                jeuLancer(primaryStage);
            }
        });

    }

    private static void jeuLancer(Stage primartStage)
    {
        Group root = new Group();
        Scene theScene = new Scene(root, 896, 784);
        primartStage.setScene(theScene);
        carteDescriptionBox = new DescriptionView(root);
        Joueur j = new Joueur();
        j.melangerDeck();
        Terrain test = new Terrain(root, j);
        Carte[] c = j.pioche(3);
        for(Carte cc : c)
            test.getDemiTerrainJoueur().addCarteMainView(root, cc, false);
        EnvoieMessage.envoyeMessagePioche(c);
        TraitementMessage.traitementMessage(root, test);
    }

}
