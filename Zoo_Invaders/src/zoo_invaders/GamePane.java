package zoo_invaders;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

class GamePane extends background {

    private KM km;
    private Hero2 h;
    private Timeline tl, t2;
    private ArrayList<Monkey> m = new ArrayList();
    private double lastShotTime;
    double speed = 5;
    private static int newscore;
    Button ebutton;
    mainmenu mm1;
    MediaPlayer mpm, mpsh;
    MediaPlayer tada = new MediaPlayer(new Media(this.getClass().getResource("tada.mp3").toString()));
    MediaPlayer mpend = new MediaPlayer(new Media(this.getClass().getResource("happymonkey.mp3").toString()));

    public GamePane() {
        newscore = 0;
        km = new KM();
        this.setOnKeyPressed(
                e -> {
                    km.setkeystate(e.getCode(), true);
                }
        );
        this.setOnKeyReleased(
                e -> {
                    km.setkeystate(e.getCode(), false);
                }
        );

        //creating hero
        h = new Hero2(850, 900);
        h.addToPane(this);

        //creating monkeys
        Image mim = new Image("file:gamemedia//monkey.png");
        int countery = 40;
        int counterx = 350;
        for (int i = 1; i <= 48; i++) {
            Monkey monkey = new Monkey(mim);
            monkey.addToPane(this);
            monkey.setX(counterx);
            monkey.setY(countery);
            counterx += 100;
            m.add(monkey);
            if (i % 12 == 0) {
                countery += 120;
                counterx = 350;
            }
        }

        KeyFrame kf1 = new KeyFrame(Duration.millis(1000 / 60),
                e
                -> {
            updateGame();
        }
        );
        KeyFrame kf2 = new KeyFrame(Duration.millis(1100),
                e -> {
                    updateGame2();
                });

        tl = new Timeline(kf1);
        tl.setCycleCount(Timeline.INDEFINITE);
        t2 = new Timeline(kf2);
        t2.setCycleCount(Timeline.INDEFINITE);
    }

    public void startgame() {
        tl.play();
        t2.play();
    }

    public void updateGame() {

        if (km.getkeystate(KeyCode.RIGHT)) {
            h.move("right", getWidth(), getHeight());
        }
        if (km.getkeystate(KeyCode.LEFT)) {
            h.move("left", getWidth(), getHeight());
        }
        if (km.getkeystate(KeyCode.SPACE)) {
            if (System.currentTimeMillis() - lastShotTime >= 200) {
                h.shooot(this);
                lastShotTime = System.currentTimeMillis();
                mpsh = new MediaPlayer(new Media(this.getClass().getResource("pew.mp3").toString()));
                mpsh.play();
            }
        }

        for (int i = 0; i < h.shoots.size(); i++) {
            Shoot shoot = h.shoots.get(i);
            if (shoot.simV.getY() + shoot.simV.getTranslateY() <= 0) {
                shoot.removefromPane(this);
                h.shoots.remove(i);
            }
            for (int k = 0; k < m.size(); k++) {
                Monkey monkey = m.get(k);
                if (shoot.simV.getBoundsInParent().intersects(monkey.mimv.getBoundsInParent())) {
                    monkey.removefromPane(this);
                    shoot.removefromPane(this);
                    h.shoots.remove(i);
                    m.remove(k);
                    newscore += 10;
                    h.SetScore(this, newscore);
                    mpm = new MediaPlayer(new Media(this.getClass().getResource("scream.mp3").toString()));
                    mpm.play();
                }
            }
        }
        if (m.size() == 0) {

            tl.stop();
            t2.stop();
            h.RemoveToPane(this);
            Text txt = new Text(400, 600, "YOU WON !");
            txt.setStyle("-fx-font-size: 200px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            txt.setStroke(Color.GREEN);
            txt.setStrokeWidth(5);
            this.getChildren().add(txt);
            tada.play();
            ebutton = new Button("Back to main menu >>");
            ebutton.setFont(Font.font(25));
            ebutton.setPrefSize(300, 50);
            ebutton.setOnMouseClicked(eee -> {
                Zoo_Invaders.endgame();
            });
            this.getChildren().add(ebutton);

        }
    }

    public void updateGame2() {
//        double num1= Math.random()* 12;
//        double num2= 12 + Math.random()* 11;
//        double num3 = 24 + Math.random()* 11 ;
//        double num4= 36 + Math.random()* 11;
        int range = m.size() > 4 ? 4 : m.size();
        for (int i = 0; i < range; i++) {
            m.get((int) (Math.random() * m.size())).hitCar(this);
        }
        for (Monkey monkey : m) {
            monkey.setY(monkey.getY() + speed);

//                m.get((int)num1).hitCar(this);
//                m.get((int)num2).hitCar(this);
//                m.get((int)num3).hitCar(this);
//                m.get((int)num4).hitCar(this);
            if (monkey.mimv.getY() >= h.getY()) {
                tl.stop();
                t2.stop();
                h.RemoveToPane(this);
                mpend.play();
                Text txt = new Text(400, 600, "YOU LOST !");
                txt.setStyle("-fx-font-size: 200px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
                txt.setStroke(Color.RED);
                txt.setStrokeWidth(5);
                this.getChildren().add(txt);
                Button ebutton = new Button("Back to main menu >>");
                ebutton.setAlignment(Pos.TOP_LEFT);
                ebutton.setFont(Font.font(25));
                ebutton.setPrefSize(300, 50);
                this.getChildren().add(ebutton);
                ebutton.setOnMouseClicked(eeexit -> {
                    Zoo_Invaders.endgame();
                });
            }
            for (int k = 0; k < monkey.rocks.size(); k++) {
                if (h.himv.getBoundsInParent().intersects(monkey.rocks.get(k).rimV.getBoundsInParent())) {
                    tl.stop();
                    t2.stop();
                    h.RemoveToPane(this);
                    mpend.play();
                    Text txt = new Text(400, 600, "YOU LOST !");
                    txt.setStyle("-fx-font-size: 200px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
                    txt.setStroke(Color.RED);
                    txt.setStrokeWidth(5);
                    this.getChildren().add(txt);
                    Button ebutton = new Button("Back to main menu >>");
                    ebutton.setAlignment(Pos.TOP_LEFT);
                    ebutton.setFont(Font.font(25));
                    ebutton.setPrefSize(300, 50);
                    this.getChildren().add(ebutton);
                    ebutton.setOnMouseClicked(eeexit -> {
                        Zoo_Invaders.endgame();
                    });
                }
            }
        }

    }

    public static int seths() {
        if (newscore > mainmenu.getoldhs()) {
            return newscore;
        } else {
            return mainmenu.getoldhs();
        }
    }
}
