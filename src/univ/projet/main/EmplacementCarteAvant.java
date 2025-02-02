package univ.projet.main;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.util.Duration;
import univ.projet.ressource_cartes.ImageCarte;

/**
 * Classe représantnant un emplacement de carte univ.projet.main.Avant
 * @author Wangon Romain "NekoRomain"
 * @
 */

public class EmplacementCarteAvant extends EmplacementCarteTerrain
{


    /**
     * Constructeur : va créer une ImageView qui sera placer au bon emplacement pour accueillir une carte de type univ.projet.main.Avant
     * @param root le group principale où vont être mis les EnplacementCarteAvant
     * @param x la coordonnée x de l'enplacement
     * @param y la coordonnée y de l'enplacement
     */
    public EmplacementCarteAvant(Group root, int x, int y, int ind, boolean adversaire)
    {
        super(root, x, y, ind);
        emplacement.setImage(ImageCarte.EMPLACEMENT_AVANT.getImage());
        text.setX(emplacement.getX()+20);
        text.setY(emplacement.getY()+70);

        if(!adversaire)
        {
            emplacement.setOnDragOver(event->
            {
                final Dragboard dragBroard = event.getDragboard();
                final Object o = event.getGestureSource();
                if(o != emplacement && empty && dragBroard.getString() == "avant")
                    event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            });
            //DnD laché sur la case
            emplacement.setOnDragDropped(event->
            {
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
                        EnvoieMessage.carteJouerAvant(cAvant, this.getInd());
                    }
                    emplacement.setImage(carte.getImage());
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


        //animation box description apparait
        emplacement.setOnMouseEntered(event ->
        {
            if(!empty)
            {
                Jeu.carteDescriptionBox.setTextBoxCarte(carte);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO, new KeyValue(Jeu.carteDescriptionBox.getRec().yProperty(), Jeu.carteDescriptionBox.getRec().getY())),
                        new KeyFrame(Duration.ZERO, new KeyValue(Jeu.carteDescriptionBox.getText().yProperty(), Jeu.carteDescriptionBox.getText().getY())),
                        new KeyFrame(new Duration(200), new KeyValue(Jeu.carteDescriptionBox.getText().yProperty(), 670)),
                        new KeyFrame(new Duration(200), new KeyValue(Jeu.carteDescriptionBox.getRec().yProperty(), 650))
                );
                timeline.play();
            }

        });

        //animation box description disparait
        emplacement.setOnMouseExited(event ->
        {
            if(!empty)
            {
                Jeu.carteDescriptionBox.setTextBoxCarte(carte);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO, new KeyValue(Jeu.carteDescriptionBox.getRec().yProperty(), Jeu.carteDescriptionBox.getRec().getY())),
                        new KeyFrame(Duration.ZERO, new KeyValue(Jeu.carteDescriptionBox.getText().yProperty(), Jeu.carteDescriptionBox.getText().getY())),
                        new KeyFrame(new Duration(200), new KeyValue(Jeu.carteDescriptionBox.getText().yProperty(), 1200)),
                        new KeyFrame(new Duration(200), new KeyValue(Jeu.carteDescriptionBox.getRec().yProperty(), 1200))
                );
                timeline.play();
            }

        });

        if(!adversaire)
        {
            emplacement.setOnMouseClicked(event ->
            {
                if(!empty)
                {
                    if(DemiTerrain.carteAvantAttaque != this)
                        DemiTerrain.carteAvantAttaque = this;
                }
            });
        }
        else
        {
            emplacement.setOnMouseClicked(event ->
            {
                if(!empty)
                {
                    if(DemiTerrain.carteAvantAttaque != null)
                    {
                        Avant ca = (Avant)DemiTerrain.carteAvantAttaque.carte;
                        Avant caa = (Avant)this.carte;
                        if(ca.getPuissance() > caa.getPuissance())
                            caa.setDamage(ca.getPuissance() - caa.getPuissance());
                        else if (ca.getPuissance() < caa.getPuissance())
                            ca.setDamage( caa.getPuissance() - ca.getPuissance());
                        else
                        {
                            ca.setDamage( caa.getPuissance()/2);
                            caa.setDamage(ca.getPuissance()/2);
                        }
                        DemiTerrain.carteAvantAttaque = null;
                    }
                }
            });
        }

    }




}
