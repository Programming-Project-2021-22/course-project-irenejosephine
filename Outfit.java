import java.util.ArrayList;

public class Outfit {
    private String name, description;
    private ArrayList <Item> items = new ArrayList<>();
    private Seasons seasonOfOutfit;
    private Occasions occasionOfOutfit;
    private Colors colorOfOutfit;

    //constructor with description
    public Outfit(String name, String description, Seasons selectedSeason, Occasions selectedOccasion, Colors selectedColor) {
        this.name = name;
        this.description = description;        
        setSeasonOfOutfit(selectedSeason);
        setOccasionOfOutfit(selectedOccasion);
        setColorOfOutfit(selectedColor);
    }
    //constructor without description
    public Outfit(String name, Seasons selectedSeason, Occasions selectedOccasion, Colors selectedColor) {
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
    public void setSeasonOfOutfit(Seasons selectedSeason) {
        this.seasonOfOutfit = selectedSeason;
    }

    public Colors getColorOfOutfit() {
        return colorOfOutfit;
    }
    public void setColorOfOutfit(Colors selectedColor) {
        this.colorOfOutfit = selectedColor;
    }

    public Occasions getOccasionOfOutfit() {
        return occasionOfOutfit;
    }
    public void setOccasionOfOutfit(Occasions selectedOccasion) {
        this.occasionOfOutfit = selectedOccasion;
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

  
    