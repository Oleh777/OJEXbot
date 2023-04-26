package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main extends TelegramLongPollingBot {
//    jvbnbunvbydbvb7567hgf_Bot
//    6124034037:AAHu1-koE-BEiHnGySlsesYQnnKOKWlrlho
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Main());

//        System.out.println("Hello world!");
    }

    @Override
    public String getBotUsername() {
        return "jvbnbunvbydbvb7567hgf_Bot";
    }

    @Override
    public String getBotToken() {
        return "6124034037:AAHu1-koE-BEiHnGySlsesYQnnKOKWlrlho";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);

        SendMessage msg = createMessege("*Hello*,  "
                + update.getMessage().getFrom().getFirstName()
                + update.getMessage().getFrom().getLastName());
        msg.setChatId(chatId);
        sendApiMethodAsync(msg);
    }
    public Long getChatId(Update update){
        if (update.hasMessage()){
            return update.getMessage().getFrom().getId();
        }
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }
    public SendMessage createMessege(String text){
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setParseMode("markdown");
        return message;
    }
}