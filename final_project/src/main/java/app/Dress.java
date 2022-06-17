package app;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The app.Dress class represent an accessory item.
 * It extends the app.Item abstract class and its methods but implement an additional instance data typeOfAccessorize
 * @author Irene Avezzù
 */

public class Dress extends Item{
    private dressType typeOfDress;

    /**
     * This is the constructor that gets seven String elements as parameters and assign them to the instance data of the class
     * @param selectedSeason
     * @param selectedOccasion
     * @param selectedColor
     * @param selectedType
     * @param filename
     * @param description
     */
    public Dress (String selectedSeason, String selectedOccasion, String selectedColor, String selectedType, String favourite, String filename, String description) {
    	super(selectedSeason, selectedOccasion, selectedColor, favourite, filename, description);
    	setTypeOfDress(selectedType);
    }
    /**
     * This is the constructor that gets six String elements as parameters and assign them to the instance data of the class
     * The parameter "description" is not passed so this.description is set by default to an empty string
     * @param selectedSeason
     * @param selectedOccasion
     * @param selectedColor
     * @param selectedType
     * @param filename
     */
    public Dress(String selectedSeason, String selectedOccasion, String selectedColor, String selectedType, String favourite, String filename) {
        this(selectedSeason, selectedOccasion, selectedColor, selectedType, favourite, filename, "");
    }

    /**
     * Constructor form file json
     * @param filename
     */
    public Dress(String filename) {
        super("winter", "formal", "red", "yes", "", "");
        setTypeOfDress("longs");
        createFromFile(filename);
    }

    /**
     * Create a new Dress object from a json file and assign its value to the current accessorize object
     * @param filename: json file
     */
    public void createFromFile(String filename) {
        String sD, sS, sO, sC, sT, f, pFN, d;
        Scanner file;
        Gson gson;
        Dress d1;

        try {
            //read string from file
            file = new Scanner(new File(filename));
            sD = file.nextLine();
            sD.replace("\"", "'");

            //convert the string into an app.Accessorize object
            gson = new Gson ();
            d1 = gson.fromJson(sD, Dress.class);

            // once the obj is created from the json file its value are assigned to the current object
            sS=d1.getSeasonOfItem().name();
            sO=d1.getOccasionOfItem().name();
            sC=d1.getColorOfItem().name();
            sT=d1.getTypeOfDress().name();
            f=((d1.getFavourite())==true ? "yes" : "no");
            pFN=d1.getPicture();
            d=d1.getDescription();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter of typeOfDress
     * @return typeOfDress
     */
    public dressType getTypeOfDress() {
        return typeOfDress;
    }

    /**
     * Setter of typeOfDress, a string is passed as parameter and, based on its value, the typeOfDress is set
     * @param tOD
     */
    public void setTypeOfDress(String tOD) {
        switch (tOD){
            case "longs":{
                this.typeOfDress = dressType.longs;
                break;
            }
            case "shorts":{
                this.typeOfDress = dressType.shorts;
                break;
            }
        }
    }
    /**
     * Overwritten toString method
     */
    @Override
    public String toString (){
        return ("Type of dress: " + getTypeOfDress() +
        "\nDescription:" + getDescription() +
		"\nColor: " + getColorOfItem() +
		"\nSeason: "  + getSeasonOfItem() +
		"\nOccasion: " + getOccasionOfItem() );

    }
}
