package com.example.h2database;

import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface QuestionRepository extends CrudRepository<ConnectQuestionBank, BigInteger> {
}
