package bot.telegramm.Repository;

import bot.telegramm.Dao.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value ="select * FROM public.message\n" +
            "order by date desc\n" +
            "limit 10;" ,nativeQuery = true )
    List<Message> findAll10records();
}
