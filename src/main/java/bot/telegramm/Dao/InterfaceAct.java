package bot.telegramm.Dao;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public interface InterfaceAct {
    public List<Message> action() throws TelegramApiException;
}
