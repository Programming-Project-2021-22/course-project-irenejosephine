package app;

import com.google.gson.Gson;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {



    public static void main(String[] args)  {
        //crea items
        Top tops[] = new Top [4];
        tops[0]=new Top ("winter", "everyDay", "White", "tShirt", "yes", "images/tShirt.png", "white sweater", 0);
        tops[1]=new Top ("summer", "semiformal", "Black", "sweater", "no", "images/sweater.png", "white sweater", 1);
        tops[2]=new Top ("spring", "formal", "Pink", "sweatshirtAndHoodie", "yes", "images/sweatshirtAndHoodie.png", "white sweater", 2);
        tops[3]=new Top ("fall", "sporty", "Blue", "jacketAndCoat", "no", "images/jacketAndCoat.png", "white sweater", 3);
        Bottom bottoms[] = new Bottom [4];
        bottoms[0]=new Bottom ("winter", "everyDay", "Red", "skirt", "yes", "images/skirt.png", "blue trouser", 4);
        bottoms[1]=new Bottom ("summer", "semiformal", "Yellow", "jeans", "no", "images/jeans.png", "blue trouser", 5);
        bottoms[2]=new Bottom ("spring", "formal", "Green", "trouser", "yes", "images/trouser.png", "blue trouser", 6);
        bottoms[3]=new Bottom ("fall", "sporty", "Beige", "shorts", "no", "images/shorts.png", "blue trouser", 7);
        Dress dresses[] = new Dress [4];
        dresses[0]=new Dress ("winter", "everyDay", "Brown", "longs", "yes", "images/longD.png", "my fav long dress (it's yellow)", 8);
        dresses[1]=new Dress ("summer", "semiformal", "Orange", "shorts", "no", "images/shortD.png", "my fav long dress (it's yellow)", 9);
        dresses[2]=new Dress ("spring", "formal", "White", "shorts", "yes", "images/shortD.png", "my fav long dress (it's yellow)", 10);
        dresses[3]=new Dress ("fall", "sporty", "Black", "longs", "no", "images/longD.png", "my fav long dress (it's yellow)", 11);
        Accessorize accessorizes[] = new Accessorize [4];
        accessorizes[0]=new Accessorize ("winter", "everyDay", "Pink", "belt", "yes", "images/belt.png", "beige sunglasses", 12);
        accessorizes[1]=new Accessorize ("summer", "semiformal", "Blue", "gloves", "no", "images/gloves.png", "beige sunglasses", 13);
        accessorizes[2]=new Accessorize ("spring", "formal", "Red", "purse", "yes", "images/purse.png", "beige sunglasses", 14);
        accessorizes[3]=new Accessorize ("fall", "sporty", "Yellow", "forTheHair", "no", "images/forTheHair.png", "beige sunglasses", 15);
//------------------------------------------------------------------------------------------------------
        //Crea outfit
        int i=0;
        String sT = (tops[i].getColorOfItem().name() + " "
            + tops[i].getTypeOfTop().name()
            + ", "
            + tops[i].getOccasionOfItem().name()
            + " for the "
            + tops[i].getSeasonOfItem().name()
        );
        String sB = (bottoms[i].getColorOfItem().name() + " "
            + bottoms[i].getTypeOfBottom().name()
            + ", "
            + bottoms[i].getOccasionOfItem().name()
            + " for the "
            + bottoms[i].getSeasonOfItem().name()
        );
        String sD = (dresses[i].getColorOfItem().name() + " "
            + dresses[i].getTypeOfDress().name()
            + ", "
            + dresses[i].getOccasionOfItem().name()
            + " for the "
            + dresses[i].getSeasonOfItem().name()
        );
        String sA = (accessorizes[i].getColorOfItem().name() + " "
            + accessorizes[i].getTypeOfAccesorize().name()
            + ", "
            + accessorizes[i].getOccasionOfItem().name()
            + " for the "
            + accessorizes[i].getSeasonOfItem().name()
        );


        Outfit o1 = new Outfit(0, "images/outfit.png", "My favourite winter outfit", "winter", "formal", sT + "\n" + sB + "\n" + sD + "\n" + sA);

        i=1;
         sT = (tops[i].getColorOfItem().name() + " "
            + tops[i].getTypeOfTop().name()
            + ", "
            + tops[i].getOccasionOfItem().name()
            + " for the "
            + tops[i].getSeasonOfItem().name()
        );
         sB = (bottoms[i].getColorOfItem().name() + " "
            + bottoms[i].getTypeOfBottom().name()
            + ", "
            + bottoms[i].getOccasionOfItem().name()
            + " for the "
            + bottoms[i].getSeasonOfItem().name()
        );
         sD = (dresses[i].getColorOfItem().name() + " "
            + dresses[i].getTypeOfDress().name()
            + ", "
            + dresses[i].getOccasionOfItem().name()
            + " for the "
            + dresses[i].getSeasonOfItem().name()
        );
         sA = (accessorizes[i].getColorOfItem().name() + " "
            + accessorizes[i].getTypeOfAccesorize().name()
            + ", "
            + accessorizes[i].getOccasionOfItem().name()
            + " for the "
            + accessorizes[i].getSeasonOfItem().name()
        );
        Outfit o2 = new Outfit(1, "images/outfit.png", "My favourite summer outfit", "summer", "sporty", sT + "\n" + sB + "\n" + sD + "\n" + sA);

        i=2;
         sT = (tops[i].getColorOfItem().name() + " "
            + tops[i].getTypeOfTop().name()
            + ", "
            + tops[i].getOccasionOfItem().name()
            + " for the "
            + tops[i].getSeasonOfItem().name()
        );
         sB = (bottoms[i].getColorOfItem().name() + " "
            + bottoms[i].getTypeOfBottom().name()
            + ", "
            + bottoms[i].getOccasionOfItem().name()
            + " for the "
            + bottoms[i].getSeasonOfItem().name()
        );
         sD = (dresses[i].getColorOfItem().name() + " "
            + dresses[i].getTypeOfDress().name()
            + ", "
            + dresses[i].getOccasionOfItem().name()
            + " for the "
            + dresses[i].getSeasonOfItem().name()
        );
         sA = (accessorizes[i].getColorOfItem().name() + " "
            + accessorizes[i].getTypeOfAccesorize().name()
            + ", "
            + accessorizes[i].getOccasionOfItem().name()
            + " for the "
            + accessorizes[i].getSeasonOfItem().name()
        );
        Outfit o3 = new Outfit(2, "images/outfit.png", "My favourite fall outfit", "fall", "semiformal", sT + "\n" + sB + "\n" + sD + "\n" + sA);

        i=3;
         sT = (tops[i].getColorOfItem().name() + " "
            + tops[i].getTypeOfTop().name()
            + ", "
            + tops[i].getOccasionOfItem().name()
            + " for the "
            + tops[i].getSeasonOfItem().name()
        );
         sB = (bottoms[i].getColorOfItem().name() + " "
            + bottoms[i].getTypeOfBottom().name()
            + ", "
            + bottoms[i].getOccasionOfItem().name()
            + " for the "
            + bottoms[i].getSeasonOfItem().name()
        );
         sD = (dresses[i].getColorOfItem().name() + " "
            + dresses[i].getTypeOfDress().name()
            + ", "
            + dresses[i].getOccasionOfItem().name()
            + " for the "
            + dresses[i].getSeasonOfItem().name()
        );
         sA = (accessorizes[i].getColorOfItem().name() + " "
            + accessorizes[i].getTypeOfAccesorize().name()
            + ", "
            + accessorizes[i].getOccasionOfItem().name()
            + " for the "
            + accessorizes[i].getSeasonOfItem().name()
        );
        Outfit o4 = new Outfit(3, "images/outfit.png", "My favourite spring outfit", "spring", "everyDay", sT + "\n" + sB + "\n" + sD + "\n" + sA);

        o1.addItem(tops[0]);
        o1.addItem(bottoms[0]);
        o1.addItem(dresses[0]);
        o1.addItem(accessorizes[0]);

        o2.addItem(tops[1]);
        o2.addItem(bottoms[1]);
        o2.addItem(dresses[0]);
        o2.addItem(accessorizes[1]);

        o3.addItem(tops[2]);
        o3.addItem(bottoms[2]);
        o3.addItem(dresses[0]);
        o3.addItem(accessorizes[2]);

        o4.addItem(tops[3]);
        o4.addItem(bottoms[2]);
        o4.addItem(dresses[0]);
        o4.addItem(accessorizes[3]);

//------------------------------------------------------------------------------------------------------
        //crea wardrobe 1
        Wardrobe w1 = new Wardrobe<>("irene", "irene3!", "irene@gmail.com", "3456733748");
        for (int g=0; g<4; g++){
            w1.addItem(tops[g]);
            w1.addItem(bottoms[g]);
            w1.addItem(dresses[g]);
            w1.addItem(accessorizes[g]);
        }
        w1.addOutfit(o1);
        w1.addOutfit(o2);
        w1.addOutfit(o3);
        w1.addOutfit(o4);

//------------------------------------------------------------------------------------------------------
        //crea wardrobe 2
        Wardrobe w2 = new Wardrobe<>("josephine", "jose1!", "josephine@gmail.com", "1111111111");
        for (int g=0; g<4; g++){
            w2.addItem(tops[g]);
            w2.addItem(bottoms[g]);
            w2.addItem(dresses[g]);
            w2.addItem(accessorizes[g]);
        }
        w2.addOutfit(o1);
        w2.addOutfit(o2);
        w2.addOutfit(o3);
        w2.addOutfit(o4);

//------------------------------------------------------------------------------------------------------
        //crea wardrobe 3
        Wardrobe w3 = new Wardrobe<>("user1", "psw1!", "email@gmail.com", "1111111111");
        for (int g=0; g<4; g++){
            w3.addItem(tops[g]);
            w3.addItem(bottoms[g]);
            w3.addItem(dresses[g]);
            w3.addItem(accessorizes[g]);
        }
        w3.addOutfit(o1);
        w3.addOutfit(o2);
        w3.addOutfit(o3);
        w3.addOutfit(o4);
//------------------------------------------------------------------------------------------------------
        //crea app
        App app = new App ();
        app.addWardrobe(w1);
        app.addWardrobe(w2);
        app.addWardrobe(w3);
//------------------------------------------------------------------------------------------------------
        //converte app in json e la stampa
        Gson gson = new Gson ();
        String jsonString = gson.toJson(app);

        System.out.println("App: ");
        System.out.println(jsonString);

    }

    public void testFilter2(){
        //CREATE APP
        Gson gson = new Gson ();
        //read from file
        String s="";
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
        String jsonString = s;
        App application = gson.fromJson(jsonString, App.class);
//------------------------------------------------------------
        //TEST SEARCH
        ArrayList items = application.getWardrobe(0).getItems();
        ArrayList filteredItems;
        //search color
        /*filteredItems = application.getWardrobe(0).search(items, "White");
        filteredItems = application.getWardrobe(0).search(items, "Black");
        filteredItems = application.getWardrobe(0).search(items, "Pink");
        filteredItems = application.getWardrobe(0).search(items, "Blue");
        filteredItems = application.getWardrobe(0).search(items, "Red");
        filteredItems =  application.getWardrobe(0).search(items, "Green");
        filteredItems = application.getWardrobe(0).search(items, "Beige");
        filteredItems = application.getWardrobe(0).search(items, "Brown");
        //search season
        filteredItems = application.getWardrobe(0).search(items, "winter");
        filteredItems = application.getWardrobe(0).search(items, "spring");
        filteredItems = application.getWardrobe(0).search(items, "summer");
        filteredItems = application.getWardrobe(0).search(items, "fall");
        //search occasion
        filteredItems = application.getWardrobe(0).search(items, "formal");
        filteredItems = application.getWardrobe(0).search(items, "everyDay");
        filteredItems = application.getWardrobe(0).search(items, "semiformal");
        filteredItems = application.getWardrobe(0).search(items, "sporty");
        //search type
        filteredItems = application.getWardrobe(0).search(items, "top");
        filteredItems = application.getWardrobe(0).search(items, "bottom");
        filteredItems = application.getWardrobe(0).search(items, "dress");
        filteredItems = application.getWardrobe(0).search(items, "accessorize");*/
        //search type of top

        filteredItems = application.getWardrobe(0).search(items, "tShirt");
        /*filteredItems = application.getWardrobe(0).search(items, "sweater");
        filteredItems = application.getWardrobe(0).search(items, "sweatshirtAndHoodie");
        filteredItems = application.getWardrobe(0).search(items, "topAndBody");
        filteredItems = application.getWardrobe(0).search(items, "jacketAndCoat");
        filteredItems = application.getWardrobe(0).search(items, "thankTop");
        //search type of bottom
        filteredItems = application.getWardrobe(0).search(items, "skirt");
        filteredItems = application.getWardrobe(0).search(items, "jeans");
        filteredItems = application.getWardrobe(0).search(items, "trouser");
        filteredItems = application.getWardrobe(0).search(items, "shorts");
        //search type of dress
        filteredItems = application.getWardrobe(0).search(items, "longsD");
        filteredItems = application.getWardrobe(0).search(items, "shortsD");
        //search type of accessorize
        filteredItems = application.getWardrobe(0).search(items, "jewelry");
        filteredItems = application.getWardrobe(0).search(items, "hat");
        filteredItems = application.getWardrobe(0).search(items, "belt");
        filteredItems = application.getWardrobe(0).search(items, "glasses");
        filteredItems = application.getWardrobe(0).search(items, "scarf");
        filteredItems = application.getWardrobe(0).search(items, "gloves");
        filteredItems = application.getWardrobe(0).search(items, "purse");
        filteredItems = application.getWardrobe(0).search(items, "shoes");
        filteredItems = application.getWardrobe(0).search(items, "forTheHair");
        */

        //Print all filtered items
        for (int g=0; g<filteredItems.size(); g++){
            System.out.println(filteredItems.get(g));
            System.out.println();
        }
    }
    public void test3 (){
        //CAST TEST
        Top tops[] = new Top [4];
        tops[0]=new Top ("winter", "everyDay", "White", "tShirt", "yes", "images/tShirt.png", "white sweater", 0);
        Item nI = (Item) tops[0];
        System.out.println(nI);
    }
    public void test1(){
        Gson gson = new Gson ();
        String jsonString = readFile("src\\main\\resources\\json\\app.json");
        Object o = gson.fromJson(jsonString, Object.class);
        System.out.println("Object creata");
    }
    public void test2(){
        //crea items
        Top tops[] = new Top [4];
        tops[0]=new Top ("winter", "everyDay", "White", "tShirt", "yes", "images/tShirt.png", "white sweater", 0);
        tops[1]=new Top ("summer", "semiformal", "Black", "sweater", "no", "images/sweater.png", "white sweater", 1);
        tops[2]=new Top ("spring", "formal", "Pink", "sweatshirtAndHoodie", "yes", "images/sweatshirtAndHoodie.png", "white sweater", 2);
        tops[3]=new Top ("fall", "sporty", "Blue", "jacketAndCoat", "no", "images/jacketAndCoat.png", "white sweater", 3);
        Bottom bottoms[] = new Bottom [4];
        bottoms[0]=new Bottom ("winter", "everyDay", "Red", "skirt", "yes", "images/skirt.png", "blue trouser", 4);
        bottoms[1]=new Bottom ("summer", "semiformal", "Yellow", "jeans", "no", "images/jeans.png", "blue trouser", 5);
        bottoms[2]=new Bottom ("spring", "formal", "Green", "trouser", "yes", "images/trouser.png", "blue trouser", 6);
        bottoms[3]=new Bottom ("fall", "sporty", "Beige", "shorts", "no", "images/shorts.png", "blue trouser", 7);
        Dress dresses[] = new Dress [4];
        dresses[0]=new Dress ("winter", "everyDay", "Brown", "longs", "yes", "images/longD.png", "my fav long dress (it's yellow)", 8);
        dresses[1]=new Dress ("summer", "semiformal", "Orange", "shorts", "no", "images/shortD.png", "my fav long dress (it's yellow)", 9);
        dresses[2]=new Dress ("spring", "formal", "White", "shorts", "yes", "images/shortD.png", "my fav long dress (it's yellow)", 10);
        dresses[3]=new Dress ("fall", "sporty", "Black", "longs", "no", "images/longD.png", "my fav long dress (it's yellow)", 11);
        Accessorize accessorizes[] = new Accessorize [4];
        accessorizes[0]=new Accessorize ("winter", "everyDay", "Pink", "belt", "yes", "images/belt.png", "beige sunglasses", 12);
        accessorizes[1]=new Accessorize ("summer", "semiformal", "Blue", "gloves", "no", "images/gloves.png", "beige sunglasses", 13);
        accessorizes[2]=new Accessorize ("spring", "formal", "Red", "purse", "yes", "images/purse.png", "beige sunglasses", 14);
        accessorizes[3]=new Accessorize ("fall", "sporty", "Yellow", "forTheHair", "no", "images/forTheHair.png", "beige sunglasses", 15);
//------------------------------------------------------------------------------------------------------
        //crea wardrobe 1
        Wardrobe w1 = new Wardrobe<>("irene", "irene3!", "irene@gmail.com", "3456733748");
        for (int i=0; i<4; i++){
            w1.addItem(tops[i]);
            w1.addItem(bottoms[i]);
            w1.addItem(dresses[i]);
            w1.addItem(accessorizes[i]);
        }

//------------------------------------------------------------------------------------------------------
        //crea wardrobe 2
        Wardrobe w2 = new Wardrobe<>("josephine", "jose1!", "josephine@gmail.com", "1111111111");
        for (int i=0; i<4; i++){
            w2.addItem(tops[i]);
            w2.addItem(bottoms[i]);
            w2.addItem(dresses[i]);
            w2.addItem(accessorizes[i]);
        }

//------------------------------------------------------------------------------------------------------
        //crea wardrobe 3
        Wardrobe w3 = new Wardrobe<>("user1", "psw1!", "email@gmail.com", "1111111111");
        for (int i=0; i<4; i++){
            w3.addItem(tops[i]);
            w3.addItem(bottoms[i]);
            w3.addItem(dresses[i]);
            w3.addItem(accessorizes[i]);
        }
//------------------------------------------------------------------------------------------------------
        //crea app
        App app = new App ();
        app.addWardrobe(w1);
        app.addWardrobe(w2);
        app.addWardrobe(w3);
//------------------------------------------------------------------------------------------------------
        //converte app in json e la stampa
        Gson gson = new Gson ();
        String jsonString = gson.toJson(app);

        System.out.println("App: ");
        System.out.println(jsonString);
//------------------------------------------------------------------------------------------------------
        //converte wardrobe in json e la stampa
        gson = new Gson ();
        jsonString = gson.toJson(tops[0]);

        System.out.println("Top: ");
        System.out.println(jsonString);

        jsonString = gson.toJson(bottoms[0]);
        System.out.println("\nBottom: ");
        System.out.println(jsonString);

        jsonString = gson.toJson(dresses[0]);
        System.out.println("\nDress: ");
        System.out.println(jsonString);

        jsonString = gson.toJson(accessorizes[0]);
        System.out.println("\nAccessory: ");
        System.out.println(jsonString);
    }
    /**
     * Crea e stampa array di items
     */
    public void creaItems(){
        Top tops[] = createTop();
        Bottom bottoms[] = createBottom();
        Dress dresses[] = createDress();
        Accessorize accessorizes[] = createAccessorize();

        /*for (int i=0; i<4; i++){
            System.out.println(tops[i]);
            System.out.println();
            System.out.println(bottoms[i]);
            System.out.println();
            System.out.println(dresses[i]);
            System.out.println();
            System.out.println(accessorizes[i]);
            System.out.println();
        }*/
    }

    /**
     * Crea Top
     * @return
     */
    public Top [] createTop(){
        Top tops[] = new Top [4];
        tops[0]=new Top ("Winter", "everyDay", "White", "sweater", "yes", "sweater.jpg", "white sweater", 0);
        tops[1]=new Top ("Winter", "everyDay", "White", "sweater", "yes", "sweater.jpg", "white sweater", 1);
        tops[2]=new Top ("Winter", "everyDay", "White", "sweater", "yes", "sweater.jpg", "white sweater", 2);
        tops[3]=new Top ("Winter", "everyDay", "White", "sweater", "yes", "sweater.jpg", "white sweater", 3);

        return tops;
    }
    /**
     * Crea Bottom
     */
    public Bottom [] createBottom(){
        Bottom bottoms[] = new Bottom [4];
        bottoms[0]=new Bottom ("summer", "semiformal", "Blue", "trouser", "no", "trouser.jpg", "blue trouser", 4);
        bottoms[1]=new Bottom ("summer", "everyDay", "Blue", "trouser", "no", "trouser.jpg", "blue trouser", 5);
        bottoms[2]=new Bottom ("summer", "semiformal", "Blue", "trouser", "no", "trouser.jpg", "blue trouser", 6);
        bottoms[3]=new Bottom ("summer", "semiformal", "Blue", "trouser", "no", "trouser.jpg", "blue trouser", 7);

        return bottoms;
    }
    /**
     * Crea Dress
     */
    public Dress[] createDress(){
        Dress dresses[] = new Dress [4];
        dresses[0]=new Dress ("spring", "everyDay", "Yellow", "longs", "yes", "longD.jpg", "my fav long dress (it's yellow)", 8);
        dresses[1]=new Dress ("summer", "formal", "Yellow", "longs", "yes", "longD.jpg", "my fav long dress (it's yellow)", 9);
        dresses[2]=new Dress ("spring", "formal", "Yellow", "longs", "yes", "longD.jpg", "my fav long dress (it's yellow)", 10);
        dresses[3]=new Dress ("spring", "formal", "Yellow", "longs", "yes", "longD.jpg", "my fav long dress (it's yellow)", 11);

        return dresses;
    }
    /**
     * Crea Accessorize
     */
    public Accessorize [] createAccessorize(){
        Accessorize accessorizes[] = new Accessorize [4];
        accessorizes[0]=new Accessorize ("fall", "sporty", "Beige", "glasses", "no", "glasses.jpg", "beige sunglasses", 12);
        accessorizes[1]=new Accessorize ("fall", "sporty", "Beige", "glasses", "no", "glasses.jpg", "beige sunglasses", 13);
        accessorizes[2]=new Accessorize ("fall", "sporty", "Beige", "glasses", "no", "glasses.jpg", "beige sunglasses", 14);
        accessorizes[3]=new Accessorize ("fall", "sporty", "Beige", "glasses", "no", "glasses.jpg", "beige sunglasses", 15);

        return accessorizes;
    }

    /**
     * crea wardrobes
     */
    public Wardrobe createWardrobe(Top tops[], Bottom bottoms[], Dress dresses [], Accessorize accessorizes [], String user, String psw, String email, String phone ){
        Wardrobe w = new Wardrobe<>(user, psw, email, phone);
        //Wardrobe w1 = new Wardrobe<>("irene", "irene3!", "email@gmail.com", "3456733748");
        //Wardrobe w2 = new Wardrobe<>("josephine", "josephine1!", "josephine@gmail.com", "1111111111");
        for (int i=0; i<4; i++){
            w.addItem(tops[i]);
            w.addItem(bottoms[i]);
            w.addItem(dresses[i]);
            w.addItem(accessorizes[i]);
        }

        return w;
    }

    /**
     * serialization obj -> json
     */
    public void serializationEx(){
        Object o = new Object();
        Gson gson = new Gson ();
        String jsonString = gson.toJson(o);

        //System.out.println(json);
    }

    /**
     * deserialization json -> obj
     */
    public void deserializationEx(){
        Gson gson = new Gson ();
        String jsonString = ""; //can be read from file
        Object o = gson.fromJson(jsonString, Object.class);
        System.out.println("Object creata");
    }

    /**
     * Print all items of the wardrobe
     */
    public void printAll(Wardrobe w){
        for (int i=0; i<w.getItems().size(); i++){
            System.out.println(w.getItems().get(i));
            System.out.println();
        }
    }

    /**
     * Tests the search method
     */
    public void testFilter(){
        Top tops[] = createTop();
        Bottom bottoms[] = createBottom();
        Dress dresses[] = createDress ();
        Accessorize accessorizes[] = createAccessorize ();

        Wardrobe w = createWardrobe(tops, bottoms, dresses, accessorizes, "irene", "irene3!", "email@gmail.com", "3456733748");

        ArrayList <Item> allItems = w.getItems();
        ArrayList <Item> filteredItems = new ArrayList<>();
        filteredItems=w.search(w.getItems(), "top");
            /*filteredItems=w.search(w.getItems(), "top");
            filteredItems=w.search(w.getItems(), "bottom");
            filteredItems=w.search(w.getItems(), "dress");
            filteredItems=w.search(w.getItems(), "accessorize");
            filteredItems=w.search(w.getItems(), "summer");
            filteredItems=w.search(w.getItems(), "everyDay");*/

        for (int i=0; i<filteredItems.size(); i++){
            System.out.println(filteredItems.get(i));
            System.out.println();
        }
    }

    /**
     * Write into a file
     * @parameter path: file path
     */
    public void writeFile(String path, String sTW){
        FileWriter fw = null;
        String stringToWrite = sTW;
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


    }

    /**
     * Read from a file
     */
    public String readFile (String path){
        String s="";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path)); //"src\\main\\resources\\json\\app.json"));
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
     * Support method for uploadApp in Start.java
     */
    /*public void convertArray(){
        for (int i=0; i<wardrobes.size(); i++){ //repete for all wardrobes
            for (int g=0; g<wardrobes.get(i).getItems().size(); g++){ //repete for all items of the wardrobe
                String type = wardrobes.get(i).getItems().get(g).getType();
                switch(type){
                    case "top":{
                        Top nT = (Top) wardrobes.get(i).getItems().get(g);
                        wardrobes.get(i).getItems().set(g, nT);
                        break;
                    }
                    case "bottom":{
                        Bottom nB = (Bottom) wardrobes.get(i).getItems().get(g);
                        wardrobes.get(i).getItems().set(g, nB);
                        break;
                    }
                    case "dress":{
                        Dress nD = (Dress) wardrobes.get(i).getItems().get(g);
                        wardrobes.get(i).getItems().set(g, nD);
                        break;
                    }
                    case "accessorize":{
                        Accessorize nA = (Accessorize) wardrobes.get(i).getItems().get(g);
                        wardrobes.get(i).getItems().set(g, nA);
                        break;
                    }
                }
            }
        }
    }*/
}
