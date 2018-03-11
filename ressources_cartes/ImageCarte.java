import javafx.scene.image.Image;

/**
 * Enumération où se situe tous les images pour les cartes.
 * @author Wangon Romain "NekoRomain"
 */
public enum ImageCarte
{
    EMPLACEMENT_AVANT(new Image("avant.jpg")),
    CARTE_B_002C(new Image("sort.png")),
    CARTE_A_172C(new Image("sort.png")),
    CARTE_DOS(new Image("ss.png")),
    CARTE_B_131C(new Image("avant.png")),
    CARTE_C_015R(new Image("ss.png"));


    private Image image;

    /**
     * Constructeur privé
     * @param img image associé au nom de la carte
     */
    private ImageCarte(Image img)
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
