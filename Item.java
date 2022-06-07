import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Item {
    private Seasons seasonOfItem;
    private Occasions occasionOfItem;
    private Colors colorOfItem;
    private boolean favourite;
    private Image picture;
    private String description;
    
    //constructor with description
    public Item(Seasons selectedSeason, Occasions selectedOccasion, Colors selectedColor, String filename, String description) {
        setSeasonOfItem(selectedSeason);
        setOccasionOfItem(selectedOccasion);
        setColorOfItem(selectedColor);
        try {
			setPicture (filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();// TODO Auto-generated catch block
		}
        setFavourite(false);
        setDescription(description);
    }
    
    //constructor without description
    public Item(Seasons selectedSeason, Occasions selectedOccasion, Colors selectedColor, String filename){
        setSeasonOfItem(selectedSeason);
        setOccasionOfItem(selectedOccasion);
        setColorOfItem(selectedColor);
        try {
			setPicture (filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();// TODO Auto-generated catch block
		}
        setFavourite(false);
        setDescription("");
    }

    //getter and setters
    public Seasons getSeasonOfItem() {
        return seasonOfItem;
    }
    public void setSeasonOfItem(Seasons selectedSeason) {
        this.seasonOfItem = selectedSeason;
    }

    public Colors getColorOfItem() {
        return colorOfItem;
    }
    public void setColorOfItem(Colors selectedColor) {
        this.colorOfItem = selectedColor;
    }

    public Occasions getOccasionOfItem() {
        return occasionOfItem;
    }
    public void setOccasionOfItem(Occasions selectedOccasion) {
        this.occasionOfItem = selectedOccasion;
    }
    
    public boolean getFavourite(){
        return(favourite);
    }
    public void setFavourite (boolean tf){
        favourite = tf;
    }
    
    public void setPicture (String filename) throws FileNotFoundException {
    	this.picture = new Image (new FileInputStream(filename));
    }
    public Image getPicture () {
		return picture;
	}

    public void setDescription(String description) {
    	this.description=description;
    }
    public String getDescription () {
    	return description;
    }
}
