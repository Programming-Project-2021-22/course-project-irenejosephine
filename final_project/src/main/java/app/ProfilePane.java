package app;

import com.google.gson.Gson;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.apache.commons.lang.math.NumberUtils;

import java.io.*;

/**
 * This class generates a scene where the user can access and update its personal data
 * @author Josephine Sacchetto frontend
 * @author Irene Avezzù connection frontend-backend
 */
public class ProfilePane extends HBox {
    private App application;
    private int index;
    private Font font;
    private ImageView logo, profileView;
    private Image profile;
    private TextField inputUsername, inputPassword, inputEmail, inputPhone, inputPath;
    private TextArea inputDescription;
    private Label path, username, password, email, phone, description;
    private Button removeAccount, editAccount, logout, done;
    private HBox top;
    private VBox right, left;
    private String set_username, set_password, set_email, set_phone, set_description, set_photo;

    /**
     * This method is a isEmailValid() support method and counts the occurrences of a character inside a String.
     * In this case it is used to count the occurrence of the character @
     * @author Josephine Sacchetto
     * @param str string in which to search for the character
     * @param ch character to look for
     * @return true if the character occurs only once, otherwise false
     */

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
        profile = new Image(getApplication().getWardrobe(index).getPicture());
        profileView = new ImageView(profile);
        profileView.setFitHeight(150);
        profileView.setPreserveRatio(true);

        font = new Font("Times New Roman",24);

        //insert in the fields what the user had entered when they registered
        inputUsername = new TextField(getApplication().getWardrobe(index).getUsername());
        inputPassword = new TextField(getApplication().getWardrobe(index).getPassword());
        inputEmail = new TextField(getApplication().getWardrobe(index).getEmail());
        inputPhone = new TextField(getApplication().getWardrobe(index).getPhone());
        inputDescription = new TextArea(getApplication().getWardrobe(index).getDescription());
        inputPath = new TextField();

        path = new Label("Insert the path of the profile photo:");
        username = new Label("Username: ");
        password = new Label("Password: ");
        email = new Label("E-mail: ");
        phone = new Label("Phone number: ");
        description = new Label("Status: ");
        removeAccount = new Button("Delete Account");
        removeAccount.setStyle("-fx-background-color: orange");
        editAccount = new Button("Edit Account");
        editAccount.setStyle("-fx-background-color: orange");
        logout = new Button("Logout");
        logout.setStyle("-fx-background-color: orange");
        done = new Button ("Done");
        done.setStyle("-fx-background-color: orange");

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

        //layout
        top=new HBox(logo);
        top.setAlignment(Pos.TOP_LEFT);

        right = new VBox(profileView, description, inputDescription,path, inputPath, done);
        right.setAlignment(Pos.CENTER);
        right.setSpacing(5);

        left = new VBox(username, inputUsername, password, inputPassword,email, inputEmail, phone, inputPhone, editAccount, removeAccount, logout);
        left.setAlignment(Pos.CENTER_LEFT);
        left.setSpacing(15);

        setSpacing(50);
        getChildren().addAll(top, left, right);

        //event
        removeAccount.setOnAction(this::removeAccountEvent);
        editAccount.setOnAction(this::editAccountEvent);
        logout.setOnAction(this::logoutEvent);
        done.setOnAction(this::doneEvent);

    }

    /**
     * Event handler for when the logo image is clicked.
     * Return to the HomePane
     * @param event
     */
    public void logoEvent(MouseEvent event){
        Stage stage = (Stage) logo.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new HomePane(getApplication(), index), 800, 600);
        stage2.setTitle("Home");
        stage2.setScene(scene);
        stage2.show();
    }

    /**
     * Event handler for when the removeAccount button is clicked.
     * Return to the LoginPane and delete the account
     * @param event
     */
    public void removeAccountEvent(ActionEvent event){
        getApplication().removeUser(index);
        updateApp();
        Stage stage = (Stage) removeAccount.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new LoginPane(getApplication()), 500, 400);
        stage2.setTitle("Login");
        stage2.setScene(scene);
        stage2.show();
    }

    /**
     * Event handler for when the editAccount button is clicked.
     * Set the TextFields as editable
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
        logout.setVisible(false);
        done.setVisible(true);
        path.setVisible(true);
        inputPath.setVisible(true);
        profileView.setVisible(false);
        right.setAlignment(Pos.TOP_CENTER);
    }
    /**
     * Event handler for when the logout button is clicked.
     * returns to the login page
     * @param event
     */
    private void logoutEvent(ActionEvent event) {
        updateApp();
        Stage stage = (Stage) logout.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new LoginPane(getApplication()), 500, 400);
        stage2.setTitle("Login");
        stage2.setScene(scene);
        stage2.show();
    }

    /**
     * Event handler for when the done button is clicked.
     * Set the new value of username, password, email, phone number and description based on the value inserted by
     * the user and return to the profilePane after setting as uneditable the TextFields
     * @param event
     */
    public void doneEvent (ActionEvent event){
        set_username=inputUsername.getText();
        set_password=inputPassword.getText();
        set_email=inputEmail.getText();
        set_phone=inputPhone.getText();
        set_description=inputDescription.getText();
        set_photo = inputPath.getText();

        String alertText = "";
        if(!isUserValid(set_username) || !isPswValid(set_password)){
            alertText+="\nPlease insert a username (max. 10 character min. 5 character)\nand a password (max. 10 charactermin. 5 character containing minimum 1 letter 1 digit 1 special character (\"@\"\"#\"\"%\"\"$\"\"!\"\"?\"))";
        }
        if (!isEmailValid(set_email)){
            alertText+=("\nE-mail is not valid");
        }
        if (!isPhoneValid(set_phone)){
            alertText+=("\nPhone number is not valid");
        }
        if (!isPictureValid(set_photo)){
            alertText+=("\nThe picture path is not valid");
        }

        if (isUserValid(set_username) && isPswValid(set_password) && isEmailValid(set_email)&& isPhoneValid(set_phone) && isPictureValid(set_photo)){
            getApplication().getWardrobe(index).setUsername(set_username);
            getApplication().getWardrobe(index).setPassword(set_password);
            getApplication().getWardrobe(index).setEmail(set_email);
            getApplication().getWardrobe(index).setPhone(set_phone);
            getApplication().getWardrobe(index).setDescription(set_description);
            if (inputPath.getText() != ""){
                getApplication().getWardrobe(index).setPicture(set_photo);
            }

            updateApp();

            Stage stage = (Stage) done.getScene().getWindow();
            stage.close();
            Stage stage2 = new Stage();
            Scene scene = new Scene(new ProfilePane(getApplication(), index), 800, 600);
            stage2.setTitle("Profile");
            stage2.setScene(scene);
            stage2.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText(alertText);
            alert.showAndWait();
        }

    }
    /**
     * This method is a isEmailValid() support method and counts the occurrences of a character inside a String.
     * In this case it is used to count the occurrence of the character @
     * @author Josephine Sacchetto
     * @param str string in which to search for the character
     * @param ch character to look for
     * @return true if the character occurs only once, otherwise false
     */
    private static boolean countOccurrences(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == ch) {
                counter++;
            }
        }
        if(counter!=1) {
            return false;
        }else
            return true;
    }
    /**
     * This method is used to check whether the user entered is valid.
     * The user must contain minimum 5 maximum 10 characters
     * @author Josephine Sacchetto
     * @param user entered user to be validated
     * @return true if the user is valid, false if the user is empty or does not correspond to the requirements
     */
    public static boolean isUserValid(String user) {
        if (user.isEmpty()){
            return false;
        }
        else if (user.length()<=10 && user.length()>=5){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * This method is used to check whether the password entered is valid.
     * The password must contain at least:
     * one letter, one number, a special character and is minimum 5 maximum 10 characters long
     * @author Josephine Sacchetto
     * @param psw entered password to be validated
     * @return true if the password is valid, false if the password is empty or does not correspond to the requirements
     */
    public static boolean isPswValid(String psw) {
        if (psw.isEmpty()){
            return false;
        }
        else if (psw.contains("1") || psw.contains("2") || psw.contains("3") || psw.contains("4") || psw.contains("5") || psw.contains("6") || psw.contains("7") || psw.contains("8") || psw.contains("9")  ){
            if (psw.contains("a") || psw.contains("b") || psw.contains("c") || psw.contains("d") || psw.contains("e") || psw.contains("f") || psw.contains("g") || psw.contains("h") || psw.contains("i") || psw.contains("j") || psw.contains("k") || psw.contains("l") || psw.contains("m") || psw.contains("n") || psw.contains("o") || psw.contains("p") || psw.contains("q") || psw.contains("r") || psw.contains("s") || psw.contains("t") || psw.contains("u") || psw.contains("v") || psw.contains("w") || psw.contains("x") || psw.contains("y") || psw.contains("z") ){
                if (psw.contains("@") || psw.contains("#") || psw.contains("%") || psw.contains("$") || psw.contains("!") || psw.contains("?")) {
                    if (psw.length() <= 10 && psw.length() >= 5){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * This method is used to check whether the email entered is valid.
     * The email must contain at least:
     * one "@", one ore more "."
     * must not contain:
     * "@." or ".@"
     * can not start with:
     * "." or "@"
     * can not end with:
     * "." or "@"
     * @author Josephine Sacchetto
     * @param email entered email to be validated
     * @return true if the email is valid or empty, false if the email does not correspond to the requirements
     */
    public static boolean isEmailValid(String email) {
        if (email.isEmpty()){
            return true;
        }
        else if(countOccurrences(email,'@')&& email.contains("@")&&email.contains(".")&& (!email.contains("@.")) && (!email.contains(".@")) && (!email.startsWith("@")) && (!email.startsWith(".")) && (!email.endsWith("@"))  &&(!email.endsWith("."))){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * This method is used to check whether the phone number entered is valid.
     * the phone number must contain 10 numbers
     * @author Josephine Sacchetto
     * @param phone entered phone number to be validated
     * @return true if the phone number is valid or empty, false if the phone number does not correspond to the requirements
     */
    public static boolean isPhoneValid(String phone) {
        if (phone.isEmpty()){
            return true;
        }
        else if (phone.length()==10 && NumberUtils.isNumber(phone)){  //isNumber() The NumberUtils class method accepts the input string as a parameter and checks whether it is a number
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * This method is used to check if the path is valid.
     * @author Josephine Sacchetto
     * @param photo entered phone number to be validated
     * @return true if the path is valid or empty, false if not
     */
    private boolean isPictureValid(String photo) {
        if (photo.isEmpty()){
            return true;
        }
        else {
            photo = "src/main/resources/"+photo;
            File f = new File(photo);
            if (f.exists() && !f.isDirectory()){
                return true;
            }
            else{
                return false;
            }
        }
    }

    /**
     * Updates the json file that keeps a backup of the application that is used as "database"
     */
    public void updateApp (){
        //obj->json
        Gson gson = new Gson ();
        String jsonString = gson.toJson(getApplication());

        String path = "src\\main\\resources\\json\\app.json";

        //write into the file
        FileWriter fw = null;
        String stringToWrite = jsonString;
        try {
            fw = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write(stringToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //json->obj
        jsonString = readFromFile();
        App nA = gson.fromJson(jsonString, App.class);

        setApplication(nA);
    }

    /**
     * Support metod for uploadApp, read the context of a file and converts it into a string that is returned
     * @return
     */
    public String readFromFile(){
        String s="";
        //READ from a file using BufferedReader
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\json\\app.json"));
            String line = reader.readLine();
            while (line!=null){
                s= s + line;
                line=reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    /**
     * Getter of application
     * @return application
     */
    public App getApplication(){
        return application;
    }

    /**
     * Setter of application
     * @param nA
     */
    public void setApplication(App nA){
        application=nA;
    }
    /**
     * Getter of index
     * @return index
     */
    public int getIndex(){
        return index;
    }

}
