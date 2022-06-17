package app;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The app.Bottom class represent an accessory item.
 * It extends the app.Item abstract class and its methods  but implement an additional instance data typeOfBottom
 * @author Irene Avezzù
*/

public class Bottom extends Item {
    private bottomType typeOfBottom;

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
    public Bottom (String selectedSeason, String selectedOccasion, String selectedColor, String selectedType, String favourite, String filename, String description) {
    	super(selectedSeason, selectedOccasion, selectedColor, favourite, filename, description);
    	setTypeOfBottom(selectedType);
    }

    /**
     * This is the constructor that gets six String elements as parameters and assign them to the instance data of the class
     * The parameter "description" is not passed so this.description is set by default to an empty string
     * @param selectedSeason
     * @param selectedOccasion
     * @param selectedColor
     * @param selectedType
     * @param favourite
     * @param filename
     */
    public Bottom(String selectedSeason, String selectedOccasion, String selectedColor, String selectedType, String favourite, String filename) {
        this(selectedSeason, selectedOccasion, selectedColor, selectedType, favourite, filename, "");
    }

    /**
     * Constructor form file json
     * @param filename
     */
    public Bottom(String filename) {
        super("winter", "formal", "red", "yes", "", "");
        setTypeOfBottom("jeans");
        createFromFile(filename);
    }

    /**
     * Create a new Bottom object from a json file and assign its value to the current accessorize object
     * @param filename: json file
     */
    public void createFromFile(String filename) {
        String sB, sS, sO, sC, sT, f, pFN, d;
        Scanner file;
        Gson gson;
        Bottom b1;

        try {
            //read string from file
            file = new Scanner(new File(filename));
            sB = file.nextLine();
            sB.replace("\"", "'");

            //convert the string into an app.Accessorize object
            gson = new Gson ();
            b1 = gson.fromJson(sB, Bottom.class);

            // once the obj is created from the json file its value are assigned to the current object
            sS=b1.getSeasonOfItem().name();
            sO=b1.getOccasionOfItem().name();
            sC=b1.getColorOfItem().name();
            sT=b1.getTypeOfBottom().name();
            f=((b1.getFavourite())==true ? "yes" : "no");
            pFN=b1.getPicture();
            d=b1.getDescription();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter of typeOfBottom
     * @return typeOfBottom
     */
    public bottomType getTypeOfBottom() {
        return typeOfBottom;
    }

    /**
     * Setter of typeOfBottom, a string is passed as parameter and, based on its value, the typeOfBottom is set
     * @param tOB
     */
    public void setTypeOfBottom(String tOB) {
        switch (tOB){
            case "skirt":{
                this.typeOfBottom = bottomType.skirt;
                break;
            }
            case "jeans":{
                this.typeOfBottom = bottomType.jeans;
                break;
            }
            case "trouser":{
                this.typeOfBottom = bottomType.trouser;
                break;
            }
            case "shorts" :{
                this.typeOfBottom = bottomType.shorts;
                break;
            }
        }
    }

    /**
     * Overwritten toString method
     */
    @Override
    public String toString (){
        return ("Type of bottom: " + getTypeOfBottom() +
        "\nDescription:" + getDescription() +
		"\nColor: " + getColorOfItem() +
		"\nSeason: "  + getSeasonOfItem() +
		"\nOccasion: " + getOccasionOfItem() );

    }

}
