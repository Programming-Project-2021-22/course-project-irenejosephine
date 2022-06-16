
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Wardrobe {
    private ArrayList <Item> items = new ArrayList<>();
    private ArrayList <Item> favourites = new ArrayList<>();
    private ArrayList <Outfit> outfits = new ArrayList<>();
    private String username, password, email, phone, description = "Click Edit to modify your Bio", picture;
    
    //constructor
    public Wardrobe (String username, String password, String email, String phone) {
		this.username = username;
    	this.password = password;
    	this.email = email;
    	this.phone = phone;
    }

	//constructor from file
    public Wardrobe (String username, String password, String filename) throws FileNotFoundException {
    	this.username = username;
    	this.password = password;
		loadItems(filename);
    }

    public void setEmail(String email) {
    	this.email=email;
    }
    public String getEmail(){
        return email;
    }
    
    public void setPhone(String phone) {
    	this.phone=phone;
    }
    public String getPhone(){
        return phone;
    }
    
    public void setPicture(String picture) {
    	this.picture=picture;
    }
    public String getPicture(){
        return picture;
    }
    
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
    
    public ArrayList <Item> getItems (){
    	return items;
    }
    
    public ArrayList <Item> getOutfits (){
    	return items;
    }
    
    public String getDescription() {
    	return description;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    
	//load items from file
	public void loadItems(String itemsFile)  throws FileNotFoundException {
		ArrayList <String> filesArray = new ArrayList<>();
		Scanner file = new Scanner(new File(itemsFile));
		String fileName = file.nextLine();
		InputStream input = new FileInputStream(file.nextLine());
		
		while(file.hasNext()){
			fileName = file.nextLine();
			filesArray.add(fileName);
		}
//		for (int i=0; i<filesArray.size(); i++){
//			Item newItem = new T (filesArray.get(i)); //<T extends Item> dove cazzo va????
//			addItem(newItem);
//		}
	}

    //modifiers for items
    public <T extends Item> void addItem (T newItem){
        items.add(newItem);
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
    
    //change item
    public void changeOutfit(int index, boolean tf, int indexItem) {
    	//if tf=true means remove item so indexItem is the item that will be removed
    	if (tf) {
    		outfits.get(index).removeItem(indexItem);
    	}
    	//it tf=false means add item, indexItem is the index of the item in the items arrayList
    	else {
    		outfits.get(index).addItem(items.get(indexItem));
    	}
    	
    }
    
    //Available method, not used in the app, for uploading multiple files at once
    //load multiple files
    public void loadMultipleItems (ArrayList <String> filesArray) throws FileNotFoundException{
		String fileName;
    	for (int i = 0; i<(filesArray.size()); i++) {
    		fileName=(String) filesArray.get(i);
    		loadItems(fileName);
    	}    	
    }

	//search from a list items those who respect all the given filters (AND conditions)
	public ArrayList <Item> search (ArrayList <Item> list, ArrayList <String> filters){
		ArrayList <Item> filteredItems = new ArrayList <> ();

		for (int i=0; i<filters.size();i++){
			list = search (list, filters.get(i));
		}

		filteredItems = list;
		
		return filteredItems;
	}

    //search from a list items those who respect the given filter
    public ArrayList <Item> search (ArrayList <Item> list, String filter){
    	ArrayList <Item> filteredItems = new ArrayList <> ();
    	
		//list that contains the possible filter
    	ArrayList <String> colors = new ArrayList <> ();
    	List<String> colorsList = Arrays.asList("White", "Black", "Pink", "Blue", "Red", "Yellow", "Green", "Beige", "Brown");
    	colors.addAll(colorsList);
    	
    	ArrayList <String> seasons = new ArrayList <> (); 
    	List<String> seasonsList = Arrays.asList("winter", "spring", "summer", "fall");
    	seasons.addAll(seasonsList);
    			
    	ArrayList <String> occasions = new ArrayList <> (); 
    	List<String> occasionsList = Arrays.asList("formal", "everyDay","semiformal", "sporty");
    	occasions.addAll(occasionsList);
    	
    	ArrayList <String> itemTypes = new ArrayList <> ();
    	List<String> itemTypesList = Arrays.asList("top", "bottom", "dress", "accessorize");
    	itemTypes.addAll(itemTypesList);

		ArrayList <String> topTypes = new ArrayList <> ();
    	List<String> topTypesList = Arrays.asList("tShirt", "sweater", "sweatshirtAndHoodie", "topAndBody", "jacketAndCoat", "thankTop");
    	topTypes.addAll(topTypesList);
    	
		ArrayList <String> bottomTypes = new ArrayList <> ();
    	List<String> bottomTypesList = Arrays.asList("skirt", "jeans", "trouser", "shorts");
    	bottomTypes.addAll(bottomTypesList);

		ArrayList <String> dressTypes = new ArrayList <> ();
    	List<String> dressTypesList = Arrays.asList("longs", "shorts");
    	dressTypes.addAll(dressTypesList);

		ArrayList <String> accessorizeTypes = new ArrayList <> ();
    	List<String> accessorizeTypesList = Arrays.asList("jewelry", "hat", "belt", "glasses", "scarf", "gloves", "purse", "shoes", "forTheHair");
    	accessorizeTypes.addAll(accessorizeTypesList);

    	//based on in which liste the filter is present the correspondant method  is called to filter the items	
    	if (colors.contains(filter)) {
    		Colors selectedColor = null;
        	switch (filter) {
    	        case "white" : {
    	        	selectedColor = Colors.Beige;
					break;
    	        }
    			case "black" : {
    				selectedColor = Colors.Black;
					break;
    	        }
    			case "pink" : {
    				selectedColor = Colors.Pink;
					break;
    			}
    			case "blue" : {
    				selectedColor = Colors.Blue;
					break;
    			}
    			case "red" : {
    				selectedColor = Colors.Red;
					break;
    	        }
    			case "yellow" : {
    				selectedColor = Colors.Yellow;
					break;
    	        }
    			case "green" : {
    				selectedColor = Colors.Green;
					break;
    			}
    			case "beige" : {
    				selectedColor = Colors.Beige;
					break;
    			}
    			case "brown" : {
    				selectedColor = Colors.Brown;
					break;
    	        }
        	}
        	
        	filteredItems = searchColor (list, selectedColor);
    	}
    	else if (seasons.contains(filter)){
    		Seasons selectedSeason = null;
        	switch (filter) {
    	        case "winter" : {
    	        	selectedSeason = Seasons.winter;
					break;
    	        }
    			case "spring" : {
    				selectedSeason = Seasons.spring;
					break;
    	        }
    			case "summer" : {
    				selectedSeason = Seasons.summer;
					break;
    			}
    			case "fall" : {
    				selectedSeason = Seasons.fall;
					break;
    			}
            }
        	filteredItems = searchSeason(list, selectedSeason);
    	}
    	else if (occasions.contains(filter)){
    		Occasions temp = null;
        	switch (filter) {
    	        case "formal" : {
    	        	temp = Occasions.formal;
					break;
    	        }
    			case "everyDay" : {
    				temp = Occasions.everyDay;
					break;
    	        }
    			case "semiformal" : {
    				temp = Occasions.semiformal;
					break;
    			}
    			case "sporty" : {
    				temp = Occasions.sporty;
					break;
    			}
        	} 
        	filteredItems = searchOccasion(list, temp);
    	}
    	else if (itemTypes.contains(filter)){
    		switch (filter) {
    	        case "top" : {
    	        	filteredItems = searchTop(list);
					break;
    	        }
    			case "bottom" : {
    				filteredItems = searchBottom(list);
					break;
    	        }
    			case "dress" : {
    				filteredItems = searchDress(list);
					break;
    			}
    			case "accessorize" : {
    				filteredItems = searchAccessorize(list);
					break;
    			}
            }
    	}
		else if (topTypes.contains(filter)){
    		Top.Type selectedType = null;
        	switch (filter) {
    	        case "tShirt" : {
    	        	selectedType = Top.Type.tShirt;
					break;
    	        }
    			case "sweater" : {
    				selectedType = Top.Type.sweater;
					break;
    	        }
    			case "sweatshirtAndHoodie" : {
    				selectedType = Top.Type.sweatshirtAndHoodie;
					break;
    			}
    			case "topAndBody" : {
    				selectedType = Top.Type.topAndBody;
					break;
    			}
				case "jacketAndCoat" : {
    	        	selectedType = Top.Type.jacketAndCoat;
					break;
    	        }
    			case "thankTop" : {
    				selectedType = Top.Type.thankTop;
					break;
				}
            }
        	filteredItems = searchTopType(list, selectedType);
    	}
		else if (bottomTypes.contains(filter)){
    		Bottom.Type selectedType = null;
        	switch (filter) {
    	        case "skirt" : {
    	        	selectedType = Bottom.Type.skirt;
					break;
    	        }
    			case "jeans" : {
    				selectedType = Bottom.Type.jeans;
					break;
    	        }
    			case "trouser" : {
    				selectedType = Bottom.Type.trouser;
					break;
    			}
    			case "shorts" : {
    				selectedType = Bottom.Type.shorts;
					break;
    			}
            }
        	filteredItems = searchBottomType(list, selectedType);
    	}
    	else if (dressTypes.contains(filter)){
    		Dress.Type selectedType = null;
        	switch (filter) {
    	        case "longs" : {
    	        	selectedType = Dress.Type.longs;
					break;
    	        }
    			case "shorts" : {
    				selectedType = Dress.Type.shorts;
					break;
    			}
            }
        	filteredItems = searchDressType(list, selectedType);
    	}
		else if (accessorizeTypes.contains(filter)){
    		Accessorize.Type selectedType = null;
        	switch (filter) {
    	        case "jewelry" : {
    	        	selectedType = Accessorize.Type.jewelry;
					break;
    	        }
    			case "hat" : {
    				selectedType = Accessorize.Type.hat;
					break;
    	        }
    			case "belt" : {
    				selectedType = Accessorize.Type.belt;
					break;
    			}
    			case "glasses" : {
    				selectedType = Accessorize.Type.glasses;
					break;
    			}
				case "scarf" : {
    	        	selectedType = Accessorize.Type.scarf;
					break;
    	        }
    			case "gloves" : {
    				selectedType = Accessorize.Type.gloves;
					break;
				}
				case "purse" : {
    	        	selectedType = Accessorize.Type.purse;
					break;
    	        }
    			case "shoes" : {
    				selectedType = Accessorize.Type.shoes;
					break;
    	        }
    			case "forTheHair" : {
    				selectedType = Accessorize.Type.forTheHair;
					break;
    			}
            }
        	filteredItems = searchAccessorizeType(list, selectedType);
    	}

    	return filteredItems;
    }
    
    //search by feature (color, occasion, season)
    private ArrayList <Item> searchColor(ArrayList<Item> list, Colors filter) {
    	ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
    		if (list.get(i).getColorOfItem() == filter) {
    			filteredItems.add(list.get(i));
    		}
    	}
		return filteredItems;
	}
	public ArrayList <Item> searchOccasion (ArrayList <Item> list, Occasions filter){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
    		if (list.get(i).getOccasionOfItem()==filter) {
    			filteredItems.add(list.get(i));
    		}
    	}
		return filteredItems;
    }
	public ArrayList <Item> searchSeason (ArrayList <Item> list, Seasons filter){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
    		if (list.get(i).getSeasonOfItem()==filter) {
    			filteredItems.add(list.get(i));
    		}
    	}
		return filteredItems;
    }
    
	//search by type (top, bottom, dress, accessorise)
    public ArrayList <Item> searchTop (ArrayList <Item> list){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Top){
				filteredItems.add(list.get(i));
			}
    	}
		return filteredItems;
    }
    public ArrayList <Item> searchBottom (ArrayList <Item> list){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Bottom){
				filteredItems.add(list.get(i));
			}
    	}
		return filteredItems;
    }
    public ArrayList <Item> searchDress (ArrayList <Item> list){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Dress){
				filteredItems.add(list.get(i));
			}
    	}
		return filteredItems;
    }
    public ArrayList <Item> searchAccessorize (ArrayList <Item> list){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Accessorize){
				filteredItems.add(list.get(i));
			}
    	}
		return filteredItems;
    }

	//research by type (type of top, type of bottom, type of dress, type of accessorize)
	public ArrayList <Item> searchTopType (ArrayList <Item> list, Top.Type filter){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Top){
				if (((Top)list.get(i)).getTypeOfTop()==filter) {
					filteredItems.add(list.get(i));
				}
			}
    	}
		return filteredItems;
    }
	public ArrayList <Item> searchBottomType (ArrayList <Item> list, Bottom.Type filter){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Bottom){
				if (((Bottom)list.get(i)).getTypeOfBottom()==filter) {
					filteredItems.add(list.get(i));
				}
			}
    	}
		return filteredItems;
    }
	public ArrayList <Item> searchDressType (ArrayList <Item> list, Dress.Type filter){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Dress){
				if (((Dress)list.get(i)).getTypeOfDress()==filter) {
					filteredItems.add(list.get(i));
				}
			}
    	}
		return filteredItems;
    }
	public ArrayList <Item> searchAccessorizeType (ArrayList <Item> list, Accessorize.Type filter){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Accessorize){
				if (((Accessorize)list.get(i)).getTypeOfAccesorize()==filter) {
					filteredItems.add(list.get(i));
				}
			}
    	}
		return filteredItems;
    }
}