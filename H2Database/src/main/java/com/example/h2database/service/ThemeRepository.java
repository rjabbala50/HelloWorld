package com.example.h2database.service;

import org.springframework.data.repository.CrudRepository;
import java.math.BigInteger;

public interface ThemeRepository extends CrudRepository<ThemeCollection, BigInteger> {
}
