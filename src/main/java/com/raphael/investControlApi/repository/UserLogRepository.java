package com.raphael.investControlApi.model;
import com.raphael.investControlApi.model.UserLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserLogRepository extends MongoRepository<UserLog, String> {
    // Custom query methods can be defined here if needed
}