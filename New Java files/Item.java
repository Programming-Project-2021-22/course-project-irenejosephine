import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Item<T> {
    private Seasons seasonOfItem;
    private Occasions occasionOfItem;
    private Colors colorOfItem;
    private boolean favourite;
	//private Image picture;
    private String description, picture;
	
     
    //constructor with description
    public Item(String selectedSeason, String selectedOccasion, String selectedColor, String favourite, String filename, String description) {
        setSeasonOfItem(selectedSeason);
        setOccasionOfItem(selectedOccasion);
        setColorOfItem(selectedColor);
        setPicture (filename);
        setFavourite(favourite);
        setDescription(description);
    }
    
    //constructor without description
    public Item(String selectedSeason, String selectedOccasion, String selectedColor, String favourite, String filename){
        this(selectedSeason, selectedOccasion, selectedColor, favourite,  filename, "");
    }

	//constructor from file
    public Item(String filename){

		//TODO
        //this(selectedSeason, selectedOccasion, selectedColor, filename, "");
    }

    //getter and setters
    public Seasons getSeasonOfItem() {
        return seasonOfItem;
    }
    public void setSeasonOfItem(String selectedSeason) {
    	selectedSeason = selectedSeason.toLowerCase();
    	switch (selectedSeason) {
	        case "winter" : {
	        	this.seasonOfItem = Seasons.winter;
				break;
	        }
			case "spring" : {
				this.seasonOfItem = Seasons.spring;
				break;
	        }
			case "summer" : {
				this.seasonOfItem = Seasons.summer;
				break;
			}
			case "fall" : {
				this.seasonOfItem = Seasons.fall;
				break;
			}
        }
    }

    public Colors getColorOfItem() {
        return colorOfItem;
    }
    public void setColorOfItem(String selectedColor) {
    	selectedColor = selectedColor.toLowerCase();

    	switch (selectedColor) {
	        case "white" : {
	        	this.colorOfItem = Colors.White;
				break;
	        }
			case "black" : {
				this.colorOfItem = Colors.Black;
				break;
	        }
			case "pink" : {
				this.colorOfItem = Colors.Pink;
				break;
			}
			case "blue" : {
				this.colorOfItem = Colors.Blue;
				break;
			}
			case "red" : {
	        	this.colorOfItem = Colors.Red;
				break;
	        }
			case "yellow" : {
				this.colorOfItem = Colors.Yellow;
				break;
	        }
			case "green" : {
				this.colorOfItem = Colors.Green;
				break;
			}
			case "beige" : {
				this.colorOfItem = Colors.Beige;
				break;
			}
			case "brown" : {
	        	this.colorOfItem = Colors.Brown;
				break;
	        }
			case "orange" : {
	        	this.colorOfItem = Colors.Orange;
				break;
	        }
    	}   
    }

    public Occasions getOccasionOfItem() {
        return occasionOfItem;
    }
    public void setOccasionOfItem(String selectedOccasion) {
    	selectedOccasion = selectedOccasion.toLowerCase();
    	switch (selectedOccasion) {
	        case "formal" : {
	        	this.occasionOfItem = Occasions.formal;
				break;
	        }
			case "everyday" : {
				this.occasionOfItem = Occasions.everyDay;
				break;
	        }
			case "semiformal" : {
				this.occasionOfItem = Occasions.semiformal;
				break;
			}
			case "sporty" : {
				this.occasionOfItem = Occasions.sporty;
				break;
			}
    	} 
    }
    
    public boolean getFavourite(){
        return(favourite);
    }
    public void setFavourite (String favourite){
    	favourite = favourite.toLowerCase();
    	switch (favourite) {
	        case "yes" : {
	        	this.favourite = true;
				break;
	        }
			case "no" : {
				this.favourite = false;
				break;
	        }
    	}
    }
    
    public void setPicture (String filename){// throws FileNotFoundException {
    	this.picture = filename; //new Image (new FileInputStream(filename));
    }
    public String getPicture () {
		return picture;
	}

    public void setDescription(String description) {
    	this.description=description;
    }
    public String getDescription () {
    	return description;
    }

	@Override
	public String toString (){
		return ("Description:" + getDescription() +
		"\nColor: " + getColorOfItem() + 
		"\nSeason: "  + getSeasonOfItem() + 
		"\nOccasion: " + getOccasionOfItem() );
	}    
}
