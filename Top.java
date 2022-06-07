public class Top extends Item{
    enum Type {tShirt, sweater, sweatshirtAndHoodie, topAndBody, jacketAndCoat, thankTop} 
    private Type typeOfTop;

    //constructor
    public Top(Seasons selectedSeason, Occasions selectedOccasion, Colors selectedColor, String selectedType, String filename) {
        super(selectedSeason, selectedOccasion, selectedColor, filename);
        setTypeOfTop(selectedType);
    }

    //getter and setter
    public Type getTypeOfTop() {
        return typeOfTop;
    }
    public void setTypeOfTop(String typeOfTop) {
        switch (typeOfTop){  
            case "tShirt":{ 
                this.typeOfTop = Type.tShirt;
                break;
            }
            case "sweater":{   
                this.typeOfTop = Type.sweater;
                break;
            }
            case "sweatshirtAndHoodie":{
                this.typeOfTop = Type.sweatshirtAndHoodie;
                break;
            }
            case "topAndBody" :{
                this.typeOfTop = Type.topAndBody;
                break;
            }
            case "jacketAndCoat":{
                this.typeOfTop = Type.jacketAndCoat;
                break;
            }
            case "thankTop":{
                this.typeOfTop = Type.thankTop;
                break;
            }
        }
    }
    
}
