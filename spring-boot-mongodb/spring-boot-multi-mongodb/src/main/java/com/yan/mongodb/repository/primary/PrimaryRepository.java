package com.yan.mongodb.repository.primary;


import com.yan.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author neo
 */
public interface PrimaryRepository extends MongoRepository<User, String>
{
}
