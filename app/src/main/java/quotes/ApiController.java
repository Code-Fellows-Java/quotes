package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileWriter;
import java.io.IOException;

public class ApiController
{
	public static String getRandomQuote()
	{
		final String apiURL = "https://ron-swanson-quotes.herokuapp.com/v2/quotes";
		final OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(apiURL)
				.build();

		try (Response response = client.newCall(request).execute())
		{
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String quote = gson.fromJson(response.body().charStream(), String[].class)[0];

			Quote quoteToCache = new Quote("Ron Swanson", quote);

			 // https://attacomsian.com/blog/gson-write-json-file

			Quote[] quotesAsArray = App.readQuotes("quotes.json");
			Quote[] newQuoteArray = new Quote[quotesAsArray.length + 1];

			System.arraycopy(quotesAsArray, 0, newQuoteArray, 0, newQuoteArray.length - 1);

			newQuoteArray[quotesAsArray.length] = quoteToCache;

			FileWriter fileWriter = new FileWriter("quotes.json");
			gson.toJson(newQuoteArray, fileWriter);
			fileWriter.close();

			return quote;
		}
		catch (IOException e)
		{
			Quote[] quotes = App.readQuotes("quotes.json");
			Quote quote = App.getRandoQuote(quotes);
			return quote.getText();
		}


	}
}
