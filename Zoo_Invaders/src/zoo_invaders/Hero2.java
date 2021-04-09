package zoo_invaders;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Hero2 {

    public Image him;
    public ImageView himv;
    private int score;
    public Text scoreText;
    public ArrayList<Shoot> shoots = new ArrayList();

    public double speed;

    public Hero2(double x, double y) {
        //Shoot sh=new Shoot(this);
        him = new Image("file:gamemedia//hero.png");
        himv = new ImageView(him);
        himv.setFitHeight(113.6);
        himv.setFitWidth(100);
        himv.setX(x);
        himv.setY(y);
        score = 0;
        speed = 5;
        scoreText = new Text("Score: " + score);
        scoreText.setX(10);
        scoreText.setY(40);
        scoreText.setStyle("-fx-font-size: 50px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
        scoreText.setStroke(Color.GREEN);
    }

    public void shooot(Pane pane) {
        Image image = new Image("file:gamemedia//shot.png");
        Shoot s = new Shoot(this, image);
        s.addToPane(pane);
        shoots.add(s);
    }

    public void addToPane(Pane p) {
        p.getChildren().addAll(himv, scoreText);
    }

    public void RemoveToPane(Pane p) {
        p.getChildren().removeAll(himv, scoreText);
    }

    public double getX() {
        return himv.getX();
    }

    public double getY() {
        return himv.getY();
    }

    public int getScore() {
        return score;
    }

    public double getW() {
        return himv.getFitWidth();
    }

    public double getH() {
        return himv.getFitHeight();
    }

    public void move(String dir, double Xlim, double Ylim) {
        double nwx = himv.getX();
        double nwy = himv.getY();

        switch (dir) {
            //case "up":
            //nwy -= speed;
            //break;
            //case "down":
            //nwy += speed;
            //break;
            case "right":
                nwx += speed;
                break;
            case "left":
                nwx -= speed;
                break;
        }

        if (nwx >= 0 && nwy >= 0
                && nwx <= Xlim - getW()
                && nwy <= Ylim + getH()) {
            himv.setX(nwx);
            himv.setY(nwy);
        }
    }

    public void SetScore(Pane p, int Score) {
        this.score = Score;
        p.getChildren().remove(scoreText);
        scoreText = new Text("Score: " + this.score);
        scoreText.setX(10);
        scoreText.setY(40);
        scoreText.setStyle("-fx-font-size: 50px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
        scoreText.setStroke(Color.GREEN);
        p.getChildren().addAll(scoreText);
    }
}
