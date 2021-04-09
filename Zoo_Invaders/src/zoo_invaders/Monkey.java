package zoo_invaders;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Monkey {

    public Image mim;
    public ImageView mimv;
    public Image rockim = new Image("file:gamemedia//rock.png");
    public ArrayList<Rock> rocks = new ArrayList();

    public Monkey(Image img) {
        mimv = new ImageView(img);
        mimv.setFitHeight(60);
        mimv.setFitWidth(60);
    }

    public void setX(double x) {
        mimv.setX(x);
    }

    public void setY(double y) {
        mimv.setY(y);
    }

    public double getX() {
        return mimv.getX();
    }

    public double getY() {
        return mimv.getY();
    }

    public double getW() {
        return mimv.getFitWidth();
    }

    public double getH() {
        return mimv.getFitHeight();
    }

    public void hitCar(Pane p) {
        Rock r = new Rock(this, rockim);
        r.addToPane(p);
        rocks.add(r);
    }

    public void addToPane(Pane p) {
        p.getChildren().add(mimv);
    }

    public void removefromPane(Pane p) {
        p.getChildren().remove(mimv);
    }
}
