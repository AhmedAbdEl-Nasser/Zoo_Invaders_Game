package zoo_invaders;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Rock 

{
    public Image rim;
    public ImageView rimV;
    private PathTransition p2;
    private Line path2;
    
    // constructor for property binding
   public Rock(Monkey m, Image img){
        
        rimV = new ImageView(img);
        rimV.setFitHeight(30);
        rimV.setFitWidth(30);
        rimV.setX(m.getX() + m.getW()/4);
        rimV.setY(m.getY());
        path2= new Line(rimV.getX() + m.getW()/4, rimV.getY()+50, rimV.getX() + m.getW()/4, 1080);
        p2 = new PathTransition(Duration.millis(3000), path2, rimV);
        p2.setCycleCount(1); 
      //  p2.delayProperty();
        p2.play();
    }

     
      public void addToPane(Pane pa)
    {
       pa.getChildren().add(rimV);
   }

    public void removefromPane(Pane pa)
   {
        pa.getChildren().remove(rimV);
    }
}