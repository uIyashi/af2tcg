import javafx.scene.image.Image;

/**
 * Enumération où se situe tous les images pour les cartes.
 * @author Wangon Romain "NekoRomain"
 */
public enum ImageCarte
{
    EMPLACEMENT_AVANT(new Image("avant.jpg")),
    CARTE_A_172C(new Image("ss.png"));
    /*CARTE_DOS(new Image("DOS.png")),
    CARTE_B_002C(new Image("B_002C.png")),
    CARTE_B_131C(new Image("B_131C.png")),
    CARTE_C_015R(new Image("C_015R.png"));*/

    private Image image;

    /**
     * Constructeur privé
     * @param img image associé au nom de la carte
     */
    private ImageCarte(Image img)
    {
        image = img;
    }

    public Image get()
    {
        return image;
    }
}
