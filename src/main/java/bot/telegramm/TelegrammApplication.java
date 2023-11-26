package bot.telegramm;

import bot.telegramm.config.TelegramBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@EnableScheduling
public class TelegrammApplication {

	public static void main(String[] args) throws TelegramApiException {

		SpringApplication.run(TelegrammApplication.class, args);
	}

}
