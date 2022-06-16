import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application{
	App newApp = new App();
	
    public void start(Stage primaryStage){
        Scene scene = new Scene(new LoginPane(newApp), 800, 600);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)  {
        launch(args);
     }
}