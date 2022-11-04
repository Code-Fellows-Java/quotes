package quotes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest
{
	@Test
	void testRandomQuote()
	{
		int firstLength = App.readQuotes("quotes.json").length;
		ApiController.getRandomQuote();
		int secondLength = App.readQuotes("quotes.json").length;

		assertEquals(firstLength, secondLength - 1);
	}
}
