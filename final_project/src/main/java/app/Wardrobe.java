package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represent a app.Wardrobe object that contains some personal data of the user
 * (username, password, email, phone, description) and a collection of items and outfits
 * @author Irene Avezzù
 *
 */
public class Wardrobe {
    private ArrayList <Item> items = new ArrayList<>();
    private ArrayList <Item> favourites = new ArrayList<>();
    private ArrayList <Outfit> outfits = new ArrayList<>();
    private String username, password, email, phone, description = "Click Edit to modify your Bio", picture;

    /**
     * Constructor of the class, gets 4 string as parameters and set the instance data
     * @param username
     * @param password
     * @param email
     * @param phone
     */
    //constructor
    public Wardrobe (String username, String password, String email, String phone) {
		this.username = username;
    	this.password = password;
    	this.email = email;
    	this.phone = phone;
    }

    /**
     * Setter of email
     * @param email
     */
    public void setEmail(String email) {
    	this.email=email;
    }
    /**
     * Getter of email
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * Setter of phone
     * @param phone
     */
    public void setPhone(String phone) {
    	this.phone=phone;
    }
    /**
     * Getter of phone
     * @return phone
     */
    public String getPhone(){
        return phone;
    }

    /**
     * Setter of picture
     * @param picture
     */
    public void setPicture(String picture) {
    	this.picture=picture;
    }
    /**
     * Getter of picture
     * @param picture
     */
    public String getPicture(){
        return picture;
    }

    /**
     * Getter of username
     * @return username
     */
    public String getUsername(){
        return username;
    }
    /**
     * Setter of username
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Getter of password
     * @return password
     */
    public String getPassword(){
        return password;
    }
    /**
     * Setter of password
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Getter of favourites (ArrayList of favourites items)
     * @return favourites
     */
    public ArrayList <Item> getFavourites (){
        return favourites;
    }
    /**
     * Setter of favourites
     */
    public void setFavourties(){
       ArrayList <Item> newFavourites = new ArrayList<>();
	   for (Item it : items){
		   if (it.getFavourite()==true)
               newFavourites.add(it);
	   }
        favourites = newFavourites;
    }

    /**
     * Getter of items (ArrayList of all items)
     * @return items
     */
    public ArrayList <Item> getItems (){
    	return items;
    }

    /**
     * Getter of outfits (ArrayList of all outfits)
     * @return outfits
     */
    public ArrayList <Outfit> getOutfits (){
    	return outfits;
    }

    /**
     * Getter of description
     * @return description
     */
    public String getDescription() {
    	return description;
    }
    /**
     * Setter of description
     * @param description
     */
    public void setDescription(String description) {
    	this.description = description;
    }


    /**
     * Add a new app.Item of type T (extends app.Accessorize, app.Bottom, app.Dress, app.Top) to the ArrayList of items
     * @param <T extends Accessorize, Bottom, Dress, Top> newItem
     */
    public <T extends Accessorize, Bottom, Dress, Top> void addItem (T newItem){
        items.add(newItem);
    }

    /**
     * Remove the index-th item from the ArrayList of items
     * @param index index of element to remove
     */
    public void removeItem (int index) {
    	items.remove(index);
    }

    /**
     * Add a new app.Outfit object to the ArrayList of outfits
     * @param newOutfit
     */
    public void addOutfit (Outfit newOutfit) {
    	outfits.add(newOutfit);
    }
    /**
     * Remove the index-th outfit from the ArrayList of outfits
     * @param index index of element to remove
     */
    public void removeOutfit (int index) {
    	outfits.remove(index);
    }

    /**
     * search from a list items those who respect all the given filters (AND conditions)
     * @param list
     * @param filters
     * @return
     */
	public ArrayList <Item> search (ArrayList <Item> list, ArrayList <String> filters){
		ArrayList <Item> filteredItems = new ArrayList <> ();

		for (int i=0; i<filters.size();i++){
			list = search (list, filters.get(i));
		}

		if (list.size()!=0) {
			filteredItems = list;
		}

		return filteredItems;
	}

    /**
     * search from a list items those who respect the given filter
     * @param list
     * @param filter
     * @return
     */
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
    		topType selectedType = null;
        	switch (filter) {
    	        case "tShirt" : {
    	        	selectedType = topType.tShirt;
					break;
    	        }
    			case "sweater" : {
    				selectedType = topType.sweater;
					break;
    	        }
    			case "sweatshirtAndHoodie" : {
    				selectedType = topType.sweatshirtAndHoodie;
					break;
    			}
    			case "topAndBody" : {
    				selectedType = topType.topAndBody;
					break;
    			}
				case "jacketAndCoat" : {
    	        	selectedType = topType.jacketAndCoat;
					break;
    	        }
    			case "thankTop" : {
    				selectedType = topType.tankTop;
					break;
				}
            }
        	filteredItems = searchTopType(list, selectedType);
    	}
		else if (bottomTypes.contains(filter)){
    		bottomType selectedType = null;
        	switch (filter) {
    	        case "skirt" : {
    	        	selectedType = bottomType.skirt;
					break;
    	        }
    			case "jeans" : {
    				selectedType = bottomType.jeans;
					break;
    	        }
    			case "trouser" : {
    				selectedType = bottomType.trouser;
					break;
    			}
    			case "shorts" : {
    				selectedType = bottomType.shorts;
					break;
    			}
            }
        	filteredItems = searchBottomType(list, selectedType);
    	}
    	else if (dressTypes.contains(filter)){
    		dressType selectedType = null;
        	switch (filter) {
    	        case "longs" : {
    	        	selectedType = dressType.longs;
					break;
    	        }
    			case "shorts" : {
    				selectedType = dressType.shorts;
					break;
    			}
            }
        	filteredItems = searchDressType(list, selectedType);
    	}
		else if (accessorizeTypes.contains(filter)){
    		accessorizeType selectedType = null;
        	switch (filter) {
    	        case "jewelry" : {
    	        	selectedType = accessorizeType.jewelry;
					break;
    	        }
    			case "hat" : {
    				selectedType = accessorizeType.hat;
					break;
    	        }
    			case "belt" : {
    				selectedType = accessorizeType.belt;
					break;
    			}
    			case "glasses" : {
    				selectedType = accessorizeType.glasses;
					break;
    			}
				case "scarf" : {
    	        	selectedType = accessorizeType.scarf;
					break;
    	        }
    			case "gloves" : {
    				selectedType = accessorizeType.gloves;
					break;
				}
				case "purse" : {
    	        	selectedType = accessorizeType.purse;
					break;
    	        }
    			case "shoes" : {
    				selectedType = accessorizeType.shoes;
					break;
    	        }
    			case "forTheHair" : {
    				selectedType = accessorizeType.forTheHair;
					break;
    			}
            }
        	filteredItems = searchAccessorizeType(list, selectedType);
    	}

    	return filteredItems;
    }

    /**
     * search by feature -> colorOfItem
     * @param list
     * @param filter
     * @return filteredItems: filtered list
     */
	private ArrayList <Item> searchColor(ArrayList<Item> list, Colors filter) {
    	ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
    		if (list.get(i).getColorOfItem() == filter) {
    			filteredItems.add(list.get(i));
    		}
    	}
		return filteredItems;
	}
	/**
	 * search by feature -> occasionOfItem
	 * @param list
	 * @param filter
	 * @return filteredItems: filtered list
	 */
	public ArrayList <Item> searchOccasion (ArrayList <Item> list, Occasions filter){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
    		if (list.get(i).getOccasionOfItem()==filter) {
    			filteredItems.add(list.get(i));
    		}
    	}
		return filteredItems;
    }
	/**
	 * search by feature -> seasonOfItem
	 * @param list
	 * @param filter
	 * @return filteredItems: filtered list
	 */
	public ArrayList <Item> searchSeason (ArrayList <Item> list, Seasons filter){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
    		if (list.get(i).getSeasonOfItem()==filter) {
    			filteredItems.add(list.get(i));
    		}
    	}
		return filteredItems;
    }

	/**
	 * search by type of app.Item -> app.Top
	 * @param list
	 * @param filter
	 * @return filteredItems: filtered list
	 */
	public ArrayList <Item> searchTop (ArrayList <Item> list){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Top){
				filteredItems.add(list.get(i));
			}
    	}
		return filteredItems;
    }
	/**
	 * search by type of app.Item -> app.Bottom
	 * @param list
	 * @param filter
	 * @return filteredItems: filtered list
	 */
    public ArrayList <Item> searchBottom (ArrayList <Item> list){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Bottom){
				filteredItems.add(list.get(i));
			}
    	}
		return filteredItems;
    }
    /**
	 * search by type of app.Item -> app.Dress
	 * @param list
	 * @param filter
	 * @return filteredItems: filtered list
	 */
    public ArrayList <Item> searchDress (ArrayList <Item> list){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Dress){
				filteredItems.add(list.get(i));
			}
    	}
		return filteredItems;
    }
    /**
	 * search by type of app.Item -> app.Accessorize
	 * @param list
	 * @param filter
	 * @return filteredItems: filtered list
	 */
    public ArrayList <Item> searchAccessorize (ArrayList <Item> list){
		ArrayList <Item> filteredItems = new ArrayList <> ();
		for (int i=0; i<list.size(); i++) {
			if(list.get(i) instanceof Accessorize){
				filteredItems.add(list.get(i));
			}
    	}
		return filteredItems;
    }

    /**
   	 * search by type of app.Top
   	 * @param list
   	 * @param filter
   	 * @return filteredItems: filtered list
   	 */
    public ArrayList <Item> searchTopType (ArrayList <Item> list, topType filter){
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
    /**
   	 * search by type of app.Bottom
   	 * @param list
   	 * @param filter
   	 * @return filteredItems: filtered list
   	 */
	public ArrayList <Item> searchBottomType (ArrayList <Item> list, bottomType filter){
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
	/**
   	 * search by type of app.Dress
   	 * @param list
   	 * @param filter
   	 * @return filteredItems: filtered list
   	 */
	public ArrayList <Item> searchDressType (ArrayList <Item> list, dressType filter){
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
	/**
   	 * search by type of app.Accessorize
   	 * @param list
   	 * @param filter
   	 * @return filteredItems: filtered list
   	 */
	public ArrayList <Item> searchAccessorizeType (ArrayList <Item> list, accessorizeType filter){
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
