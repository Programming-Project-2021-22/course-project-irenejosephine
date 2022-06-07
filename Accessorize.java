public class Accessorize extends Item{
    enum Type {jewelry, hat, belt, glasses, scarf, gloves, purse, shoes, forTheHair} 
    private Type typeOfAccessorize;

    //constructor with description
    public Accessorize(Seasons selectedSeason, Occasions selectedOccasion, Colors selectedColor, String selectedType, String filename, String description ) {
        super(selectedSeason, selectedOccasion, selectedColor, filename, description);
        setTypeOfAccesorize(selectedType);
    }
    
    //constructor without description
    public Accessorize(Seasons selectedSeason, Occasions selectedOccasion, Colors selectedColor, String selectedType, String filename ) {
        super(selectedSeason, selectedOccasion, selectedColor, filename);
        setTypeOfAccesorize(selectedType);
    }

    //getter and setter
    public Type getTypeOfAccesorize() {
        return typeOfAccessorize;
    }
    private void setTypeOfAccesorize(String typeOfAccessorize) {
        switch (typeOfAccessorize){  
            case "jewelry":{ 
                this.typeOfAccessorize = Type.jewelry;
                break;
            }
            case "hat":{   
                this.typeOfAccessorize = Type.hat;
                break;
            }
            case "belt":{
                this.typeOfAccessorize = Type.belt;
                break;
            }
            case "glasses" :{
                this.typeOfAccessorize = Type.glasses;
                break;
            }
            case "scarf":{ 
                this.typeOfAccessorize = Type.scarf;
                break;
            }
            case "gloves":{   
                this.typeOfAccessorize = Type.gloves;
                break;
            }
            case "purse":{
                this.typeOfAccessorize = Type.purse;
                break;
            }
            case "shoes" :{
                this.typeOfAccessorize = Type.shoes;
                break;
            }
            case "forTheHair" :{
                this.typeOfAccessorize = Type.forTheHair;
                break;
            }
        }
    }
    
}
