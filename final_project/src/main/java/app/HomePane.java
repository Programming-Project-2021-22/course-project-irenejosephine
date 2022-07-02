package app;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
    private String appliedFilter[]= new String[3];
    private App application;
    private int index;
    private Font font;
    private Label title;
    private ButtonType ok;
    private ButtonType delete;
    private Menu all, tops, bottoms, dresses, accessories, occasions, seasons, favorites ;
    private MenuItem allItems; //all
    private MenuItem tShirt, sweater, sweatshirtAndHoodie, topAndBody, jacketAndCoat, tankTop; //tops
    private MenuItem skirt, jeans, trouser, shorts; //bottoms
    private MenuItem lengthy, little; //dresses
    private MenuItem jewelry, hat, belt, glasses, scarf, gloves, purse, shoes, forTheHair; //accessorise
    private MenuItem fav; //favourites
    private MenuBar mb;
    private Button add;
    private ImageView profile, logo, backgroudView;
    private ComboBox occasionsFilter, colorsFilter, seasonsFilter;
    private Image backgroud;

    /**
     * Constructor of the object
     * @param application
     * @param index
     */
    public HomePane(App application, int index){
        this.application = application;
        this.index = index;
	    font = new Font(24);
	    title = new Label ("title");
	    title.setFont(font);


	    // creates a menubar
	    mb = new MenuBar();
	    // creates all items in the MenuBar and theirs values (All, Tops, Bottoms, Dresses Accessories, Favourites)

	    //fist menu -> All items
        all = new Menu("All items");
	    allItems = new MenuItem("All"); // create menuitems
	    all.getItems().add(allItems);// add menu items to menu



        //second menu -> Top
        tops = new Menu("Tops");
        tShirt = new MenuItem("T-shirts");
        sweater = new MenuItem("T-shirts");
        sweatshirtAndHoodie = new MenuItem("Sweatshirt and hoodie");
        topAndBody = new MenuItem("Top and body");
        jacketAndCoat = new MenuItem("Jacket and coat");
        tankTop = new MenuItem("Tank Top");
        tops.getItems().addAll(tShirt, sweater, sweatshirtAndHoodie, topAndBody, jacketAndCoat, tankTop);

        // third menu -> Bottoms
	    bottoms = new Menu("Bottom");
	    skirt = new MenuItem("Skirt");
	    jeans = new MenuItem("Jeans");
	    trouser = new MenuItem("Trouser");
	    shorts = new MenuItem("Shorts");
	    bottoms.getItems().addAll(skirt, jeans, trouser, shorts);


	    // fourth menu -> Dresses
	    dresses = new Menu("Dresses");
	    lengthy= new MenuItem("Long");
	    little= new MenuItem("Short");
	    dresses.getItems().addAll(lengthy, little);

	    // fifth menu -> Accessories
	    accessories = new Menu("Accessories");
	    jewelry= new MenuItem("Jewelry");
	    hat= new MenuItem("Hats");
	    belt= new MenuItem("Belts");
	    glasses= new MenuItem("Glasses");
	    scarf= new MenuItem("Scarfs");
	    gloves= new MenuItem("Gloves");
	    purse= new MenuItem("Purses");
	    shoes= new MenuItem("Shoes");
	    forTheHair= new MenuItem("For the hair");
        accessories.getItems().addAll(jewelry, hat, belt, glasses, scarf, gloves, purse, shoes, forTheHair);

        // sixth menu -> Favorites
	    favorites = new Menu("Favorites");
	    fav = new MenuItem("fav");
	    favorites.getItems().add(fav);

        //add all menus to the MenuBar
        mb.getMenus().addAll(all, tops, bottoms, dresses, accessories, favorites);// add menus to menubar
        //event handlers
        all.setOnAction(new EventHandler<ActionEvent>() {
            //richiama il metodo getItems di App
            //creates a new window
            public void handle(ActionEvent t) {
                setStyle("-fx-background-color: #FFE5CC");

                /*VBox show = new VBox (menu,label,filter,cardsr1,cardsr2);
                show.setSpacing(20);

                setSpacing(50);
                getChildren().addAll(show);*/

            }
        });

        //allItems.addEventHandler(this::allItemsEvent);
        /*tShirt.addEventHandler(new EventHandler<ActionEvent>(){this::tShirtEvent}); //this::tShirtEvent);
        sweater.addEventHandler(this::sweaterEvent);
        sweatshirtAndHoodie.addEventHandler(this::sweatshirtAndHoodieEvent);
        topAndBody.addEventHandler(this::topAndBodyEvent);
        jacketAndCoat.addEventHandler(this::jacketAndCoatEvent);
        tankTop.addEventHandler(this::tankToEvent);
        skirt.addEventHandler(this::skirtEvent);
        jeans.addEventHandler(this::jeansEvent);
        trouser.addEventHandler(this::trouserEvent);
        shorts.addEventHandler(this::shortsEvent);
        lengthy.addEventHandler(this::lenghtyEvent);
        little.addEventHandler(this::littleEvent);
        jewelry.addEventHandler(this::jewelryEvent);
        hat.addEventHandler(this::hatEvent);
        belt.addEventHandler(this::beltEvent);
        glasses.addEventHandler(this::glassesEvent);
        scarf.addEventHandler(this::scarfEvent);
        gloves.addEventHandler(this::glovesEvent);
        purse.addEventHandler(this::purseEvent);
        shoes.addEventHandler(this::shoesEvent);
        forTheHair.addEventHandler(this::forTheHairEvent);
        fav.addEventHandler(this::favEvent);*/

        //add button and event handler
	    add= new Button("+");
        add.setOnAction(this::addEvent);


        //profile image and event handler
	    profile = new ImageView("images/Profile2.png");
	    profile.setPickOnBounds(true); // allows click on transparent areas
        profile.setOnMouseClicked(this::profileEvent);

        //logo image
        logo = new ImageView("images/Logo.png");

	    //filters
        //first filter -> occasions
	    occasionsFilter = new ComboBox();
        occasionsFilter.getItems().addAll("formal", "every day", "semiformal", "sporty");
        occasionsFilter.setOnAction(this::occasionsFilterEvent);

	    //second filter -> colors
	    colorsFilter  = new ComboBox();
        colorsFilter.getItems().addAll( "White", "Black", "Pink", "Blue", "Red", "Yellow", "Green", "Beige", "Brown", "Orange");
        colorsFilter.setOnAction(this::colorsFilterEvent);

	    //third filter -> seasons
        seasonsFilter  = new ComboBox();
        seasonsFilter.getItems().addAll( "Winter", "Spring", "Summer", "Fall");
        seasonsFilter.setOnAction(this::seasonsFilterEvent);

	    //background image
	    backgroud = new Image("images/Wardrobe.jpg");
	    backgroudView = new ImageView(backgroud);
	    backgroudView.setFitHeight(160);
	    backgroudView.setFitWidth(160);
	    backgroudView.setPreserveRatio(true);

        //Creating a Button
	    Button card1 = new Button();
	    //Setting the size of the button
	    card1.setPrefSize(180, 180);
	    //Setting a graphic to the button
	    card1.setGraphic(backgroudView);

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

	    HBox filter = new HBox(occasionsFilter,colorsFilter,seasonsFilter,apply);
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

        /*tshirts.setOnAction(new EventHandler<ActionEvent>() {
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
        });*/

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

        /*pants.setOnAction(new EventHandler<ActionEvent>() {
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
        });*/

        //se premuto deve far vedere gli items in base ai filtri
        apply.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //se clicchi su none allora nessun filtro (se uguale a none allora nessun filtro applicato)
                appliedFilter[0]=(String) occasionsFilter.getValue();
                appliedFilter[1]=(String) colorsFilter.getValue();
                appliedFilter[2]=(String) seasonsFilter.getValue();
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

                alert.getButtonTypes().setAll(delete, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delete){
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

                alert.getButtonTypes().setAll(delete, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delete){
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

                alert.getButtonTypes().setAll(delete, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delete){
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

                alert.getButtonTypes().setAll(delete, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delete){
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

                alert.getButtonTypes().setAll(delete, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delete){
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

                alert.getButtonTypes().setAll(delete, ok);


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == delete){
                    System.out.println("This is the delte button");
                }

            }

        });
	    }

    /**
     * Event handler for when the add button is clicked
     * goes to AddItemPane
     * @param event
     */
    public void addEvent (ActionEvent event){
        Stage stage = (Stage) add.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new AddItemPane(application, index), 800, 600);
        stage2.setTitle("Add Items");
        stage2.setScene(scene);
        stage2.show();
    }

    /**
     * Event handler for when the profile Image  is clicked
     * goes to ProfilePane
     * @param event
     */
    public void profileEvent (MouseEvent event){
        Stage stage = (Stage) profile.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ProfilePane(application, index), 800, 600);
        stage2.setTitle("Profile");
        stage2.setScene(scene);
        stage2.show();
    }

    public void occasionsFilterEvent(Event event){
        System.out.println(occasionsFilter.getValue());
    }

    public void colorsFilterEvent(Event event){
        System.out.println(colorsFilter.getValue());
    }

    public void seasonsFilterEvent(Event event){
        System.out.println(seasonsFilter.getValue());
    }

    public void allItemsEvent (Event event){
        //TODO
    }

    public void tShirtEvent (Event event){
        //TODO
    }

    public void sweaterEvent (Event event){
        //TODO
    }

    public void sweatshirtAndHoodieEvent (Event event){
        //TODO
    }

    public void topAndBodyEvent (Event event){
        //TODO
    }

    public void jacketAndCoatEvent (Event event){
        //TODO
    }

    public void tankToEvent (Event event){
        //TODO
    }

    public void skirtEvent (Event event){
        //TODO
    }

    public void jeansEvent (Event event){
        //TODO
    }

    public void trouserEvent (Event event){
        //TODO
    }

    public void shortsEvent (Event event){
        //TODO
    }

    public void lenghtyEvent (Event event){
        //TODO
    }

    public void littleEvent (Event event){
        //TODO
    }

    public void jewelryEvent (Event event){
        //TODO
    }

    public void hatEvent (Event event){
        //TODO
    }

    public void beltEvent (Event event){
        //TODO
    }

    public void glassesEvent (Event event){
        //TODO
    }

    public void scarfEvent (Event event){
        //TODO
    }

    public void glovesEvent (Event event){
        //TODO
    }

    public void purseEvent (Event event){
        //TODO
    }

    public void shoesEvent (Event event){
        //TODO
    }

    public void forTheHairEvent (Event event){
        //TODO
    }

    public void favEvent (Event event){
        //TODO
    }
}
