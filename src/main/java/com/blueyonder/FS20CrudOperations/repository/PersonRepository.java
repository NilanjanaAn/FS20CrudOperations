package com.blueyonder.FS20CrudOperations.repository;

import com.blueyonder.FS20CrudOperations.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonRepository extends JpaRepository<Person, Long> { }
