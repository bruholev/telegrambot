package bot.telegramm.config;


import bot.telegramm.Dao.ChatBot1;
import bot.telegramm.Dao.Message;
import bot.telegramm.Repository.MessageRepository;
import bot.telegramm.Service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
@Service
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    ChatBot1 chatBot1 ;
    @Override
    public String getBotUsername() {
        return "t.me/BruhoTelegrambot";
    }

    @Override
    public String getBotToken() {
        return "6926731614:AAHIC3ISpFUV1cliRw6i4BNCZpJSfTlRops";
    }

    @Override
    public void onUpdateReceived(Update update) {
        try{
            if (update.hasChannelPost()) {
                // Обработка сообщения из канала
                String messageText = update.getChannelPost().getText();
                long channelId = update.getChannelPost().getChatId();
                // Сохранение сообщения в базу данных
                log.info("messageText "+messageText);
                ChatBot1.messageList.add(new Message(new Date(),messageText,"1"));
            }
        }
        catch(Exception e){log.info("Ошибка TelegramBot");e.printStackTrace();}

    }


}

