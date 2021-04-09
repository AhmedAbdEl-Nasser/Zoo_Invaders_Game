package zoo_invaders;

import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

class mainmenu extends background {

    private final ImageView start, hs, credits, monkey;
    private static int dhs, oldhs;
    private Text tdhs;

    public mainmenu() {

        //Adding game name
        ImageView gamename = new ImageView("file:gamemedia//gamename.png");
        gamename.setFitWidth(800);
        gamename.setFitHeight(110);
        gamename.setX(80);
        gamename.setY(120);
        this.getChildren().add(gamename);

        //Adding ops Buttons
        VBox ops = new VBox();

        ops.setPadding(new Insets(240, 0, 0, 140));
        ops.setSpacing(0);

        start = new ImageView("file:gamemedia//start.png");
        start.setFitWidth(375);
        start.setFitHeight(212);
        start.setOpacity(0.8);
        start.setOnMouseEntered(enter -> {
            start.setOpacity(1);
        });
        start.setOnMouseExited(exit -> {
            start.setOpacity(0.8);
        });
        start.setOnMouseClicked(estart -> {
            GamePane gp = new GamePane();
            Scene gamescene = new Scene(gp);
            Zoo_Invaders.getstage().setScene(gamescene);
            gp.startgame();
            gp.requestFocus();
        });
        ops.getChildren().add(start);

        dhs = GamePane.seths();
        oldhs = dhs;
        hs = new ImageView("file:gamemedia//hs.png");
        hs.setFitWidth(375);
        hs.setFitHeight(112);
        hs.setOpacity(0.8);
        hs.setOnMouseEntered(enter -> {
            hs.setOpacity(1);
        });
        hs.setOnMouseExited(exit -> {
            hs.setOpacity(0.8);
        });
        hs.setOnMouseClicked(ehs -> {
            this.getChildren().removeAll(gamename, ops);
            VBox vbhs = new VBox();
            vbhs.setPadding(new Insets(180, 0, 0, 400));
            vbhs.setSpacing(100);
            ImageView hss = new ImageView("file:gamemedia//hs.png");
            hss.setFitWidth(500);
            hss.setFitHeight(150);
            vbhs.getChildren().add(hss);
            tdhs = new Text("" + dhs);
            tdhs.setStyle("-fx-font-size: 200px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            tdhs.setStroke(Color.GREEN);
            tdhs.setStrokeWidth(5);
            vbhs.getChildren().add(tdhs);
            this.getChildren().add(vbhs);
            Button ebutton = new Button("Back to main menu >>");
            ebutton.setAlignment(Pos.TOP_LEFT);
            ebutton.setFont(Font.font(25));
            ebutton.setPrefSize(300, 50);
            ebutton.setOnMouseClicked(eback -> {
                this.getChildren().removeAll(vbhs, ebutton);
                this.getChildren().addAll(gamename, ops);
            });
            this.getChildren().add(ebutton);
        });
        ops.getChildren().add(hs);

        //Adding monkey
        monkey = new ImageView("file:gamemedia//monkey.png");
        monkey.setFitWidth(380);
        monkey.setFitHeight(485);
        this.getChildren().add(monkey);

        Line path = new Line(1250, 650, 1250, 450);
        PathTransition pt = new PathTransition(Duration.seconds(1.5), path, monkey);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        credits = new ImageView("file:gamemedia//credits.png");
        credits.setFitWidth(375);
        credits.setFitHeight(112);
        credits.setOpacity(0.8);
        credits.setOnMouseEntered(enter -> {
            credits.setOpacity(1);
        });
        credits.setOnMouseExited(exit -> {
            credits.setOpacity(0.8);
        });
        credits.setOnMouseClicked(ecredits -> {
            this.getChildren().removeAll(ops, monkey);
            VBox vbc = new VBox();
            vbc.setPadding(new Insets(280, 500, 0, 150));
            vbc.setSpacing(40);
            Text gui = new Text("GUI");
            gui.setStyle("-fx-font-size: 75px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            gui.setStroke(Color.GREEN);
            gui.setStrokeWidth(5);
            vbc.getChildren().add(gui);
            Text guia = new Text("Ahmed Abd El Nasser");
            guia.setStyle("-fx-font-size: 60px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            guia.setStroke(Color.BROWN);
            guia.setStrokeWidth(3);
            vbc.getChildren().add(guia);
            Text ms = new Text("Graphics and Sounds");
            ms.setStyle("-fx-font-size: 70px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            ms.setStroke(Color.GREEN);
            ms.setStrokeWidth(5);
            vbc.getChildren().add(ms);
            Text msm = new Text("Mariam Nassar");
            msm.setStyle("-fx-font-size: 60px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            msm.setStroke(Color.BROWN);
            msm.setStrokeWidth(3);
            vbc.getChildren().add(msm);
            this.getChildren().add(vbc);

            VBox vbc2 = new VBox();
            vbc2.setPadding(new Insets(280, 0, 0, 1000));
            vbc2.setSpacing(40);
            Text ae = new Text("Hero, Shot, Animation");
            ae.setStyle("-fx-font-size: 65px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            ae.setStroke(Color.GREEN);
            ae.setStrokeWidth(5);
            vbc2.getChildren().add(ae);
            Text aee = new Text("Ahmed Essam");
            aee.setStyle("-fx-font-size: 60px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            aee.setStroke(Color.BROWN);
            aee.setStrokeWidth(3);
            vbc2.getChildren().add(aee);
            Text mo = new Text("Monkeys, Rocks, Animation");
            mo.setStyle("-fx-font-size: 65px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            mo.setStroke(Color.GREEN);
            mo.setStrokeWidth(5);
            vbc2.getChildren().add(mo);
            Text moo = new Text("Moaz Mohamed");
            moo.setStyle("-fx-font-size: 60px;" + "-fx-font-weight:bold;" + "-fx-font-family: Tahoma;" + "-fx-fill: white");
            moo.setStroke(Color.BROWN);
            moo.setStrokeWidth(3);
            vbc2.getChildren().add(moo);

            this.getChildren().add(vbc2);

            Button ebutton = new Button("Back to main menu >>");
            ebutton.setAlignment(Pos.TOP_LEFT);
            ebutton.setFont(Font.font(25));
            ebutton.setPrefSize(300, 50);
            ebutton.setOnMouseClicked(eback -> {
                this.getChildren().removeAll(ebutton, vbc, vbc2);
                this.getChildren().addAll(ops, monkey);
            });
            this.getChildren().add(ebutton);
        });
        ops.getChildren().add(credits);

        ImageView exit = new ImageView("file:gamemedia//exit.png");
        exit.setFitWidth(375);
        exit.setFitHeight(112);
        exit.setOpacity(0.8);
        exit.setOnMouseEntered(enter -> {
            exit.setOpacity(1);
        });
        exit.setOnMouseExited(eexit -> {
            exit.setOpacity(0.8);
        });
        exit.setOnMouseClicked(eexit -> {
            Platform.exit();
        });
        ops.getChildren().add(exit);
        this.getChildren().add(ops);
    }

    public static int getoldhs() {
        return oldhs;
    }
}
