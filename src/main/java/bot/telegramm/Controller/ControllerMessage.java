package bot.telegramm.Controller;

import bot.telegramm.Dao.Message;
import bot.telegramm.Service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.*;

@RestController
@Slf4j
public class ControllerMessage {

    ExecutorService service= Executors.newCachedThreadPool();
    @Autowired
    MessageService messageService;
    //  отправляем запрос
    @GetMapping(value ="/{id}")
    public List<Message> shoot(@PathVariable("id") String id ) throws ExecutionException, InterruptedException {
        try{ Callable<List<Message>> call= ()->{ log.info("запрос получен ");
            return messageService.choiceAction(id);};
            return service.submit(call).get();}
        catch (Exception e){log.info("Ошибка ControllerMessage");return new ArrayList<>();}

    }


}
