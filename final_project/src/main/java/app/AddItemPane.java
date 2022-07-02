package app;

import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class creates a scene where the user can add an item to its wardrobe by creating it from scratch or by
 * loading it from a file (json)
 * @author Josephine Sacchetto
 *
 */
public class AddItemPane extends HBox {
    private String inputColor, inputSeason, inputOccasion, inputFavorite, inputCategory, inputType, inputPath, inputDescription, inputFilePath;
    private int index;
    private App application;
    private Label path, title, color, season, occasion, favorite, category, type, description, filePath;
    private Font font;
    private TextField chooseImagePath, chooseDescription, chooseFilePath;
    private Button doneOptions, doneFromFile, optionOptions, optionFromFile; //option 1 and 2 bottoni per import da file o creazione item
    private ComboBox selectColor, selectSeason, selectOccasion, selectFavorite, selectCategory, selectType;
    private ImageView logo;
    private VBox imagePathVB, colorVB, seasonVB, occasionVB, favoriteVB, categoryVB, typeVB, descriptionVB, showOptions, showFromFile, button, filePathVB;
    private HBox head, row1, row2, row3, row4, row5, favouriteHB, head2, row6, row7;
    private RadioButton yes, no;
    private ToggleGroup tg;

    //set costant ComboBox
    public void addColorCategory() {
    	selectColor.getItems().add("White");
        selectColor.getItems().add("Black");
        selectColor.getItems().add("Pink");
        selectColor.getItems().add("Blue");
        selectColor.getItems().add("Red");
        selectColor.getItems().add("Yellow");
        selectColor.getItems().add("Green");
        selectColor.getItems().add("Beige");
        selectColor.getItems().add("Brown");
        selectColor.getItems().add("Orange");
    }
    public void addSeasonCategory() {
    	selectSeason.getItems().add("Winter");
    	selectSeason.getItems().add("Spring");
    	selectSeason.getItems().add("Summer");
    	selectSeason.getItems().add("Fall");
    }
    public void addOccasionCategory() {
    	selectOccasion.getItems().add("Formal");
        selectOccasion.getItems().add("EveryDay");
        selectOccasion.getItems().add("Semiformal");
        selectOccasion.getItems().add("Sporty");
    }
    /*public void addFavouriteCategory() {
    	selectFavorite.getItems().add("Yes");
        selectFavorite.getItems().add("No");
    }*/
    public void addTypeCategory() {
    	selectCategory.getItems().add("Tops");
        selectCategory.getItems().add("Bottoms");
        selectCategory.getItems().add("Dresses");
        selectCategory.getItems().add("Accessories");
    }

    //set non costant ComboBox
    public void addTopCategory() {
    	selectType.getItems().clear();
    	selectType.getItems().add("TShirt");
        selectType.getItems().add("Sweater");
        selectType.getItems().add("SweatshirtAndHoodie");
        selectType.getItems().add("TopAndBody");
        selectType.getItems().add("JacketAndCoat");
        selectType.getItems().add("TankTop");
    }
    public void addBottomCategory() {
    	selectType.getItems().clear();
    	selectType.getItems().add("Skirt");
        selectType.getItems().add("Jeans");
        selectType.getItems().add("Trouser");
        selectType.getItems().add("Shorts");
    }
    public void addDressCategory() {
    	selectType.getItems().clear();
        selectType.getItems().add("Longs");
        selectType.getItems().add("Shorts");
    }
    public void addAccessorizeCategory() {
    	selectType.getItems().clear();
    	selectType.getItems().add("Jewelry");
        selectType.getItems().add("Hat");
        selectType.getItems().add("Belt");
        selectType.getItems().add("Glasses");
        selectType.getItems().add("Scarf");
        selectType.getItems().add("Gloves");
        selectType.getItems().add("Purse");
        selectType.getItems().add("Shoes");
        selectType.getItems().add("ForTheHair");
    }

    public AddItemPane(App application, int index){
    	this.application = application;
    	this.index = index;

        path = new Label("Insert the path of the item's photo");
        title = new Label("Add your items");
        font = new Font(24);
        title.setFont(font);
        chooseImagePath = new TextField();
        doneOptions = new Button("Done");
        color = new Label("Color:");
        description = new Label("Add description: ");
        chooseDescription = new TextField();
        selectColor = new ComboBox();
        season = new Label("Season:");
        selectSeason = new ComboBox();
        occasion = new Label("Occasion:");
        selectOccasion = new ComboBox();
        favorite = new Label("Favorite:");
        //selectFavorite = new ComboBox();
        category = new Label("Category:");
        selectCategory = new ComboBox();
        /*selectCategory.getItems().add("Tops");
        selectCategory.getItems().add("Bottoms");
        selectCategory.getItems().add("Dresses");
        selectCategory.getItems().add("Accessories");
        selectCategory.setVisible(true);*/
        type = new Label();
        selectType = new ComboBox();
        optionOptions = new Button("Frome scratch");
        optionFromFile = new Button("From file");
        doneFromFile = new Button("Done");
        filePath = new Label("Insert name of JSON file:");
        chooseFilePath = new TextField();
        yes = new RadioButton("Yes");
        yes.setSelected(false);
        no = new RadioButton("No");
        no.setSelected(true);
        tg = new ToggleGroup();
        yes.setToggleGroup(tg);
        no.setToggleGroup(tg);

        addColorCategory();
        addSeasonCategory();
        addOccasionCategory();
        addTypeCategory();
        //addFavouriteCategory();

        //event handlers
        selectCategory.setOnAction(this::categoryEvent);
        doneOptions.setOnAction(this::doneOptionsEvent);
        doneFromFile.setOnAction(this::doneFromFileEvent);

        logo = new ImageView("images/Logo.png");
        logo.setPickOnBounds(true); // allows click on transparent areas
        logo.setOnMouseClicked(this::logoEvent);

        //VBox for pane fromOptions
        imagePathVB = new VBox(path, chooseImagePath);
        colorVB = new VBox(color, selectColor);
        seasonVB = new VBox(season, selectSeason);
        occasionVB = new VBox(occasion, selectOccasion);
        favouriteHB = new HBox (yes, no);
        favouriteHB.setSpacing(10);
        favoriteVB = new VBox(favorite, favouriteHB);
        //favoriteVB = new VBox(favorite, selectFavorite);
        categoryVB = new VBox(category, selectCategory);
        typeVB = new VBox(type, selectType);
        descriptionVB = new VBox(description, chooseDescription);

        //HBox for pane fromOptions
        head = new HBox(logo,title);
        head.setAlignment(Pos.CENTER);
        head.setSpacing(30);

        //button to choose between from options or from file
        row1 = new HBox(optionOptions, optionFromFile);
        row1.setSpacing(30);
        row1.setAlignment(Pos.CENTER);
        //selectors and labels for color, season, occasion and favourite
        row2 = new HBox(colorVB, seasonVB, occasionVB, favoriteVB);
        row2.setSpacing(30);
        row2.setAlignment(Pos.CENTER);
        //selectors and labels for category(Top, Bottom, ...), type of Item (Tshirt, long dress, jeans,...), image path and description
        row3 = new HBox(categoryVB, typeVB, imagePathVB, descriptionVB);
        row3.setSpacing(30);
        row3.setAlignment(Pos.CENTER);
        //button to create the item from options
        row4 = new HBox(doneOptions);
        row4.setAlignment(Pos.CENTER);

        //VBox and HBox for pane fromFile
        //selectors and labels for fileName
        filePathVB = new VBox(filePath, chooseFilePath);

        row5= new HBox(categoryVB, filePathVB);
        row5.setSpacing(30);
        row5.setAlignment(Pos.CENTER);

        showOptions = new VBox(head, row1 ,row2, row3, row4);
        showOptions.setSpacing(30);
        showOptions.setAlignment(Pos.CENTER);

        /*
        //HBox for pane fromFile
        head2 = new HBox(logo,title);
        head2.setAlignment(Pos.CENTER);
        head2.setSpacing(30);
        head2.setVisible(true);

        //button to choose between from options or from file
        row6 = new HBox(optionOptions, optionFromFile);
        row6.setSpacing(30);
        row6.setAlignment(Pos.CENTER);

        row7= new HBox(categoryVB, filePathVB);
        row7.setSpacing(30);
        row7.setAlignment(Pos.CENTER);

        button = new VBox (doneFromFile);
        button.setSpacing(30);
        button.setAlignment(Pos.BOTTOM_CENTER);

        showFromFile = new VBox (head2, row6, row7, button);
        showFromFile.setSpacing(60);
        showFromFile.setAlignment(Pos.CENTER);*/

        optionOptions.setOnAction(this::optionOptionsEvent);
        optionFromFile.setOnAction(this::optionFromFileEvent);

        setStyle("-fx-background-color: #FFE5CC");
        setAlignment(Pos.CENTER); //alignment of the grid in the scene
        setSpacing(50);
        getChildren().addAll(showOptions);
    }

    /**
     * Event handler for when the category selector change
     * @param event
     */
    private void categoryEvent(Event event) {
        inputCategory = (String) selectCategory.getValue();
        if(inputCategory =="Tops"){
            type.setText("Choose witch type of "+ inputCategory +":");
            addTopCategory();
        }
        else if(inputCategory =="Bottoms"){
            type.setText("Choose witch type of "+ inputCategory +":");
            addBottomCategory();
        }
        else if(inputCategory =="Dresses"){
            type.setText("Choose witch type of "+ inputCategory +":");
            addDressCategory();
        }
        else if(inputCategory =="Accessories"){
            type.setText("Choose witch type of "+ inputCategory +":");
            addAccessorizeCategory();
        }
    }

    /**
     * Event handler for when the doneOptions button is clicked
     * if all fields are corrects it creates a new item and add it to the wardrobe returning to the HomePane otherwise an alert is generated
     * @param actionEvent
     */
    private void doneOptionsEvent(ActionEvent actionEvent) {
        inputColor =(String) selectColor.getValue();
        inputSeason =(String) selectSeason.getValue();
        inputOccasion =(String) selectOccasion.getValue();
        inputFavorite = yes.isSelected() ? "yes" : "no";
        //inputFavorite =(String) selectFavorite.getValue();
        inputType =(String) selectType.getValue();
        inputCategory =(String) selectCategory.getValue();
        inputDescription = (String) chooseDescription.getText();
        if (chooseImagePath.getText().isEmpty()) {
            switch(inputCategory){
                case "Top":{
                    switch (inputCategory){
                        case "TShirt":{
                            inputPath = "images/tshirt.png";
                            break;
                        }
                        case "Sweater":{
                            inputPath = "images/sweater.png";
                            break;
                        }
                        case "SweatshirtAndHoodie":{
                            inputPath = "images/sweatshirtAndHoodie.png";
                            break;
                        }
                        case "TopAndBody" :{
                            inputPath = "images/topAndBody.png";
                            break;
                        }
                        case "JacketAndCoat":{
                            inputPath = "images/jacketAndCoat.png";
                            break;
                        }
                        case "TankTop":{
                            inputPath = "images/tankTop.png";
                            break;
                        }
                    }
                    break;
                }
                case "Bottom":{
                    switch (inputCategory){
                        case "Skirt":{
                            inputPath = "images/skirt.png";
                            break;
                        }
                        case "Jeans":{
                            inputPath = "images/jeans.png";
                            break;
                        }
                        case "Trouser":{
                            inputPath = "images/trouser.png";
                            break;
                        }
                        case "Shorts" :{
                            inputPath = "images/shorts.png";
                            break;
                        }
                    }
                    break;
                }
                case "Dress":{
                    switch (inputCategory){
                        case "Longs":{
                            inputPath = "images/longD.jpg";
                            break;
                        }
                        case "Shorts":{
                            inputPath = "images/shortD.jpg";
                            break;
                        }
                    }
                    break;
                }
                case "Accessories":{
                    switch (inputCategory){
                        case "Jewelry":{
                            inputPath = "images/jewelry.jpg";
                            break;
                        }
                        case "Hat":{
                            inputPath = "images/hat.jpg";
                            break;
                        }
                        case "Belt":{
                            inputPath = "images/belt.jpg"; ;
                            break;
                        }
                        case "Glasses" :{
                            inputPath = "images/glasses.jpg";
                            break;
                        }
                        case "Scarf":{
                            inputPath = "images/scarf.jpg";
                            break;
                        }
                        case "Gloves":{
                            inputPath = "images/gloves.jpg";
                            break;
                        }
                        case "Purse":{
                            inputPath = "images/purse.jpg";
                            break;
                        }
                        case "Shoes" :{
                            inputPath = "images/shoes.jpg";
                            break;
                        }
                        case "ForTheHair" :{
                            inputPath = "images/forTheHair.jpg";
                            break;
                        }
                    }
                    break;
                }
            }
        }
        else {
            inputPath = "images/" + chooseImagePath.getText();
        }

        //if any of the combobox is not completed it does not proceed in the creation of the item and an alert is generated
        if(inputColor ==null || inputSeason ==null || inputOccasion ==null || inputCategory ==null || inputType ==null){ //inputFavorite ==null ||
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please choose from every combobox a field!");
            alert.showAndWait();
        }
        //Otherwise, the new item is created and the user is redirected to the HomePane
        else{
            //if there is no given description the default is an empty string
            if (inputDescription ==null){
                inputDescription ="";
            }
            //creates the correct item based on the user's selection and add the to the closet
            switch(inputCategory){
                case ("Tops"):{
                    Top nT = new Top(inputSeason, inputOccasion, inputColor, inputType, inputFavorite, inputPath, inputDescription);
                    application.getWardrobe(index).addItem(nT);
                    break;
                }
                case ("Bottoms"):{
                    Bottom nB = new Bottom(inputSeason, inputOccasion, inputColor, inputType, inputFavorite, inputPath, inputDescription);
                    application.getWardrobe(index).addItem(nB);
                    break;
                }
                case ("Dresses"):{
                    Dress nD = new Dress(inputSeason, inputOccasion, inputColor, inputType, inputFavorite, inputPath, inputDescription);
                    application.getWardrobe(index).addItem(nD);
                    break;
                }
                case ("Accessories"):{
                    Accessorize nA = new Accessorize(inputSeason, inputOccasion, inputColor, inputType, inputFavorite, inputPath, inputDescription);
                    application.getWardrobe(index).addItem(nA);
                    break;
                }
            }

            //return so HomePane
            Stage stage = (Stage) doneOptions.getScene().getWindow();
            stage.close();
            Stage stage2 = new Stage();
            Scene scene = new Scene(new HomePane(application, index), 800, 600);
            stage2.setTitle("Home");
            stage2.setScene(scene);
            stage2.show();
        }
    }

    /**
     * Event handler for when the doneFromFile button is clicked
     * if the user inserted a valid JSON file the item is created and added to the wardrobe and then the app returns to the HomePane otherwise an alert is generated
     * @param actionEvent
     */
    private void doneFromFileEvent(ActionEvent actionEvent) {
        inputCategory = (String) selectCategory.getValue();
        inputFilePath = (String) chooseFilePath.getText();

        //if the ComboBox or the TextField is not completed it does not proceed in the creation of the item and an alert is generated
        if(inputCategory == null || inputFilePath.isEmpty() == true){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill both the ComboBox and the TextField!");
            alert.showAndWait();
        }
        //Otherwise, the new item is created and the user is redirected to the HomePane
        else{
            //creates the correct item based on the user's selection and add the to the closet
            switch(inputCategory){
                case ("Tops"):{
                    Top nT = new Top(inputFilePath);
                    application.getWardrobe(index).addItem(nT);
                    break;
                }
                case ("Bottoms"):{
                    Bottom nB = new Bottom(inputFilePath);
                    application.getWardrobe(index).addItem(nB);
                    break;
                }
                case ("Dresses"):{
                    Dress nD = new Dress(inputFilePath);
                    application.getWardrobe(index).addItem(nD);
                    break;
                }
                case ("Accessories"):{
                    Accessorize nA = new Accessorize(inputFilePath);
                    application.getWardrobe(index).addItem(nA);
                    break;
                }
            }

            //return so HomePane
            Stage stage = (Stage) doneOptions.getScene().getWindow();
            stage.close();
            Stage stage2 = new Stage();
            Scene scene = new Scene(new HomePane(application, index), 800, 600);
            stage2.setTitle("Home");
            stage2.setScene(scene);
            stage2.show();
        }
    }

    /**
     * Event handler for when the logo image is clicked
     * return to HomePane
     * @param event
     */
    public void logoEvent (MouseEvent event){
        Stage stage = (Stage) logo.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new HomePane(application, index), 800, 600);
        stage2.setTitle("app.Seasons");
        stage2.setScene(scene);
        stage2.show();
    }

    /**
     * Display the items necessary for the user to creat its item from scratch
     * @param event
     */
    public void optionOptionsEvent(ActionEvent event){
        /*if (getChildren()!=showOptions){
            getChildren().clear();
            setAlignment(Pos.CENTER); //alignment of the grid in the scene
            setSpacing(20);
            getChildren().addAll(showOptions);
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            //alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("You are already in the page that allows you to create a new item from scratch");

            alert.showAndWait();
        }
        //showOptions.getChildren().clear();*/
    }

    /**
     * Display the items necessary for the user to creat its item from a JSON file
     * @param event
     */
    public void optionFromFileEvent(ActionEvent event){
        getChildren().clear();
        setAlignment(Pos.CENTER); //alignment of the grid in the scene
        setSpacing(20);
        //getChildren().addAll(showFromFile);

        //Stage stage = (Stage) optionFromFile.getScene().getWindow();
        //stage.close();
        //Stage stage2 = new Stage();
        //Scene scene = new Scene(new AddItemPane(application, index), 800, 600);
        //stage2.setTitle("Profile");
        //stage2.setScene(scene);
        //stage2.show();
    }
}
