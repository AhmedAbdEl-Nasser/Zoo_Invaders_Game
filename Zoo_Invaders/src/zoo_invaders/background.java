package zoo_invaders;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class background extends Pane {

    public ImageView background;

    //For main background of the game
    public background() {
        background = new ImageView("file:gamemedia//background.jpg");
        this.getChildren().add(background);
    }
}