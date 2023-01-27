package app;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Generates a scene where the main page of the application is displayed.
 * On top there is our logo and a menu bas is present where the user can select the items to display
 * On the right the user can access its profile,
 * with the "i" buttun ther is a short description of what the application does
 * and with the "+" button you can add a new item
 * @author Joséphine Sacchetto
 */
public class HomePane extends HBox {
    private App application;
    private int index;
    private Menu allitems, tops, bottoms, dresses, accessories, occasions, seasons, favorites, outfits;
    private MenuItem all; //all
    private MenuItem alltops,tShirt, sweater, sweatshirtAndHoodie, topAndBody, jacketAndCoat, tankTop; //tops
    private MenuItem allbottoms,skirt, jeans, trouser, shorts; //bottoms
    private MenuItem alldresses,lengthy, little; //dresses
    private MenuItem allaccessories,jewelry, hat, belt, glasses, scarf, gloves, purse, shoes, forTheHair; //accessorise
    private MenuItem fav;
    private MenuItem allOutfits;
    private MenuBar mb;
    private Button welcome, aboutus, information, add;
    private ImageView profile, logo, backgroudView;
    private Image backgroud;

    /**
     * Constructor of the object
     * @param application of type App
     * @param index is the index in the App arrays from where the wardrobe and all its information is loaded
     */
    public HomePane(App application, int index){
        this.application = application;
        this.index = index;

	    // creates a menubar
	    mb = new MenuBar();
	    // creates all items in the MenuBar and theirs values (All, Tops, Bottoms, Dresses Accessories, Favourites)
	    //fist menu -> All items
        allitems = new Menu("All Items");
	    all = new MenuItem("All Items"); // create menuitems
	    allitems.getItems().add(all);// add menu items to menu

        //second menu -> Top
        tops = new Menu("Tops");
        alltops = new MenuItem("All Tops");
        tShirt = new MenuItem("T-shirts");
        sweater = new MenuItem("Sweaters");
        sweatshirtAndHoodie = new MenuItem("Sweatshirts and hoodies");
        topAndBody = new MenuItem("Tops and bodys");
        jacketAndCoat = new MenuItem("Jackets and coats");
        tankTop = new MenuItem("Tank Tops");
        tops.getItems().addAll(alltops,tShirt, sweater, sweatshirtAndHoodie, topAndBody, jacketAndCoat, tankTop);// add menu items to menu

        // third menu -> Bottoms
	    bottoms = new Menu("Bottoms");
        allbottoms = new MenuItem("All Bottoms");
	    skirt = new MenuItem("Skirt");
	    jeans = new MenuItem("Jeans");
	    trouser = new MenuItem("Trouser");
	    shorts = new MenuItem("Shorts");
	    bottoms.getItems().addAll(allbottoms, skirt, jeans, trouser, shorts);

	    // fourth menu -> Dresses
	    dresses = new Menu("Dresses");
        alldresses = new MenuItem("All Dresses");
	    lengthy= new MenuItem("Long Dresses");
	    little= new MenuItem("Short Dresses");
	    dresses.getItems().addAll(alldresses, lengthy, little);

	    // fifth menu -> Accessories
	    accessories = new Menu("Accessories");
        allaccessories = new MenuItem("All Accessories");
	    jewelry= new MenuItem("Jewelry");
	    hat= new MenuItem("Hats");
	    belt= new MenuItem("Belts");
	    glasses= new MenuItem("Glasses");
	    scarf= new MenuItem("Scarfs");
	    gloves= new MenuItem("Gloves");
	    purse= new MenuItem("Purses");
	    shoes= new MenuItem("Shoes");
	    forTheHair= new MenuItem("For the hair");
        accessories.getItems().addAll(allaccessories,jewelry, hat, belt, glasses, scarf, gloves, purse, shoes, forTheHair);

        // sixth menu -> Favorites
	    favorites = new Menu("Favorites");
	    fav = new MenuItem("Favorites");
	    favorites.getItems().add(fav);

        //seventh menu -> All outfits
        outfits = new Menu("Outfits");
        allOutfits = new MenuItem("Outfits"); // create menuitems
        outfits.getItems().add(allOutfits);// add menu items to menu

        //add all menus to the MenuBar
        mb.getMenus().addAll(allitems, tops, bottoms, dresses, accessories, favorites, outfits);// add menus to menubar

        //add Button
	    add= new Button("+");
        add.setStyle("-fx-background-color: orange");

        //information button
        double r = 1.5;
        information = new Button("i");
        information.setShape(new Circle(r));
        information.setMinSize(13*r, 13*r);
        information.setMaxSize(13*r, 13*r);

        //profile image
        ImageView profileImage = new ImageView (application.getWardrobe(index).getPicture());
        profileImage.setFitHeight(50);
        profileImage.setFitWidth(50);
	    profile = profileImage;
	    profile.setPickOnBounds(true); // allows click on transparent areas

        //logo image
        logo = new ImageView("images/Logo.png");

        //information buttons
        welcome = new Button(
            "Hello " + application.getWardrobe(index).getUsername() + " :)" +
                "\nWelcome to \"My Wardrobe - Organize your closet\" !\n" +
                "\n" +
                "We're Josephine and Irene and we developed this app to create a \n" +
                "digital version of our closet to have it always with us and to solve \n" +
                "the problem of all people \"I have nothing to wear !\".\n" +
                "This simple app will help you organize all of the pieces of clothing \n" +
                "present in your wardrobe selecting also some characteristics that \n" +
                "will help you sort all your clothes to always find the best match \n" +
                "for your outfits.\n" +
                "\n" +
                "If you're intrested to learn more about us or the application use the \n" +
                "buttons at the end of this page\n"
        );
        welcome.setStyle("-fx-background-color: #FFE5CC");
        Image img = new Image("images/Logo2.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(100);
        view.setFitWidth(100);
        view.setPreserveRatio(true);
        welcome.setGraphic(view);

        aboutus = new Button("About Us");
        aboutus.setStyle("-fx-background-color: orange");

        information = new Button("Informations");
        information.setStyle("-fx-background-color: orange");

	    //background image
	    backgroud = new Image("images/Wardrobe.jpg");
	    backgroudView = new ImageView(backgroud);
	    backgroudView.setFitHeight(160);
	    backgroudView.setFitWidth(160);
	    backgroudView.setPreserveRatio(true);

	    setStyle("-fx-background-color: #FFE5CC; -fx-background-image:url('images/Wardrobe.jpg');-fx-background-repeat: no-repeat; -fx-background-size: 700 400; -fx-background-position: center center;");
	    setAlignment(Pos.BASELINE_CENTER);

        //layout
        HBox menu = new HBox(logo,mb,add,profile);
        menu.setSpacing(20);
        menu.setAlignment(Pos.CENTER);

        HBox body = new HBox(welcome);
        body.setAlignment(Pos.CENTER);

        HBox bottom = new HBox(aboutus,information);
        bottom.setSpacing(100);
        bottom.setAlignment(Pos.CENTER);

        VBox show = new VBox(menu, body, bottom);
        show.setSpacing(120);
        show.setAlignment(Pos.CENTER);

        setSpacing(50);
        getChildren().addAll(show);

        //action when clicking on a menu item
        all.setOnAction(this::showItemsAll);
        alltops.setOnAction(this::showItemsAllTops);
        tShirt.setOnAction(this::showItemsTshirt);
        sweater.setOnAction(this::showItemsSweater);
        sweatshirtAndHoodie.setOnAction(this::showItemsSweatshirtAndHoodie);
        topAndBody.setOnAction(this::showItemsTopAndBody);
        jacketAndCoat.setOnAction(this::showItemsJacketAndCoat);
        tankTop.setOnAction(this::showItemsTankTop);
        allbottoms.setOnAction(this::showItemsAllBottoms);
        skirt.setOnAction(this::showItemsSkirt);
        jeans.setOnAction(this::showItemsJeans);
        trouser.setOnAction(this::showItemsTrouser);
        shorts.setOnAction(this::showItemsShorts);
        alldresses.setOnAction(this::showItemsAllDresses);
        lengthy.setOnAction(this::showItemsLengthy);
        little.setOnAction(this::showItemsLittle);
        allaccessories.setOnAction(this::showItemsAllAccessories);
        jewelry.setOnAction(this::showItemsJewelry);
        hat.setOnAction(this::showItemsHat);
        belt.setOnAction(this::showItemsBelt);
        glasses.setOnAction(this::showItemsGlasses);
        scarf.setOnAction(this::showItemsScarf);
        gloves.setOnAction(this::showItemsGloves);
        purse.setOnAction(this::showItemsPurse);
        shoes.setOnAction(this::showItemsShoes);
        forTheHair.setOnAction(this::showItemsForTheHair);
        fav.setOnAction(this::showItemsFav);
        allOutfits.setOnAction(this::showOutfit);

        //action when clicking on the "+"
        add.setOnAction(this::addEvent);

        //action when clicking on the "i"
        information.setOnAction(this::informationEvent);

        //action when clicking on the profile photo
        profile.setOnMouseClicked(this::profileEvent);

        //action when clicking on  about us
        aboutus.setOnAction(this::aboutusEvent);

    }

    /**
     * Event handler for when the aboutus button is clicked.
     * It shows an information dialog box with information about us
     * @param event
     */
    private void aboutusEvent(ActionEvent event) {
        Alert information = new Alert (Alert.AlertType.INFORMATION);
        information.setHeaderText(null);
        information.setWidth(500);
        information.setHeight(550);
        information.setContentText(
            "Hi, I am Joséphine Sacchetto, and I am one of the two authors of this project. " +
                "I am 20 years old and was born in Bolzano where I am currently attending the " +
                "first year of university at the faculty of Computer Science. In addition " +
                "practice volleyball competitively 4 times a week and I am studying to " +
                "become a volleyball coach. When I have some free time, I really enjoy " +
                "hanging out with friends and spending time with my family." +

                "\n\nHello, I am Irene Avezzù and I am the second author of this project. " +
                "I am 19 years old, I grew up in Venice but I moved to Bolzano last september" +
                "to attend University. I was a ballet dancer for many years and still enjoy it but " +
                "since two years ago I stopped practicing it. I love traveling and every time I get " +
                "a chance to do it I take my suitcase and go explore the world"

        );

        Image image = new Image("images/aboutUs.png");
        ImageView view = new ImageView(image);
        view.setFitHeight(250);
        view.setFitWidth(160);
        view.setPreserveRatio(true);
        information.setGraphic(view);

        information.showAndWait();
    }

    /**
     * Event handler for when the information button is clicked.
     * It shows an information dialog box with information about our project
     * @param event
     */
    private void informationEvent(ActionEvent event) {
        Alert information = new Alert (Alert.AlertType.INFORMATION);
        information.setHeaderText(null);
        information.setWidth(500);
        information.setContentText(
            "The menu bar on the top will help you navigate our app. \n" +
                "Starting from the left the logo button will always bring you back to this homepage, " +
                "following you'll be able to select which items' page you want to load, inside you will" +
                "find all the items of that category and you'll be able to see al their details and " +
                "delete the items that you don't want in your wardrobe. You will also find additional" +
                "options to sort the items such as colour, season and occasion. " +
                "Following on the menu bar, the \"+\" button will allow you to create a new item from " +
                "scratch or to import a new one from its .json file or to create a new outfit. Lastly, " +
                "the profile icon will lead you to your profile page where you'll be able to modify your" +
                "data, cancel your account or log out."
        );
        information.showAndWait();
    }

    /**
     * Event handler for when the add button is clicked.
     * It goes to AddPane
     * @param event
     */
    public void addEvent (ActionEvent event){
        Stage stage = (Stage) add.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new AddPane(getApplication(), getIndex()), 600, 400);
        stage2.setTitle("Add Element");
        stage2.setScene(scene);
        stage2.show();
    }

    /**
     * Event handler for when the profile Image is clicked.
     * It goes to ProfilePane
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

    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsAll(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), all.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsAllTops(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), alltops.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsTshirt(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), tShirt.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsSweater(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), sweater.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsSweatshirtAndHoodie(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), sweatshirtAndHoodie.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsTopAndBody(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), topAndBody.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsJacketAndCoat(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), jacketAndCoat.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsTankTop(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), tankTop.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsAllBottoms(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), allbottoms.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsSkirt(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), skirt.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsJeans(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), jeans.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsTrouser(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), trouser.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsShorts(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), shorts.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsAllDresses(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), alldresses.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsLengthy(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), lengthy.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsLittle(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), little.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsAllAccessories(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), allaccessories.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsJewelry(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), jewelry.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsHat(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), hat.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsBelt(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), belt.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsGlasses(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), glasses.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsScarf(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), scarf.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsGloves(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), gloves.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();}
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsPurse(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), purse.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsShoes(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), shoes.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsForTheHair(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), forTheHair.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showItemsFav(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new ItemPane(getApplication(), getIndex(), fav.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }

    /**
     * Event handler for when a menu item is clicked.
     * It goes to ItemPane
     * @param event
     */
    private void showOutfit(ActionEvent event) {
        Stage stage = (Stage) mb.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Scene scene = new Scene(new OutfitPane(getApplication(), getIndex(), allOutfits.getText()), 800, 600);
        stage2.setTitle("Item");
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Getter of application
     * @return application
     */
    public App getApplication(){
        return application;
    }
    /**
     * Getter of index
     * @return index
     */
    public int getIndex(){
        return index;
    }


}
