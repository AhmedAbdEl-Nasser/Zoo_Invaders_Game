package zoo_invaders;

import java.awt.Toolkit;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.*;

public class Zoo_Invaders extends Application {

    private static mainmenu mm;
    private static Stage S;
    private MediaPlayer mp;

    @Override
    public void start(Stage primarystage) {
        mp = new MediaPlayer(new Media(this.getClass().getResource("soundtrack.mp3").toString()));
        mp.play();
        mp.setCycleCount(Timeline.INDEFINITE);
        S = primarystage;
        mm = new mainmenu();
        Scene mainscene = new Scene(mm);
        S.setScene(mainscene);
        S.setAlwaysOnTop(true);
        S.setResizable(false);
        S.setMaximized(true);
        S.setFullScreenExitHint("");
        S.setTitle("Zoo Invaders");
        S.getIcons().add(new Image("file:gamemedia//monkey.png"));
        S.show();
    }

    public static Stage getstage() {
        return S;
    }

    //EngGame method to end the game
    public static void endgame() {
        mm = new mainmenu();
        Scene newscene = new Scene(mm);
        Zoo_Invaders.getstage().setScene(newscene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}