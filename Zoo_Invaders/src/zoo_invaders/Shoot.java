package zoo_invaders;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Shoot {

    public Image sim;
    public ImageView simV;
    private PathTransition p;
    private Line path;

    // constructor for property binding
    public Shoot(Hero2 c, Image img) {

        simV = new ImageView(img);
        simV.setFitHeight(58);
        simV.setFitWidth(14);
        simV.setX(c.getX() + c.getW() / 4);
        simV.setY(c.getY());
        path = new Line(simV.getX() + c.getW() / 4, simV.getY(), simV.getX() + c.getW() / 4, 0);
        p = new PathTransition(Duration.millis(500), path, simV);
        p.setCycleCount(1);
        p.play();
    }

    public void addToPane(Pane pa) {
        pa.getChildren().add(simV);
    }

    public void removefromPane(Pane pa) {
        pa.getChildren().remove(simV);
    }
}
