import java.util.ArrayList; 

public class App {    
    private static ArrayList <Wardrobe> wardrobes = new ArrayList<>();
    private static ArrayList <String> users = new ArrayList<>();
    private static ArrayList <String> passwords = new ArrayList<>();    
    
    //constructor 
    public App () {}
    
    //creates a new user if the userName and pasword are correct
    public void createNewUser (String userName, String password, String email, String phone) {
        users.add(userName);
        passwords.add(password);
        Wardrobe nW= new Wardrobe(userName, password, email, phone);
        wardrobes.add(nW);
    }

    public Wardrobe getWardrobe (int index) {
        return wardrobes.get(index);
    }

    //check if the pasword and the username exist and are correct
    public boolean checkUsrAndPsw (String userName, String password){
        if (users.contains(userName)) { //username exists
        	if (password.equals(passwords.get(users.indexOf(userName)))){//password match the users' password
        		System.out.println("true");
                return true;
            }
        	else {
        		System.out.println("false");
        		return false;
        	}
        	//return(checkPsw(users.indexOf(userName), password));
        }
        else{
        	System.out.println("ELSE");
            return false;
        }       
    }
    
    public int getUserIndex (String username) {
    	return users.indexOf(username);
    }

    public void removeUser(int index) {
    	wardrobes.remove(index);
    	users.remove(index);
    	passwords.remove(index);
    }
}
