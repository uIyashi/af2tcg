package univ.projet.ressource_cartes;

import javafx.scene.image.Image;

/**
 * Enumération où se situe tous les images pour les cartes.
 * @author Wangon Romain "NekoRomain"
 */
public enum ImageCarte
{
    EMPLACEMENT_AVANT(new Image("avant.jpg", 70, 105, false, false)),
    DECK_FULL(new Image("deckFull.png", 70, 105, false, false)),
    CARTE_A_172C(new Image("sort.png", 70, 105, false, false)),
    CARTE_DOS(new Image("dos.png", 70, 105, false, false)),
    CARTE_B_131C(new Image("avant.png", 70, 105, false, false)),
    DECK_HALF(new Image("avant.jpg", 70, 105, false, false)),
    DECK_EMPTY(new Image("avant.jpg", 70, 105, false, false)),
    CARTE_B_002C(new Image("sort.png", 70, 105, false, false)),
    CARTE_C_015R(new Image("ss.png", 70, 105, false, false));


    private Image image;

    /**
     * Constructeur privé
     * @param img image associé au nom de la carte
     */
    ImageCarte(Image img)
    {
        image = img;
    }

    public Image getImage()
    {
        return image;
    }

    public static Image getImage(String nom)
    {
        return ImageCarte.valueOf(nom).getImage();
    }
}
