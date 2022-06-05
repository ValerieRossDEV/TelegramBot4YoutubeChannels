package valerie.TelegramBot.Youtube;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class TelegramBot4Youtube {

	//value stands for the Youtube user profile that we intend to scrape. Insert here yours.
	static final protected String value = "UCLacfeVHGkfiC3cw0PlJGCQ";


	public static void main(String[] args) throws TelegramApiException {

		//refer to Selenium documentation on how to configue the properties, such that it works for you
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.10.0-win64\\geckodriver.exe");

		ScrapperService.scrape(value);

		// You can use your own BotSession implementation if needed.
		TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

		// this will register our bot
		try {
			botsApi.registerBot(new TelegramBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

}
