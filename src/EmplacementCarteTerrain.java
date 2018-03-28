import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Classe représentant l'emplacement d'une carte sur le terrain (avant ou arrière)
 * @author Wangon Romain "NekoRomain"
 */
abstract public class EmplacementCarteTerrain
{
    protected ImageView emplacement;
    protected boolean empty;
    protected Text text;
    protected Carte carte;
    protected int ind;

    public EmplacementCarteTerrain(Group root, int x, int y, int ind)
    {
        this.ind = ind;
        text = new Text();
        emplacement = new ImageView();
        emplacement.setVisible(true);
        emplacement.setX(x);
        emplacement.setY(y);
        empty = true;
        carte = null;
        text.setText("");
        text.setFont(new Font("Arial", 10));
        text.setVisible(false);
        root.getChildren().add(emplacement);


    }

    /**
     * Méthode qui permet de savoir si l'emplacement de la cvarte est vide ou pas
     * @return true si vide, false sinon
     */
    public boolean isEmpty()
    {
        return empty;
    }

    protected void setEmplacement(boolean empty)
    {
        if(empty)
            this.empty = false;
        else
            this.empty = true;
    }

    public ImageView getEmplacement()
    {
        return emplacement;
    }

    public void setCarte(Carte carte)
    {
        if(carte != null)
        {
            this.carte = carte;
        }


    }

    public int getInd()
    {
        return ind;
    }
}
