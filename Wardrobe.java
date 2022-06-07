import java.util.ArrayList;

public class Wardrobe {
    private ArrayList <Item> items = new ArrayList<>();
    private ArrayList <Item> favourites = new ArrayList<>();
    private ArrayList <Outfit> outfits = new ArrayList<>();
    private String username, password;

    //setters and getters
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public ArrayList <Item> getFavourites (){
        return favourites;
    }
    public void setFavourties(){
        ArrayList <Item> newFavourites = new ArrayList<>();

       //sostituire con for each
        for (int i = 0; i<items.size(); i++){
            if (items.get(i).getFavourite()==true)
                newFavourites.add(items.get(i));

        }
        //favourites.clear();
        favourites = newFavourites;
    }
    
    
    public void addItem (Item newItem, String kindOfItem){
        switch (kindOfItem){
            case ("top"):{
                Top newTop = (Top) newItem;
                items.add(newTop);
            }
            
            case ("bottom"):{
                Bottom newBottom = (Bottom) newItem;
                items.add(newBottom);
            }

            case ("accessorize"):{
                Accessorize newBottom = (Accessorize) newItem;
                items.add(newBottom);
            }
        } 
    }
    public void removeItem (int index) {
    	items.remove(index);
    }
    
    public void addOutfit (Outfit newOutfit) {
    	outfits.add(newOutfit);
    }
    public void removeOutfit (int index) {
    	outfits.remove(index);
    }
    
   
}