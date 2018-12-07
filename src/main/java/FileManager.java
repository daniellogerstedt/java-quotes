import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {

    public static String path = "assets/swansonQuotes.json";

    public static void writeLocalQuotes (Quote[] quotes) {

        Gson gson = new Gson();

        //Stringify new array into JSON format
        String jsonQuotes = gson.toJson(quotes);
        try {
            //Attempt to open Print Writer for new file at old path.
            PrintWriter out = new PrintWriter(new File(path));

            //Attempt to write content
            out.print(jsonQuotes);

            //Close Print Writer
            out.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static Quote[] readLocalQuotes () {
        try {

            //Create a byte[] from local file.
            byte[] text = Files.readAllBytes(Paths.get(path));
            Gson gson = new Gson();

            //Turn byte[] to string, then convert string from JSON to Java Quote Object Array.
            Quote[] quotes = gson.fromJson(new String(text), Quote[].class);

            //Return the new Quote Array.
            return quotes;

        }
        catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

}
