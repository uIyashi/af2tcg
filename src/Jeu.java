import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * Classe principale.
 */



public class Jeu extends Application
{
    //Attribut global pour la mise en place de l'échange des données
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

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        int choix;
        System.out.println("1 : Serveur\n2:Client\nChoix : ");
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();

        if(choix == 1)
            serveur();
        else
            client();
        /*--------------TEST------------------*/
        primaryStage.setTitle("af2tcg");
        primaryStage.setResizable(false);
        Group root = new Group();
        Scene theScene = new Scene(root, 896, 784);
        primaryStage.setScene(theScene);
        carteDescriptionBox = new DescriptionView(root);
        Joueur j = new Joueur();
        j.melangerDeck();
        Terrain test = new Terrain(root, j);
        for(int i =0; i< 7; i++)
        {
            Carte c = j.pioche(1)[0];
            test.getDemiTerrainJoueur().addCarteMainView(root, c, false);
        }

        primaryStage.show();
        //test de reception de message
        TraitementMessage.traitementMessage(root, test);
    }

    /**
     * Méthode qui va dire que le programme est le serveur
     */
    private static void serveur()
    {
        try
        {
            serverSocket = new ServerSocket(PORT);
            try
            {
                System.out.println("Attente d'une connexion sur le port " + PORT + "\n");
                socket = serverSocket.accept();//attrente d'une connexion
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
    }

    private static void client()
    {
        try
        {
            try
            {
                InetAddress addr = InetAddress.getByName(null);//localhost
                socket = new Socket(addr, PORT);//attrente d'une connexion
                actived = true;
                ouvertureFlux();
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
    }

    public static void envoieMessage(String str)
    {
            out.println(str);
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

}
