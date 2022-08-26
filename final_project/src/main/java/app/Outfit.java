package app;

import java.util.ArrayList;

public class Outfit {
    private String  description, picture, description2;
    private int id =0;
    private ArrayList <Item> items = new ArrayList<>();
    private Seasons seasonOfOutfit;
    private Occasions occasionOfOutfit;

    //constructor
    public Outfit(int id, String picture, String description, String selectedSeason, String selectedOccasion, String description2) {
        setId(id);
        this.picture = picture;
        this.description = description;
        setSeasonOfOutfit(selectedSeason);
        setOccasionOfOutfit(selectedOccasion);
        this.description2=description2;
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

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getPicture(){
        return picture;
    }
    public void setPicture(String picture){
        this.picture = picture;
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

    public String toString (){
        String itemsDescriptions = "";
        for (int i=0; i<items.size(); i++){
            itemsDescriptions+="\n" + items.get(i).getDescription();
        }
        return (
            "Description: " + getDescription() +
                "\nSeason: "  + getSeasonOfOutfit() +
                "\nOccasion: " + getOccasionOfOutfit() +
                "\nThe items that compone this outfit are: " + description2
            );
    }
}


