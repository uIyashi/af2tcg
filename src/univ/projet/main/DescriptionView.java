package univ.projet.main;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class DescriptionView
{
    private Rectangle rec;
    private Text text;

    public DescriptionView(Group root)
    {
        rec = new Rectangle(125, 300);
        text = new Text();
        rec.setArcHeight(10);
        rec.setArcWidth(10);
        rec.setX(2);
        rec.setY(800);
        rec.setFill(Color.GRAY);
        rec.setOpacity(0.7);
        rec.setVisible(true);
        text.setScaleX(rec.getScaleX());
        text.setScaleY(rec.getScaleY());
        text.setX(rec.getX() + 5);
        text.setY(rec.getY() + 20);
        text.setText("Test.\nTest\nTest");
        root.getChildren().add(rec);
        root.getChildren().add(text);
    }

    public Rectangle getRec()
    {
        return rec;
    }

    public Text getText()
    {
        return text;
    }

    public void setTextBoxCarte(Carte c)
    {
        if(c instanceof Avant)
        {
            Avant ca = (Avant)c;
            text.setText(c.getNom()+"\n\n"+"pv : " + ca.getPv()
                    +"\n\n"+"Puissance : " + ca.getPuissance()
                    +"\n\n"+"Damage : " + ca.getDamage()
            );
        }

    }
}
