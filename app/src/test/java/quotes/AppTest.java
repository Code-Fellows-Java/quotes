/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void getRandoQuote()
    {
        Quote quote = new Quote("Marilyn Monroe", "I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.");
        Quote quote1 = new Quote("Charles Dickens", "Ask no questions, and you'll be told no lies.");
        Quote quote2 = new Quote("George Orwell", "If liberty means anything at all it means the right to tell people what they do not want to hear.");
        Quote quote3 = new Quote("Graham Greene", "We'd forgive most things if we knew the facts.");

        Quote[] quotes = {quote, quote1, quote2, quote3 };
        Quote randomQuote = App.getRandoQuote(quotes);

        assertNotNull(randomQuote);


    }

    @Test
    void readQuotes()
    {
        Quote[] quotes = App.readQuotes("JSON.json");

        assertEquals(quotes.length, 138);

    }
}
