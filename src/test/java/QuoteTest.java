import org.junit.Test;

import static org.junit.Assert.*;

public class QuoteTest {

    @Test
    public void testConstructor(){
        Quote quote = new Quote(new String[]{"Test Index"}, "Test", "Test Text", "Test Likes");
        assertEquals("Should have a string array containing one string of Test Index", "Test Index", quote.tags[0]);
        assertEquals("Should have a string array of length 1", 1, quote.tags.length);
        assertEquals("quote.author should be Test", "Test", quote.author);
        assertEquals("quote.text should be Test Text", "Test Text", quote.text);
        assertEquals("quote.likes should be Test Likes", "Test Likes", quote.likes);
    }

    @Test
    public void testToString() {
        Quote quote = new Quote(new String[0], "TestAuthor", "\"Test Text\"", "No One Likes This");
        assertEquals("should return \"quote\" - author", "\"Test Text\" - TestAuthor", quote.toString());
        Quote quote2 = new Quote(new String[0], "TestAuthor", "\"TestText\"", "No One Likes This");
        assertEquals("should return \"quote\" - author", "\"TestText\" - TestAuthor", quote2.toString());
        Quote quote3 = new Quote(new String[0], "TestAuthor", "\"Test/Text\"", "No One Likes This");
        assertEquals("should return \"quote\" - author", "\"Test/Text\" - TestAuthor", quote3.toString());
    }
}