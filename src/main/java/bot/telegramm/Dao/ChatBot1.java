package bot.telegramm.Dao;


import bot.telegramm.Repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ChatBot1  implements InterfaceAct {
public static List<Message> messageList=new ArrayList<>();
    @Autowired
    MessageRepository messageRepository;
        @Override
        public List<Message> action( )  {
            return messageRepository.findAll10records();

    }
    @Scheduled(fixedRate = 1000)
    public void saveMessage(){
        try{
            if (messageList.size()>0){
                messageList.stream().forEach(e->messageRepository.save(e));
                messageList.clear();
            }
        }
        catch(Exception e){log.info("Ошибка TelegramBot");e.printStackTrace();}
    }
}
