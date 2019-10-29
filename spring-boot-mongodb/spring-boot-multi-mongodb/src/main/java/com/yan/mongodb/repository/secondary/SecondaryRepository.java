package com.yan.mongodb.repository.secondary;


import com.yan.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author neo
 */
public interface SecondaryRepository extends MongoRepository<User, String>
{
}
