public class Bottom extends Item {
    enum Type {skirt, jeans, trouser, shorts} 
    private Type typeOfBottom;

    //constructor with description
    public Bottom (Seasons selectedSeason, Occasions selectedOccasion, Colors selectedColor, String selectedType, String filename, String description) {
    	super(selectedSeason, selectedOccasion, selectedColor, filename, description);
    	setTypeOfBottom(selectedType);
    }
    
    
    //constructor without description
    public Bottom(Seasons selectedSeason, Occasions selectedOccasion, Colors selectedColor, String selectedType, String filename) {
        super(selectedSeason, selectedOccasion, selectedColor, filename);
        setTypeOfBottom(selectedType);
    }

    //getter and setter
    public Type getTypeOfBottom() {
        return typeOfBottom;
    }
    public void setTypeOfBottom(String typeOfBottom) {
        switch (typeOfBottom){  
            case "skirt":{ 
                this.typeOfBottom = Type.skirt;
                break;
            }
            case "jeans":{   
                this.typeOfBottom = Type.jeans;
                break;
            }
            case "trouser":{
                this.typeOfBottom = Type.trouser;
                break;
            }
            case "shorts" :{
                this.typeOfBottom = Type.shorts;
                break;
            }
        }
    }
    
}
