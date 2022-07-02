package app;

import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class generates a register scene where the user can create a new account (unless its username already exist)
 * @author Josephine Sacchetto
 *
 */
public class RegisterPane extends GridPane{
    //all elements that are necessary in this pane are created
    private Label username, password, email, phone, title, login ;
    private TextField inputusername, inputemail, inputphone;
    private PasswordField inputpassword;
    private Font font;
    private Button signIn, register;
    private ImageView img;
    private String set_username, set_password, set_email, set_phone;
    private App application;

    /**
     * Constructor of the object
     * @param application of type App
     */
    public RegisterPane(App application){
        this.application = application;
        title= new Label("Register");
        font = new Font(24);
        img = new ImageView("images/Profile.png");
        username = new Label("Username:");
        inputusername = new TextField();
        password = new Label("Password:");
        inputpassword = new PasswordField();
        email = new Label("E-mail:");
        inputemail = new TextField();
        phone = new Label("Phone:");
        inputphone = new TextField();
        register= new Button("Register");
        login=new Label("Still have an account? ");
        signIn = new Button("Sing in");

        title.setFont(font);

        GridPane.setHalignment(username, HPos.RIGHT); //alignment in the cell
        username.setFont(font);

        GridPane.setHalignment(password, HPos.RIGHT);
        password.setFont(font);

        GridPane.setHalignment(email, HPos.RIGHT); //alignment in the cell
        email.setFont(font);

        GridPane.setHalignment(phone, HPos.RIGHT);
        phone.setFont(font);

        register.setOnAction(this::registerEvent);
        signIn.setOnAction(this::signInEvent);

        setStyle("-fx-background-color: white");
        setAlignment(Pos.CENTER); //alignment of the grid in the scene
        setHgap(20); // horizontal gap between cells
        setVgap(10);

        add(title, 1, 0); // column, row
        add(img,0,0);
        add(username, 0, 1);
        add(inputusername, 1, 1);
        add(password, 0, 2);
        add(inputpassword, 1, 2); // column, row
        add(email, 0, 3);
        add(inputemail, 1, 3); // column, row
        add(phone, 0, 4);
        add(inputphone, 1, 4); // column, row
        add(register,2,4);
        add(login, 0, 5); // column, row
        add(signIn, 1, 5); // column, row
    }

    /**
     * Event handler for when the button register is clicked
     * creates the new account if all the necessary info are present otherwise generates an allert
     * @param event
     */
    public void registerEvent(ActionEvent event){
        set_username=inputusername.getText();
        set_password=inputpassword.getText();
        set_email=inputemail.getText();
        set_phone=inputphone.getText();
        if(set_username.isEmpty() || set_password.isEmpty() ){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please insert a username and a password");
            alert.showAndWait();
        }else {
            application.createNewUser(set_username, set_password, set_email, set_phone);
            Stage stage = (Stage) register.getScene().getWindow();
            stage.close();
            Stage stage2 = new Stage();
            Scene scene = new Scene(new LoginPane(application), 800, 600);
            stage2.setTitle("Login");
            stage2.setScene(scene);
            stage2.show();
        }
    }

    /**
     * Event handler for when the button signIn is clicked
     * return to LoginPane
     * @param event
     */
    public void signInEvent(ActionEvent event){
        Stage stage = (Stage) signIn.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new LoginPane(application), 800, 600);
        stage2.setTitle("Login");
        stage2.setScene(scene);
        stage2.show();
    }

}
