package app;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Generates a scene where the main page of the application is displayed.
 * On top a menu bas is present where the user can select the items to display
 * On the right the user can access its profile and with the "+" button add a new item
 * @author Josephine Sacchetto
 */
public class HomePane extends HBox {
    private String applyfilter[]= new String[3];
    private App application;
    private int index;
    private Font font;
    private Label title;
    private ButtonType ok;
    private ButtonType delte;
    //private Menu all, tops, bottom, dresses, accessories, ocasions, seasons, favorites ;

    public HomePane(App ap, int i){
    	application = ap;
    	index = i;
	    font = new Font(24);
	    title = new Label ("title");
	    title.setFont(font);


	    // create a menubar
	    MenuBar mb = new MenuBar();

	    // create a menu
	    Menu all = new Menu("All items");
	    // create menuitems
	    MenuItem allitems = new MenuItem("All");
	    // add menu items to menu
	    all.getItems().add(allitems);
	    // add menu to menubar
	    mb.getMenus().add(all);

	    // create a menu
	    Menu tops = new Menu("Tops");
	    // create menuitems
	    MenuItem tshirts = new MenuItem("T-shirts");


	    MenuItem shirts = new MenuItem("Shirts");
	    MenuItem pullovers = new MenuItem("Pullovers");
	    MenuItem sweatshirts = new MenuItem("Sweatshirts");
	    MenuItem jackets = new MenuItem("Jackets");
	    MenuItem bodies = new MenuItem("Bodies");
	    MenuItem undershirts = new MenuItem("Undershirts");
	    // add menu items to menu
	    tops.getItems().add(tshirts);
	    tops.getItems().add(shirts);
	    tops.getItems().add(pullovers);
	    tops.getItems().add(sweatshirts);
	    tops.getItems().add(jackets);
	    tops.getItems().add(bodies);
	    tops.getItems().add(undershirts);
	    // add menu to menubar
	    mb.getMenus().add(tops);

	    // create a menu
	    Menu bottom = new Menu("Bottom");
	    // create menuitems
	    MenuItem skirt = new MenuItem("Skirt");
	    MenuItem jeans = new MenuItem("Jeans");
	    MenuItem pants = new MenuItem("Pants");
	    MenuItem shorts = new MenuItem("Shorts");
	    // add menu items to menu
	    bottom.getItems().add(skirt);
	    bottom.getItems().add(jeans);
	    bottom.getItems().add(pants);
	    bottom.getItems().add(shorts);
	    // add menu to menubar
	    mb.getMenus().add(bottom);

	    // create a menu
	    Menu dresses = new Menu("Dresses");
	    // create menuitems
	    MenuItem lengthy= new MenuItem("Long");
	    MenuItem little= new MenuItem("Short");
	    // add menu items to menu
	    dresses.getItems().add(lengthy);
	    dresses.getItems().add(little);
	    // add menu to menubar
	    mb.getMenus().add(dresses);

	    // create a menu
	    Menu accessories = new Menu("Accessories");
	    // create menuitems
	    MenuItem jewelry= new MenuItem("Jewelry");
	    MenuItem bags= new MenuItem("Bags");
	    MenuItem hats= new MenuItem("Hats");
	    MenuItem belts= new MenuItem("Belts");
	    MenuItem glasses= new MenuItem("Glasses");
	    MenuItem scarves= new MenuItem("Scarves");
	    MenuItem forhair= new MenuItem("For hair");
	    MenuItem gloves= new MenuItem("Gloves");
	    MenuItem shoes= new MenuItem("Shoes");
	    // add menu items to menu
	    accessories.getItems().add(jewelry);
	    accessories.getItems().add(bags);
	    accessories.getItems().add(hats);
	    accessories.getItems().add(belts);
	    accessories.getItems().add(glasses);
	    accessories.getItems().add(scarves);
	    accessories.getItems().add(forhair);
	    accessories.getItems().add(gloves);
	    accessories.getItems().add(shoes);
	    // add menu to menubar
	    mb.getMenus().add(accessories);

	    // create a menu
	    Menu ocasions = new Menu("Occasions");
	    // create menuitems
	    MenuItem elegant= new MenuItem("Elegant");
	    MenuItem sporty= new MenuItem("Sporty");
	    MenuItem everyday= new MenuItem("Every Day");
	    // add menu items to menu
	    ocasions.getItems().add(elegant);
	    ocasions.getItems().add(sporty);
	    ocasions.getItems().add(everyday);
	    // add menu to menubar
	    mb.getMenus().add(ocasions);

	    // create a menu
	    Menu seasons = new Menu("Seasons");
	    // create menuitems
	    MenuItem summer= new MenuItem("Summer");
	    MenuItem autumn= new MenuItem("Autumn");
	    MenuItem winter= new MenuItem("Winter");
	    MenuItem spring= new MenuItem("Spring");
	    // add menu items to menu
	    seasons.getItems().add(summer);
	    seasons.getItems().add(autumn);
	    seasons.getItems().add(winter);
	    seasons.getItems().add(spring);
	    // add menu to menubar
	    mb.getMenus().add(seasons);

	    // create a menu
	    Menu favorites = new Menu("Favorites");
	    // create menuitems
	    MenuItem fav = new MenuItem("fav");
	    // add menu items to menu
	    favorites.getItems().add(fav);
	    // add menu to menubar
	    mb.getMenus().add(favorites);

	    Button add= new Button("+");

	    add.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent t) {
	            Stage stage = (Stage) add.getScene().getWindow();
	            stage.close();
	            Stage stage2 = new Stage();
	            Scene scene = new Scene(new AddItemPane(application, index), 800, 600);
	            stage2.setTitle("Add Items");
	            stage2.setScene(scene);
	            stage2.show();
	        }
	    });

	    ImageView profile = new ImageView("images/Profile2.png");
	    profile.setPickOnBounds(true); // allows click on transparent areas
	    profile.setOnMouseClicked((MouseEvent e) -> {
	        Stage stage = (Stage) profile.getScene().getWindow();
	        stage.close();
	        Stage stage2 = new Stage();
	        Scene scene = new Scene(new ProfilePane(application, index), 800, 600);
	        stage2.setTitle("Profile");
	        stage2.setScene(scene);
	        stage2.show();
	        });

	    ImageView logo = new ImageView("images/Logo.png");

	    //filtro
	    ComboBox filter1  = new ComboBox();

	    filter1.getItems().add("None");
	    filter1.getItems().add("Choice 2");
	    filter1.getItems().add("Choice 3");

	    filter1.setOnAction((event) -> {
	        System.out.println(filter1.getValue());
	    });
	    //filtro
	    ComboBox filter2  = new ComboBox();

	    filter2.getItems().add("None");
	    filter2.getItems().add("Choice 2");
	    filter2.getItems().add("Choice 3");

	    filter2.setOnAction((event) -> {
	        System.out.println(filter2.getValue());
	    });
	    //filtro
	    ComboBox filter3  = new ComboBox();

	    filter3.getItems().add("None");
	    filter3.getItems().add("Choice 2");
	    filter3.getItems().add("Choice 3");

	    filter3.setOnAction((event) -> {
	        System.out.println(filter3.getValue());
	    });

	    //crea l'immagine all'interno del button
	    Image img1 = new Image("images/Wardrobe.jpg");
	    ImageView view1 = new ImageView(img1);
	    view1.setFitHeight(160);
	    view1.setFitWidth(160);
	    view1.setPreserveRatio(true);
	    //Creating a Button
	    Button card1 = new Button();
	    //Setting the size of the button
	    card1.setPrefSize(180, 180);
	    //Setting a graphic to the button
	    card1.setGraphic(view1);

	    //crea l'immagine all'interno del button
	    Image img2 = new Image("images/Wardrobe.jpg");
	    ImageView view2 = new ImageView(img2);
	    view2.setFitHeight(160);
	    view2.setFitWidth(160);
	    view2.setPreserveRatio(true);
	    //Creating a Button
	    Button card2 = new Button();
	    //Setting the size of the button
	    card2.setPrefSize(180, 180);
	    //Setting a graphic to the button
	    card2.setGraphic(view2);

	    //crea l'immagine all'interno del button
	    Image img3 = new Image("images/Wardrobe.jpg");
	    ImageView view3 = new ImageView(img3);
	    view3.setFitHeight(160);
	    view3.setFitWidth(160);
	    view3.setPreserveRatio(true);
	    //Creating a Button
	    Button card3 = new Button();
	    //Setting the size of the button
	    card3.setPrefSize(180, 180);
	    //Setting a graphic to the button
	    card3.setGraphic(view3);

	    //crea l'immagine all'interno del button
	    Image img4 = new Image("images/Wardrobe.jpg");
	    ImageView view4 = new ImageView(img4);
	    view4.setFitHeight(160);
	    view4.setFitWidth(160);
	    view4.setPreserveRatio(true);
	    //Creating a Button
	    Button card4 = new Button();
	    //Setting the size of the button
	    card4.setPrefSize(180, 180);
	    //Setting a graphic to the button
	    card4.setGraphic(view4);

	    //crea l'immagine all'interno del button
	    Image img5 = new Image("images/Wardrobe.jpg");
	    ImageView view5 = new ImageView(img5);
	    view5.setFitHeight(160);
	    view5.setFitWidth(160);
	    view5.setPreserveRatio(true);
	    //Creating a Button
	    Button card5 = new Button();
	    //Setting the size of the button
	    card5.setPrefSize(180, 180);
	    //Setting a graphic to the button
	    card5.setGraphic(view5);

	    //crea l'immagine all'interno del button
	    Image img6 = new Image("images/Wardrobe.jpg");
	    ImageView view6 = new ImageView(img6);
	    view6.setFitHeight(160);
	    view6.setFitWidth(160);
	    view6.setPreserveRatio(true);
	    //Creating a Button
	    Button card6 = new Button();
	    //Setting the size of the button
	    card6.setPrefSize(180, 180);
	    //Setting a graphic to the button
	    card6.setGraphic(view6);

	    Button apply = new Button("Apply");
	    Button next = new Button(" Next ");

	    setStyle("-fx-background-color: white; -fx-background-image:url('images/Wardrobe.jpg');-fx-background-repeat: no-repeat; -fx-background-size: 700 400; -fx-background-position: center center;");
	    setAlignment(Pos.BASELINE_CENTER);
	    //setHgap(20); // horizontal gap between cells
	    //setVgap(10);



	    HBox menu = new HBox(logo,mb,add,profile);
	    menu.setSpacing(20);
	    menu.setAlignment(Pos.CENTER);

	    HBox label = new HBox(title);
	    label.setSpacing(20);
	    label.setAlignment(Pos.CENTER);

	    HBox filter = new HBox(filter1,filter2,filter3,apply);
	    filter.setSpacing(20);

	    HBox cardsr1 = new HBox(card1,card2,card3);
	    cardsr1.setSpacing(60);

	    HBox cardsr2 = new HBox(card4,card5,card6,next);
	    cardsr2.setSpacing(60);
	    cardsr2.setAlignment(Pos.BOTTOM_CENTER);

	    setSpacing(50);
	    getChildren().addAll(menu);


        //action when clicking on a menu item

        all.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        tshirts.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        shirts.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        pullovers.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        sweatshirts.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        jackets.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        bodies.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        undershirts.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        skirt.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        jeans.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        pants.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        shorts.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        lengthy.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        little.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        jewelry.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        bags.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        hats.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        belts.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        glasses.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        scarves.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        forhair.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        gloves.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        shoes.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        elegant.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        sporty.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        everyday.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        summer.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        autumn.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        winter.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        spring.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });


        fav.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);

            }
        });

        //se premuto deve far vedere gli items in base ai filtri
        apply.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //se clicchi su none allora nessun filtro (se uguale a none allora nessun filtro applicato)
                applyfilter[0]=(String) filter1.getValue();
                applyfilter[1]=(String) filter2.getValue();
                applyfilter[2]=(String) filter3.getValue();
            }

        });

        //in caso usare quello scritto nel squarecolorpane
        card1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("I have a great message for you!");
                Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Emojione_1F62D.svg/64px-Emojione_1F62D.svg.png");
                ImageView view = new ImageView(image);
                view.setFitHeight(160);
                view.setFitWidth(160);
                view.setPreserveRatio(true);
                alert.setGraphic(view);

                alert.getButtonTypes().setAll(delte, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delte){
                    System.out.println("This is the delte button");
                }

            }

        });


        //in caso usare quello scritto nel squarecolorpane
        card2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("I have a great message for you!");
                Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Emojione_1F62D.svg/64px-Emojione_1F62D.svg.png");
                ImageView view = new ImageView(image);
                view.setFitHeight(160);
                view.setFitWidth(160);
                view.setPreserveRatio(true);
                alert.setGraphic(view);

                alert.getButtonTypes().setAll(delte, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delte){
                    System.out.println("This is the delte button");
                }

            }

        });

        //in caso usare quello scritto nel squarecolorpane
        card3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("I have a great message for you!");
                Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Emojione_1F62D.svg/64px-Emojione_1F62D.svg.png");
                ImageView view = new ImageView(image);
                view.setFitHeight(160);
                view.setFitWidth(160);
                view.setPreserveRatio(true);
                alert.setGraphic(view);

                alert.getButtonTypes().setAll(delte, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delte){
                    System.out.println("This is the delte button");
                }

            }

        });

        //in caso usare quello scritto nel squarecolorpane
        card4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("I have a great message for you!");
                Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Emojione_1F62D.svg/64px-Emojione_1F62D.svg.png");
                ImageView view = new ImageView(image);
                view.setFitHeight(160);
                view.setFitWidth(160);
                view.setPreserveRatio(true);
                alert.setGraphic(view);

                alert.getButtonTypes().setAll(delte, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delte){
                    System.out.println("This is the delte button");
                }

            }

        });


        //in caso usare quello scritto nel squarecolorpane
        card5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("I have a great message for you!");
                Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Emojione_1F62D.svg/64px-Emojione_1F62D.svg.png");
                ImageView view = new ImageView(image);
                view.setFitHeight(160);
                view.setFitWidth(160);
                view.setPreserveRatio(true);
                alert.setGraphic(view);

                alert.getButtonTypes().setAll(delte, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delte){
                    System.out.println("This is the delte button");
                }

            }

        });


        //in caso usare quello scritto nel squarecolorpane
        card6.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("I have a great message for you!");
                Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Emojione_1F62D.svg/64px-Emojione_1F62D.svg.png");
                ImageView view = new ImageView(image);
                view.setFitHeight(160);
                view.setFitWidth(160);
                view.setPreserveRatio(true);
                alert.setGraphic(view);

                alert.getButtonTypes().setAll(delte, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delte){
                    System.out.println("This is the delte button");
                }

            }

        });
	    }
}
