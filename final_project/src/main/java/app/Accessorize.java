package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;

//import com.google.gson.Gson;

/**
 * The app.Accessorize class represent an accessory item.
 * It extends the app.Item abstract class and its methods  but implement an additional instance data typeOfAccessorize
  * @author Irene Avezzù
*/
public class Accessorize extends Item {
    private accessorizeType typeOfAccessorize;

    /**
     * This is the constructor that gets seven String elements as parameters and assign them to the instance data of
     * the class
     * @param selectedSeason
     * @param selectedOccasion
     * @param selectedColor
     * @param selectedType
     * @param favourite
     * @param filename
     * @param description
     */
    public Accessorize(String selectedSeason, String selectedOccasion, String selectedColor, String selectedType, String favourite, String filename, String description ) {
        super(selectedSeason, selectedOccasion, selectedColor, favourite, filename, description);
        setTypeOfAccesorize(selectedType);
    }

    /**
     * Constructor form file json
     * @param filename
     */
    public Accessorize(String filename) {
        super("winter", "formal", "red", "yes", "", "");
        setTypeOfAccesorize("glasses");

        createFromFile(filename);
   }

    /**
     * Create a new Accessorize object from a json file and assign its value to the current accessorize object
     * @param filename: json file
     */
    public void createFromFile(String filename) {
        String sA, sS, sO, sC, sT, f, pFN, d;
        Scanner file;
        Gson gson;
        Accessorize a1;

        try {
            //read string from file
             file = new Scanner(new File(filename));
            sA = file.nextLine();
            sA.replace("\"", "'");

            //convert the string into an app.Accessorize object
            gson = new Gson ();
            a1 = gson.fromJson(sA, Accessorize.class);

            // once the obj is created from the json file its value are assigned to the current object
            sS=a1.getSeasonOfItem().name();
            sO=a1.getOccasionOfItem().name();
            sC=a1.getColorOfItem().name();
            sT=a1.getTypeOfAccesorize().name();
            f=((a1.getFavourite())==true ? "yes" : "no");
            pFN=a1.getPicture();
            d=a1.getDescription();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Getter of typeOfAccessorize
     * @return typeOfAccessorize
     */
    public accessorizeType getTypeOfAccesorize() {
        return typeOfAccessorize;
    }

    /**
     * Setter of typeOfAccessorize, a string is passed as parameter and, based on its value, the typeOfAccessorize is set
     * @param tOA
     */
    public void setTypeOfAccesorize(String tOA) {
        switch (tOA){
            case "jewelry":{
                this.typeOfAccessorize = accessorizeType.jewelry;
                break;
            }
            case "hat":{
                this.typeOfAccessorize = accessorizeType.hat;
                break;
            }
            case "belt":{
                this.typeOfAccessorize = accessorizeType.belt;
                break;
            }
            case "glasses" :{
                this.typeOfAccessorize = accessorizeType.glasses;
                break;
            }
            case "scarf":{
                this.typeOfAccessorize = accessorizeType.scarf;
                break;
            }
            case "gloves":{
                this.typeOfAccessorize = accessorizeType.gloves;
                break;
            }
            case "purse":{
                this.typeOfAccessorize = accessorizeType.purse;
                break;
            }
            case "shoes" :{
                this.typeOfAccessorize = accessorizeType.shoes;
                break;
            }
            case "forTheHair" :{
                this.typeOfAccessorize = accessorizeType.forTheHair;
                break;
            }
        }
    }

    /**
     * Overwritten toString method
     */
    @Override
    public String toString (){
        return ("Type of accessorize: " + getTypeOfAccesorize() +
        "\nDescription:" + getDescription() +
		"\nColor: " + getColorOfItem() +
		"\nSeason: "  + getSeasonOfItem() +
		"\nOccasion: " + getOccasionOfItem() );

    }
}
