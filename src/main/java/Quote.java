import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class Quote {
    protected String[] tags;
    protected String author;
    protected String text;
    protected String likes;

    public Quote(String[] tags, String author, String text, String likes) {
        this.tags = tags;
        this.author = author;
        this.text = text;
        this.likes = likes;
    }

    public static Quote getQuote () {
        try {

            //HTTP API Hit to ron swanson quotes setup.
            URL url = new URL("http://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            //Actual API Hit to follow.
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            //Use response to form a string buffer of data.
            String current;
            StringBuffer content = new StringBuffer();
            while ((current = in.readLine()) != null) content.append(current);

            //Important: Close HTTP Connection.
            in.close();

            // Formats the returned data for use as a Quote.
            Quote theQuote = new Quote(new String[0], "Ron Swanson", content.toString().substring(1, content.length() - 1), "All The Likes");

            // Writes new quote to previously available quotes.
            FileManager.writeLocalQuotes(addNewQuote(FileManager.readLocalQuotes(), theQuote));

            // Returns the quote.
            return theQuote;

        } catch (IOException e) {

            // If the attempted action fails the system will attempt to read from the locally stored quotes to return a random.
            Quote[] quotes = FileManager.readLocalQuotes();
            int random = ThreadLocalRandom.current().nextInt(quotes.length);
            return quotes[random];
        }
    }


    public static Quote[] addNewQuote (Quote[] quotes, Quote quoteToAdd) {

        //Verify the new quote isn't stored locally already.
        for (Quote quote: quotes) if (quote.text == quoteToAdd.text) return quotes;

        //Create new array for adding the new quote.
        Quote[] allQuotes = new Quote[quotes.length + 1];

        //Add old quotes to array.
        for (int i = 0; i < quotes.length; i++) {
            allQuotes[i] = quotes[i];
        }

        //Add new quote and return new array.
        allQuotes[quotes.length] = quoteToAdd;
        return allQuotes;
    }

    public String toString() {
        return text + " - " + author;
    }
}
