package com.preet.task1;

import com.preet.task1.model.serverModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// <kis type ka data, primary Key>
public interface serverRepository extends MongoRepository<serverModel, String>
{
    List<serverModel> findByName(String name);
}
