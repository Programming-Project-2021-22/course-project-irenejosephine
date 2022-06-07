
import java.util.ArrayList; 

public class App {    
    ArrayList <Wardrobe> wardrobes = new ArrayList<>();
    ArrayList <String> users = new ArrayList<>();
    ArrayList <String> passwords = new ArrayList<>();
    
    //constructor with import by file
    public App (String filename) {
    	//TODO legge un file che importa gli utenti e le password
    }
    
    //constructor without import by file
    public App () {}

    //creates a new user if the userNAme and pasword are correct
    public Wardrobe createNewWardrobe (String userName, String password) {
        users.add(userName);
        passwords.add(password);
        Wardrobe nW= new Wardrobe();
        wardrobes.add(nW);
        return wardrobes.get(wardrobes.size()-1);
        //TODO  if the userNAme and pasword are correct
    }

    //loads into the web app the wardrobe
    public Wardrobe loadWardrobe (int index) {
        return wardrobes.get(index);
    }

    //check if the pasword and the username exist and are correct
    public boolean checkUsrPsw (String userName, String password){
        try {
            return checkPsw(checkUsr(userName), password);
        } catch (Exception e) {
            System.out.println("Username errato");
            return false;
        }
    }

    //check if username exist and return the index on the array
    public int checkUsr (String userName){
        for  (int i=0; i<wardrobes.size(); i++){
            if (wardrobes.get(i).getPassword()==userName)
                return i;
        }
        return -1;
    }
    
    //check if the pasword and the username exist and are correct
    public boolean checkPsw (int index, String psw){
        if (wardrobes.get(index).getPassword()==psw)
            return true;
        else
            return false;
    }
}
