package valerie.TelegramBot.Youtube;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
                SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
                message.setChatId(update.getMessage().getChatId().toString());
                message.setText("Subscribers: \r\n" + ScrapperService.globalSubscribers + "\r\n Last video: \r\n" + ScrapperService.globalLastVideo);

                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        System.exit(0);
    }

    @Override
    public String getBotUsername() {
            return "ValerieYoutubeBot";
        }


    @Override
    //insert your own Telegram Bot Token
    public String getBotToken() {
        return "";
    }
}
