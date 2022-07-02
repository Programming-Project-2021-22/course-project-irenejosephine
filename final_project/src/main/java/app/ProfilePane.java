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
 */
public class ProfilePane extends HBox {
	private String newUsername, newPassword, newPhoto;
    private App application;
    private int index;
    private ImageView logo, profileView;
    private Image profile;
    private TextField inputUsername, inputPassword, inputEmail, inputPhone, inputPath;
    private TextArea inputDescription;
    private Label path, username, password, email, phone, description;
    private Button removeAccount, editAccount, done;
    private HBox top;
    private VBox left, right;

    /**
     * Constructor of the object
     * @param application of type App
     * @param index is the index in the App arrays from where the wardrobe and all its information is loaded
     */
    public ProfilePane(App application, int index){
        //import of the data passed as parameter from the previous pane
        this.application = application;
        this.index = index;

        //logo image and event handler
        logo = new ImageView("images/Logo.png");
        logo.setPickOnBounds(true); // allows click on transparent areas
        logo.setOnMouseClicked(this::logoEvent);//MouseEvent e)

        //profile image
        profile = new Image("images/profile.png");
        profileView = new ImageView(profile);
        profileView.setFitHeight(150);
        profileView.setPreserveRatio(true);

        Font font = new Font(20);
        //inserire quello che l'utente aveva immesso quando si è registrato
        inputUsername = new TextField(application.getWardrobe(index).getUsername());
        inputPassword = new TextField(application.getWardrobe(index).getPassword());
        inputEmail = new TextField(application.getWardrobe(index).getEmail());
        inputPhone = new TextField(application.getWardrobe(index).getPhone());
        inputDescription = new TextArea(application.getWardrobe(index).getDescription());
        inputPath = new TextField();
        path = new Label("Insert the path of the profile photo:");
        username = new Label("Username: ");
        password = new Label("Password: ");
        email = new Label("E-mail: ");
        phone = new Label("Phone number: ");
        description = new Label("Status: ");
        removeAccount = new Button("Delete Account");
        editAccount = new Button("Edit Account");
        done = new Button ("Done");

        inputUsername.setEditable(false);
        inputPassword.setEditable(false);
        inputEmail.setEditable(false);
        inputPhone.setEditable(false);
        inputDescription.setEditable(false);

        username.setFont(font);
        password.setFont(font);
        email.setFont(font);
        phone.setFont(font);
        description.setFont(font);
        path.setFont(font);

        inputDescription.setMaxWidth(300);
        inputDescription.setStyle("-fx-background-color: -fx-control-inner-background;-fx-background-insets: 0;-fx-padding: 1 3 1 3;");
        inputDescription.setWrapText(true);
        inputDescription.setPrefHeight(80);  //sets height of the TextArea to 400 pixels
        inputDescription.setPrefWidth(300);

        done.setVisible(false);

        inputPath.setVisible(false);
        path.setVisible(false);

        setStyle("-fx-background-color: #FFE5CC");
        setAlignment(Pos.CENTER);

        top=new HBox(logo);
        top.setAlignment(Pos.TOP_LEFT);

        left = new VBox(profileView, description, inputDescription,path, inputPath, done);
        left.setAlignment(Pos.CENTER);
        left.setSpacing(5);

        right = new VBox(username, inputUsername,password, inputPassword,email, inputEmail, phone, inputPhone, removeAccount, editAccount);
        right.setAlignment(Pos.CENTER_LEFT);
        right.setSpacing(15);

        setSpacing(50);
        getChildren().addAll(top,right,left);

        //event handlers
        removeAccount.setOnAction(this::removeAccountEvent);
        editAccount.setOnAction(this::editAccountEvent);
        done.setOnAction(this::doneEvent);

    }

    /**
     * Event handler for when the logo image is clicked
     * return to the HomePane
     * @param event
     */
    public void logoEvent(MouseEvent event){
        Stage stage = (Stage) logo.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new HomePane(application, index), 800, 600);
        stage2.setTitle("Home");
        stage2.setScene(scene);
        stage2.show();
    }

    /**
     * Event handler for when the removeAccount button is clicked
     * return to the LoginPane
     * @param event
     */
    public void removeAccountEvent(ActionEvent event){
        application.removeUser(index);
        Stage stage = (Stage) removeAccount.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new LoginPane(application), 800, 600);
        stage2.setTitle("Login");
        stage2.setScene(scene);
        stage2.show();
    }

    /**
     * Event handler for when the editAccount button is clicked
     * set  the TextFiels as editable
     * @param event
     */
    public void editAccountEvent (ActionEvent event){
        inputUsername.setEditable(true);
        inputPassword.setEditable(true);
        inputEmail.setEditable(true);
        inputPhone.setEditable(true);
        inputDescription.setEditable(true);
        removeAccount.setVisible(false);
        editAccount.setVisible(false);
        done.setVisible(true);
        path.setVisible(true);
        inputPath.setVisible(true);
        profileView.setVisible(false);
        //left.setSpacing(10);
        left.setAlignment(Pos.TOP_CENTER);
    }

    /**
     * Event handler for when the done button is clicked
     * set the new value of username, password, email, phone number and description based on the value inserted by
     * the user and return to the profilePane after setting as uneditable the TextFiels
     * @param event
     */
    public void doneEvent (ActionEvent event){
        application.getWardrobe(index).setUsername(inputUsername.getText());
        application.getWardrobe(index).setPassword(inputPassword.getText());
        application.getWardrobe(index).setEmail(inputEmail.getText());
        application.getWardrobe(index).setPhone(inputPhone.getText());
        application.getWardrobe(index).setDescription(inputDescription.getText());
        newPhoto = inputPath.getText();

        //controllo su quello che viene inserito?
        inputUsername.setEditable(false);
        inputPassword.setEditable(false);
        inputEmail.setEditable(false);
        inputPhone.setEditable(false);
        inputDescription.setEditable(false);
        removeAccount.setVisible(true);
        editAccount.setVisible(true);
        done.setVisible(false);
        path.setVisible(false);
        inputPath.setVisible(false);
        profileView.setVisible(true);
        left.setAlignment(Pos.CENTER);

        //come cambiare la photo di default?

        // Image profile = new Image("\""+new_photo+"\"");
        // ImageView profileView = new ImageView(profile);
        // profileView.setFitHeight(150);
        // profileView.setPreserveRatio(true);
    }
}
