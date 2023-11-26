package bot.telegramm.Service;

import bot.telegramm.Dao.ChatBot1;
import bot.telegramm.Dao.Message;
import bot.telegramm.Repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ChatBot1 chatBot1;



    public List<Message>  choiceAction(String id  )  {
        List<Message> list=new ArrayList<>();
        try { if(id.equals("1")){
            list= chatBot1.action(); }
         }catch (Exception e){log.info("Ошибка в MessageService ");e.printStackTrace();}
        return list;
    }

}
