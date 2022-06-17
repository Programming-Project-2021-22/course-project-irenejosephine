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

    private Label username, password, email, phone, title, login ;
    private TextField inputusername, inputemail, inputphone;
    private PasswordField inputpassword;
    private Font font;
    private Button singin, register;
    private ImageView img;
    private String set_username, set_password, set_email, set_phone;

    public RegisterPane(App nA){
    	App application = nA;
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
        singin= new Button("Sing in");

        title.setFont(font);

        GridPane.setHalignment(username, HPos.RIGHT); //alignment in the cell
        username.setFont(font);

        GridPane.setHalignment(password, HPos.RIGHT);
        password.setFont(font);

        GridPane.setHalignment(email, HPos.RIGHT); //alignment in the cell
        email.setFont(font);

        GridPane.setHalignment(phone, HPos.RIGHT);
        phone.setFont(font);

        register.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                set_username=inputusername.getText();
                System.out.println(set_username);
                set_password=inputpassword.getText();
                System.out.println(set_password);
                set_email=inputemail.getText();
                System.out.println(set_email);
                set_phone=inputphone.getText();
                System.out.println(set_phone);
                if(set_username.isEmpty() || set_password.isEmpty() ){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText(null);
                    alert.setContentText("Please insert a username and a password");
                    alert.showAndWait();
                }else{
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
        });

        singin.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Stage stage = (Stage) singin.getScene().getWindow();
                stage.close();
                Stage stage2 = new Stage();
                        Scene scene = new Scene(new LoginPane(application), 800, 600);
                        stage2.setTitle("Login");
                        stage2.setScene(scene);
                        stage2.show();
            }
        });

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
        add(singin, 1, 5); // column, row
    }
}
