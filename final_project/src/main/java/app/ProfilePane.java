package app;

import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class generates a scene where the user can access and update its personal data
 * @author Josephine Sacchetto
 *
 */
public class ProfilePane extends HBox {
	private String new_username;
	private String new_password;
	private String new_photo;
    private App application;
    private int index;


    public ProfilePane(App ap, int i){
    	application = ap;
    	index = i;

        ImageView logo = new ImageView("images/Logo.png");
        logo.setPickOnBounds(true); // allows click on transparent areas
        logo.setOnMouseClicked((MouseEvent e) -> {
                Stage stage = (Stage) logo.getScene().getWindow();
                stage.close();
                Stage stage2 = new Stage();
                Scene scene = new Scene(new HomePane(application, index), 800, 600);
                stage2.setTitle("Home");
                stage2.setScene(scene);
                stage2.show();
            });

        Image profile = new Image("profile.png");
        ImageView view = new ImageView(profile);
        view.setFitHeight(150);
        view.setPreserveRatio(true);

        Font font = new Font(20);
        //inserire quello che l'utente aveva immesso quando si è registrato
        TextField inputusername = new TextField(application.getWardrobe(index).getUsername());
        TextField inputpassword = new TextField(application.getWardrobe(index).getPassword());
        TextField inputemail = new TextField(application.getWardrobe(index).getEmail());
        TextField inputphone = new TextField(application.getWardrobe(index).getPhone());
        TextArea inputdescription = new TextArea(application.getWardrobe(index).getDescription());
        TextField inputpath = new TextField();
        Label path = new Label("Insert the path of the profile photo:");
        Label username = new Label("Username: ");
        Label password = new Label("Password: ");
        Label email = new Label("E-mail: ");
        Label phone = new Label("Phone number: ");
        Label description = new Label("Status: ");
        Button removeaccount = new Button("Delete Account");
        Button editaccount = new Button("Edit Account");
        Button done = new Button ("Done");

        inputusername.setEditable(false);
        inputpassword.setEditable(false);
        inputemail.setEditable(false);
        inputphone.setEditable(false);
        inputdescription.setEditable(false);

        username.setFont(font);
        password.setFont(font);
        email.setFont(font);
        phone.setFont(font);
        description.setFont(font);
        path.setFont(font);

        inputdescription.setMaxWidth(300);
        inputdescription.setStyle("-fx-background-color: -fx-control-inner-background;-fx-background-insets: 0;-fx-padding: 1 3 1 3;");
        inputdescription.setWrapText(true);
        inputdescription.setPrefHeight(80);  //sets height of the TextArea to 400 pixels
        inputdescription.setPrefWidth(300);

        done.setVisible(false);

        inputpath.setVisible(false);
        path.setVisible(false);

        setStyle("-fx-background-color: #FFE5CC");
        setAlignment(Pos.CENTER);

        HBox top=new HBox(logo);
        top.setAlignment(Pos.TOP_LEFT);

        VBox left = new VBox(view, description,inputdescription,path,inputpath, done);
        left.setAlignment(Pos.CENTER);
        left.setSpacing(5);

        VBox right = new VBox(username,inputusername,password,inputpassword,email, inputemail, phone, inputphone, removeaccount,editaccount);
        right.setAlignment(Pos.CENTER_LEFT);
        right.setSpacing(15);

        setSpacing(50);
        getChildren().addAll(top,right,left);

        removeaccount.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
            	application.removeUser(index);
                Stage stage = (Stage) removeaccount.getScene().getWindow();
                stage.close();
                    Stage stage2 = new Stage();
                        Scene scene = new Scene(new LoginPane(application), 800, 600);
                        stage2.setTitle("Login");
                        stage2.setScene(scene);
                        stage2.show();
            }
        });


        editaccount.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                inputusername.setEditable(true);
                inputpassword.setEditable(true);
                inputemail.setEditable(true);
                inputphone.setEditable(true);
                inputdescription.setEditable(true);
                removeaccount.setVisible(false);
                editaccount.setVisible(false);
                done.setVisible(true);
                path.setVisible(true);
                inputpath.setVisible(true);
                view.setVisible(false);
                //left.setSpacing(10);
                left.setAlignment(Pos.TOP_CENTER);

            }
        });

        done.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                //fare il get di quello che viene passato in input e un controllo se non viene inserito niente( in realta quando non inserisce niente restituisce le stringe iniziali) e se il path è accettabile
            	application.getWardrobe(index).setUsername(inputusername.getText());
            	application.getWardrobe(index).setPassword(inputpassword.getText());
            	application.getWardrobe(index).setEmail(inputemail.getText());
            	application.getWardrobe(index).setDescription(inputdescription.getText());
                new_photo=inputpath.getText();
                System.out.println(new_photo);

                //controllo su quello che viene inserito?

                inputusername.setEditable(false);
                inputpassword.setEditable(false);
                inputemail.setEditable(false);
                inputphone.setEditable(false);
                inputdescription.setEditable(false);
                removeaccount.setVisible(true);
                editaccount.setVisible(true);
                done.setVisible(false);
                path.setVisible(false);
                inputpath.setVisible(false);
                view.setVisible(true);
                left.setAlignment(Pos.CENTER);

                //come cambiare la photo di default?

                // Image profile = new Image("\""+new_photo+"\"");
                // ImageView view = new ImageView(profile);
                // view.setFitHeight(150);
                // view.setPreserveRatio(true);

            }
        });

    }
}
