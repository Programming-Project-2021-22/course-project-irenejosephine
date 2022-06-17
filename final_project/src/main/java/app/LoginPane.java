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
 * This class generates a scene where the user can login into his/hers account
 * @author Josephine Sacchetto
 */
public class LoginPane extends GridPane{
	private Label username, password, title, register ;
	private TextField inputusername;
	private Font font;
	private Button singup,login;
	private PasswordField inputpassword;
	private ImageView img;
	private App application;
	private String usn, psw;

	public LoginPane(App nA){
		application = nA;
		title= new Label("Login");
		img = new ImageView("images/Profile.png");
		font = new Font(24);
		username = new Label("Username:");
		inputusername = new TextField();
		password = new Label("Password:");
		inputpassword = new PasswordField();
		login= new Button("Login");
		register=new Label("Still no account? ");
		singup= new Button("Sing up");

		title.setFont(font);

		GridPane.setHalignment(username, HPos.RIGHT); //alignment in the cell
		username.setFont(font);

		GridPane.setHalignment(password, HPos.RIGHT);
		password.setFont(font);

		login.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		        usn = inputusername.getText();
		        psw = inputpassword.getText();
		        if(application.checkUsrAndPsw(usn, psw)==true){
		            Stage stage = (Stage) login.getScene().getWindow();
		            stage.close();
		            Stage stage2 = new Stage();
		                    Scene scene = new Scene(new HomePane(application, application.getUserIndex(usn)), 800, 600);
		                    stage2.setTitle("Home");
		                    stage2.setScene(scene);
		                    stage2.show();
		        }
		        else{
		        	/*
		        	 * if the username of pasword are not correct a warning dialog is open, at the same time the
		        	 * input on the textfiel is canceled so the user can type again its credentials
		        	 */
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Please insert the correct credentials");
					alert.showAndWait();
					inputpassword.clear();
					inputusername.clear();
		        }
		    }
		});
		singup.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {
		        Stage stage = (Stage) singup.getScene().getWindow();
		        stage.close();
		        Stage stage2 = new Stage();
		                Scene scene = new Scene(new RegisterPane(application), 800, 600);
		                stage2.setTitle("Register");
		                stage2.setScene(scene);
		                stage2.show();
		    }
		});

		setAlignment(Pos.CENTER); //alignment of the grid in the scene
		setHgap(20); // horizontal gap between cells
		setVgap(10);
		setStyle("-fx-background-color: white");

		//set the layout (element, column, row)
		add(title, 1, 0);
		add(img,0,0);
		add(username, 0, 1);
		add(inputusername, 1, 1);
		add(password, 0, 2);
		add(inputpassword, 1, 2);
		add(login, 2, 2);
		add(register, 0, 3);
		add(singup, 1, 3);
	}

}
