package app;

import java.util.ArrayList;

public class Outfit {
    private String name, description;
    private ArrayList <Item> items = new ArrayList<>();
    private Seasons seasonOfOutfit;
    private Occasions occasionOfOutfit;
    private Colors colorOfOutfit;

    //constructor with description
    public Outfit(String name, String description, String selectedSeason, String selectedOccasion, String selectedColor) {
        this.name = name;
        this.description = description;
        setSeasonOfOutfit(selectedSeason);
        setOccasionOfOutfit(selectedOccasion);
        setColorOfOutfit(selectedColor);
    }
    //constructor without description
    public Outfit(String name, String selectedSeason, String selectedOccasion, String selectedColor) {
        this.name = name;
        this.description = "";
        setSeasonOfOutfit(selectedSeason);
        setOccasionOfOutfit(selectedOccasion);
        setColorOfOutfit(selectedColor);
    }

    //getter and setters
    public Seasons getSeasonOfOutfit() {
        return seasonOfOutfit;
    }
    public void setSeasonOfOutfit(String selectedSeason) {
    	selectedSeason = selectedSeason.toLowerCase();
    	switch (selectedSeason) {
	        case "winter" : {
	        	this.seasonOfOutfit = Seasons.winter;
				break;
	        }
			case "spring" : {
				this.seasonOfOutfit = Seasons.spring;
				break;
	        }
			case "summer" : {
				this.seasonOfOutfit = Seasons.summer;
				break;
			}
			case "fall" : {
				this.seasonOfOutfit = Seasons.fall;
				break;
			}
        }
    }

    public Colors getColorOfOutfit() {
        return colorOfOutfit;
    }
    public void setColorOfOutfit(String selectedColor) {
    	selectedColor = selectedColor.toLowerCase();
    	switch (selectedColor) {
	        case "white" : {
	        	this.colorOfOutfit = Colors.White;
				break;
	        }
			case "black" : {
				this.colorOfOutfit = Colors.Black;
				break;
	        }
			case "pink" : {
				this.colorOfOutfit = Colors.Pink;
				break;
			}
			case "blue" : {
				this.colorOfOutfit = Colors.Blue;
				break;
			}
			case "red" : {
	        	this.colorOfOutfit = Colors.Red;
				break;
	        }
			case "yellow" : {
				this.colorOfOutfit = Colors.Yellow;
				break;
	        }
			case "green" : {
				this.colorOfOutfit = Colors.Green;
				break;
			}
			case "beige" : {
				this.colorOfOutfit = Colors.Beige;
				break;
			}
			case "brown" : {
	        	this.colorOfOutfit = Colors.Brown;
				break;
	        }
			case "orange" : {
	        	this.colorOfOutfit = Colors.Orange;
				break;
	        }
    	}
    }

    public Occasions getOccasionOfOutfit() {
        return occasionOfOutfit;
    }
    public void setOccasionOfOutfit(String selectedOccasion) {
    	selectedOccasion = selectedOccasion.toLowerCase();
    	switch (selectedOccasion) {
	        case "formal" : {
	        	this.occasionOfOutfit = Occasions.formal;
				break;
	        }
			case "everyday" : {
				this.occasionOfOutfit = Occasions.everyDay;
				break;
	        }
			case "semiformal" : {
				this.occasionOfOutfit = Occasions.semiformal;
				break;
			}
			case "sporty" : {
				this.occasionOfOutfit = Occasions.sporty;
				break;
			}
    	}
    }

    public String getName (){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription (){
        return description;
    }
    public void setDescription (String description) {
        this.description = description;
    }


    //Add a new item to the outfit
    public void addItem(Item newItem){
        items.add(newItem);
    }

    //Remove a item from the outfit
    public void removeItem(int index){
        items.remove(index);
    }


}


