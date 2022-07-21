package com.example.h2database.repository;

import com.example.h2database.documents.ConnectQuestionBank;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//import javax.persistence.MappedSuperclass;

public interface QuestionRepository extends MongoRepository<ConnectQuestionBank, String>{

}
