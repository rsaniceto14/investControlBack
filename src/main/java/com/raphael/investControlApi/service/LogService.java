import org.springframework.stereotype.Service;
import com.raphael.investControlApi.model.UserLog;
import com.raphael.investControlApi.repository.UserLogRepository;

@Service
public class LogService {

    private final UserLogRepository userLogRepository;

    public LogService(UserLogRepository userLogRepository) {
        this.userLogRepository = userLogRepository;
    }

    public void log (String userName, String action) {
        if(userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("Usuário não poder ser nulo ou vazio");
        }
        UserLog log = new UserLog(userName, action);
        userLogRepository.save(log);
    }
}