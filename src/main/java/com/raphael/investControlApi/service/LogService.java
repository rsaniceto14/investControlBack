
public class LogService {

    private UserLogRepository userLogRepository;

    public LogService(UserLogRepository userLogRepository) {
        this.userLogRepository = userLogRepository;
    }

    public void log (string userName, String action) {
        UserLog log = new UserLog(userName, action);
        userLogRepository.save(log);
    }
}