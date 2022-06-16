public class Dress extends Item{
	enum Type {longs, shorts}
    private Type typeOfDress;

    //constructor with description
    public Dress (String selectedSeason, String selectedOccasion, String selectedColor, String selectedType, String filename, String description) {
    	super(selectedSeason, selectedOccasion, selectedColor, filename, description);
    	setTypeOfBottom(selectedType);
    }
    
    //constructor without description
    public Dress(String selectedSeason, String selectedOccasion, String selectedColor, String selectedType, String filename) {
        this(selectedSeason, selectedOccasion, selectedColor, selectedType, filename, "");
    }

    //getter and setter
    public Type getTypeOfDress() {
        return typeOfDress;
    }
    public void setTypeOfBottom(String typeOfBottom) {
        switch (typeOfBottom){  
            case "longs":{ 
                this.typeOfDress = Type.longs;
                break;
            }
            case "shorts":{   
                this.typeOfDress = Type.shorts;
                break;
            }
        }
    }
    
}
