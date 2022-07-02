package app;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {

        // Top t1 = new Top ("Winter", "everyDay", "White", "sweater", "yes", "sweater.jpg", "white sweater");
        // Bottom b1 = new Bottom ("summer", "semiformal", "Blue", "trouser", "no", "trouser.jpg", "blue trouser");
        // Dress d1 = new Dress ("spring", "formal", "Yellow", "longs", "yes", "longD.jpg", "my fav long dress (it's yellow)");
        // Accessorize a1 = new Accessorize ("fall", "sporty", "Beige", "glasses", "no", "glasses.jpg", "beige sunglasses");

		// System.out.println(t1);
		// System.out.println();
		// System.out.println(b1);
		// System.out.println();
		// System.out.println(d1);
		// System.out.println();
		// System.out.println(a1);
		// System.out.println();

		//serialization obj -> json
		Gson gson = new Gson ();
		// String json = gson.toJson(t1);
		// System.out.println("app.Top: ");
		// System.out.println(json);

		// String json = gson.toJson(b1);
		// System.out.println("app.Bottom: ");
		// System.out.println(json);

		// String json = gson.toJson(d1);
		// System.out.println("app.Dress: ");
		// System.out.println(json);

		// String json = gson.toJson(a1);
		// System.out.println("app.Accessorize: ");
		// System.out.println(json);

		//deserialization json -> obj
		String sT1 = "{'typeOfTop':'sweater','seasonOfItem':'winter','occasionOfItem':'everyDay','colorOfItem':'White','favourite':true,'description':'white sweater','picture':'sweater.jpg'}";
		Top t1FS = gson.fromJson(sT1, Top.class);
        // System.out.println(t1);
		System.out.println();

        FileWriter fw = null;
        try {
            fw = new FileWriter("json\\newJSON.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write(sT1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // String sP3 = "{'name':'nome3','lastname':'cognome3','age':23,'dating':true,'ses':'winter'}";
		// Person p3 = gson.fromJson(sP3, Person.class);
		// System.out.println();
		// System.out.println(p3);

		// ArrayList <Person> aP = new ArrayList <> ();
		// aP.add(p1);
		// aP.add(p2);
		// aP.add(p3);

		// Gson gsonAr = new Gson ();
		// String json = gsonAr.toJson(aP, ArrayList.class);
		// System.out.println();
		// System.out.println(json);

		// String jAr = "[{'name':'nome3','lastname':'cognome3','age':23,'dating':true,'ses':'winter'},{'name':'nome3','lastname':'cognome3','age':23,'dating':true,'ses':'winter'},{'name':'nome3','lastname':'cognome3','age':23,'dating':true,'ses':'winter'},{'name':'nome3','lastname':'cognome3','age':23,'dating':true,'ses':'winter'}]";
		// ArrayList objs = gsonAr.fromJson(json, ArrayList);
	}

}
