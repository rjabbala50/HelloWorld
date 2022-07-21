package com.example.h2database.repository;

import com.example.h2database.documents.ThemeCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

//import javax.persistence.MappedSuperclass;

public interface ThemeRepository extends MongoRepository<ThemeCollection,String>{

}
