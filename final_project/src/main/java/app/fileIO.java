package app;

import java.io.*;

public class fileIO {
    public static void main(String[] args) {

        //WRITE into a file using BufferedWriter
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\json\\fileO.json"));
            writer.write("Hello World!");
            writer.write("\n2nd line");
            writer.write("\n3rd line");
            writer.write("\n4th line");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //READ from a file using BufferedReader
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\json\\fileO.json"));
            String s="", line=reader.readLine();
            while (line!=null){
                s= s + line + "\n";
                line=reader.readLine();
            }
            System.out.println(s);
            //System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
