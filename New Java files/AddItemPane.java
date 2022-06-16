import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddItemPane extends HBox {
    private String inputcolor, inputseason, inputoccasion, inputfavorite, inputcategory, inputitem, inputpath;
    private int index;
    private App application;
    private Label path, title, color, season, occasion, favorite, category, items, description;
    private Font font;
    private TextField choosepath,choosedescription;
    private Button done, option1, option2; //option 1 and 2 bottoni per import da file o creazione item
    private ComboBox selectcolor, selectseason, selectoccasion, selectfavorite, selectcategory, selectitem;

    //set costant ComboBox
    public void addColorCategory() {
    	selectcolor.getItems().add("White");
        selectcolor.getItems().add("Black");
        selectcolor.getItems().add("Pink");
        selectcolor.getItems().add("Blue");
        selectcolor.getItems().add("Red");
        selectcolor.getItems().add("Yellow");
        selectcolor.getItems().add("Green");
        selectcolor.getItems().add("Beige");
        selectcolor.getItems().add("Brown");
        selectcolor.getItems().add("Orange");        
    }
    public void addSeasonCategory() {
    	selectseason.getItems().add("Winter");
    	selectseason.getItems().add("Spring");
    	selectseason.getItems().add("Summer");
    	selectseason.getItems().add("Fall");     
    }
    public void addOccasionCategory() {
    	selectoccasion.getItems().add("Formal");
        selectoccasion.getItems().add("EveryDay");
        selectoccasion.getItems().add("Semiformal");
        selectoccasion.getItems().add("Sporty");
    }
    public void addFavouriteCategory() {
    	selectfavorite.getItems().add("Yes");
        selectfavorite.getItems().add("No");
    }
    public void addTypeCategory() {
    	selectcategory.getItems().add("Tops");
        selectcategory.getItems().add("Bottoms");
        selectcategory.getItems().add("Dresses");
        selectcategory.getItems().add("Accessories");
    }
    
    //set non costant ComboBox
    public void addTopCategory() {
    	selectitem.getItems().clear();
    	selectitem.getItems().add("TShirt");
        selectitem.getItems().add("Sweater");
        selectitem.getItems().add("SweatshirtAndHoodie");
        selectitem.getItems().add("TopAndBody");
        selectitem.getItems().add("JacketAndCoat");
        selectitem.getItems().add("ThankTop");
    }
    public void addBottomCategory() {
    	selectitem.getItems().clear();
    	selectitem.getItems().add("Skirt");
        selectitem.getItems().add("Jeans");
        selectitem.getItems().add("Trouser");
        selectitem.getItems().add("Shorts");
    }
    public void addDressCategory() {
    	selectitem.getItems().clear();
        selectitem.getItems().add("Longs");
        selectitem.getItems().add("Shorts");
    }
    public void addAccessorizeCategory() {
    	selectitem.getItems().clear();
    	selectitem.getItems().add("Jewelry");
        selectitem.getItems().add("Hat");
        selectitem.getItems().add("Belt");
        selectitem.getItems().add("Glasses");
        selectitem.getItems().add("Scarf");
        selectitem.getItems().add("Gloves");
        selectitem.getItems().add("Purse");
        selectitem.getItems().add("Shoes");
        selectitem.getItems().add("ForTheHair");
    }
    
    public AddItemPane(App ap, int i){
    	application = ap;
    	index = i;

        path = new Label("Insert the path of the Item photo");
        title = new Label("Add your items");
        font = new Font(24);
        choosepath = new TextField();
        done = new Button("Done");
        color = new Label("Color:");
        description = new Label("Add description: ");
        choosedescription = new TextField();
        selectcolor  = new ComboBox();
        season = new Label("Season:");
        selectseason  = new ComboBox();
        occasion = new Label("Occasion:");
        selectoccasion  = new ComboBox();
        favorite = new Label("Favorite:");
        selectfavorite  = new ComboBox();
        category = new Label("Category:");
        selectcategory  = new ComboBox();
        items = new Label();
        selectitem  = new ComboBox();
        

        title.setFont(font);

        addColorCategory();
        addSeasonCategory();
        addOccasionCategory();
        addFavouriteCategory();
        addTypeCategory();

        selectcategory.setOnAction((event) -> {
            inputcategory= (String) selectcategory.getValue();
            if(inputcategory=="Tops"){
            	items.setText("Choose witch type of "+inputcategory +":");
            	addTopCategory();
            }
            else if(inputcategory=="Bottoms"){
            	items.setText("Choose witch type of "+inputcategory +":");
            	addBottomCategory();
            }
            else if(inputcategory=="Dresses"){
            	items.setText("Choose witch type of "+inputcategory +":");
            	addDressCategory();
            }
            else if(inputcategory=="Accessories"){
            	items.setText("Choose witch type of "+inputcategory +":");
            	addAccessorizeCategory();
            }
        });

        done.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                inputcolor=(String) selectcolor.getValue();
                inputseason=(String) selectseason.getValue();
                inputoccasion=(String) selectoccasion.getValue();
                inputfavorite=(String) selectfavorite.getValue();
                inputitem=(String) selectitem.getValue();
                if (choosepath.getText().isEmpty()) {
                	inputpath = "filename";
                }
                else {
                	inputpath = choosepath.getText();
                }


                if(inputcolor==null || inputseason==null || inputoccasion==null || inputfavorite==null || inputcategory==null || inputitem==null){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText(null);
                    alert.setContentText("Please choose from every combobox a field!");
                    alert.showAndWait();
                } else{
                	if(inputcategory=="Tops"){
                    	Top nT = new Top (inputseason, inputoccasion, inputcolor, inputcategory, inputitem, inputpath );
                    }
                    else if(inputcategory=="Bottoms"){
                    	items.setText("Choose witch type of "+inputcategory +":");
                    	addBottomCategory();
                    }
                    else if(inputcategory=="Dresses"){
                    	items.setText("Choose witch type of "+inputcategory +":");
                    	addDressCategory();
                    }
                    else if(inputcategory=="Accessories"){
                    	items.setText("Choose witch type of "+inputcategory +":");
                    	addAccessorizeCategory();
                    }
	                Stage stage = (Stage) done.getScene().getWindow();
	                stage.close();
	                Stage stage2 = new Stage();
	                        Scene scene = new Scene(new HomePane(application, index), 800, 600);
	                        stage2.setTitle("Home");
	                        stage2.setScene(scene);
	                        stage2.show();
                }
            }
        });

        ImageView logo = new ImageView("Logo.png");
        logo.setPickOnBounds(true); // allows click on transparent areas
        logo.setOnMouseClicked((MouseEvent e) -> {
                Stage stage = (Stage) logo.getScene().getWindow();
                stage.close();
                Stage stage2 = new Stage();
                Scene scene = new Scene(new HomePane(application, index), 800, 600);
                stage2.setTitle("Seasons");
                stage2.setScene(scene);
                stage2.show();
            });

        
        VBox lg=new VBox(logo);
        lg.setAlignment(Pos.TOP_LEFT);

        VBox choice1 = new VBox(path, choosepath);
        VBox choice2 = new VBox(color, selectcolor);
        VBox choice3 = new VBox(season, selectseason);
        VBox choice4 = new VBox(occasion, selectoccasion);
        VBox choice5 = new VBox(favorite, selectfavorite);
        VBox choice6 = new VBox(category, selectcategory);
        VBox choice7= new VBox(items, selectitem);
        VBox choice8 = new VBox(description,choosedescription);
        

        HBox row1 = new HBox(title);
        row1.setAlignment(Pos.CENTER);

        HBox row2 = new HBox(choice2, choice3, choice4, choice5);
        row2.setSpacing(30);
        row2.setAlignment(Pos.CENTER);

        HBox row3= new HBox(choice6, choice7, choice1,choice8);
        row3.setSpacing(30);
        row3.setAlignment(Pos.CENTER);

        HBox row4 = new HBox(done);
        row4.setAlignment(Pos.CENTER);


        VBox show = new VBox(row1, row2, row3, row4);
        show.setSpacing(100);
        show.setAlignment(Pos.CENTER);

        // VBox overview = new VBox(username,password,email,phone, removeaccount,done);
        // overview.setAlignment(Pos.CENTER_LEFT);
        // overview.setSpacing(30);
        setStyle("-fx-background-color: #FFE5CC");
        setAlignment(Pos.CENTER); //alignment of the grid in the scene
        setSpacing(50);
        getChildren().addAll(lg, show);


       }
}
