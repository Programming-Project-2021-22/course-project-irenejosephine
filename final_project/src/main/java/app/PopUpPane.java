package app;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class open a scene where the user can see the details of the selected item
 * @author Josephine Sacchetto
 *
 */
public class PopUpPane extends HBox{
    public PopUpPane(){

        //mi faccio passare all'interno del costruttor le variabili neccessarie

        Image img = new Image("images/Wardrobe.jpg");
        ImageView view = new ImageView(img);
        view.setFitHeight(270);
        view.setFitWidth(270);
        view.setPreserveRatio(true);


        Label description = new Label ("Description:");

        Button delte = new Button("Delte");
        Button edit = new Button("Edit");  //?

        HBox action = new HBox(delte,edit);
        action.setSpacing(30);
        action.setAlignment(Pos.BASELINE_CENTER);

        VBox details = new VBox(view,description,action);
        details.setSpacing(20);
        details.setAlignment(Pos.BASELINE_CENTER);

        getChildren().addAll(details);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #FFE5CC");


    }

}
