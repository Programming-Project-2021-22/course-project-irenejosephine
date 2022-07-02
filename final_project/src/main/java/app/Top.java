package app;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The app.Top class represent a app.Top item.
 * It extends the app.Item abstract class and its methods but implement an additional instance data typeofTop
 * @author Irene Avezzù
*/

public class Top extends Item{
    private topType typeOfTop;

    /**
     * This is the constructor that gets seven String elements as parameters and assign them to the instance data of the class
     * @param selectedSeason
     * @param selectedOccasion
     * @param selectedColor
     * @param selectedType
     * @param favourite
     * @param filename
     * @param description
     */
    public Top(String selectedSeason, String selectedOccasion, String selectedColor, String selectedType, String favourite, String filename, String description) {
        super(selectedSeason, selectedOccasion, selectedColor, favourite, filename, description);
        setTypeOfTop(selectedType);
    }

    /**
     * Constructor form file json
     * @param filename
     */
    public Top(String filename) {
        super("winter", "formal", "red", "yes", "", "");
        setTypeOfTop("tshirt");
        createFromFile(filename);
    }

    /**
     * Create a new Top object from a json file and assign its value to the current accessorize object
     * @param filename: json file
     */
    public void createFromFile(String filename) {
        String strT, sS, sO, sC, sT, f, pFN, d;
        Scanner file;
        Gson gson;
        Top t1;

        try {
            //read string from file
            file = new Scanner(new File(filename));
            strT = file.nextLine();
            strT.replace("\"", "'");

            //convert the string into an app.Accessorize object
            gson = new Gson ();
            t1 = gson.fromJson(strT, Top.class);

            // once the obj is created from the json file its value are assigned to the current object
            sS=t1.getSeasonOfItem().name();
            sO=t1.getOccasionOfItem().name();
            sC=t1.getColorOfItem().name();
            sT=t1.getTypeOfTop().name();
            f=((t1.getFavourite())==true ? "yes" : "no");
            pFN=t1.getPicture();
            d=t1.getDescription();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter of typeOfTop
     * @return typeOfTop
     */
    public topType getTypeOfTop() {
        return typeOfTop;
    }
     /**
     * Setter of typeOfTop, a string is passed as parameter and, based on its value, the typeOfTop is set
     * @param tOT
     */
    public void setTypeOfTop(String tOT) {
        switch (tOT){
            case "tShirt":{
                this.typeOfTop = topType.tShirt;
                break;
            }
            case "sweater":{
                this.typeOfTop = topType.sweater;
                break;
            }
            case "sweatshirtAndHoodie":{
                this.typeOfTop = topType.sweatshirtAndHoodie;
                break;
            }
            case "topAndBody" :{
                this.typeOfTop = topType.topAndBody;
                break;
            }
            case "jacketAndCoat":{
                this.typeOfTop = topType.jacketAndCoat;
                break;
            }
            case "tankTop":{
                this.typeOfTop = topType.tankTop;
                break;
            }
        }
    }

    /**
     * Overwritten toString method
     */
    @Override
    public String toString (){
        return ("Type of top: " + getTypeOfTop() +
        "\nDescription:" + getDescription() +
		"\nColor: " + getColorOfItem() +
		"\nSeason: "  + getSeasonOfItem() +
		"\nOccasion: " + getOccasionOfItem() );

    }

}
