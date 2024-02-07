package com.blueyonder.FS20CrudOperations.service;

import com.blueyonder.FS20CrudOperations.model.Person;
import com.blueyonder.FS20CrudOperations.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// write all the business logic
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person)
    {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons()
    {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id)
    {
        return personRepository.findById(id);
    }

    public Person updatePerson(Long id, Person personDetails)
    {
        Optional<Person> person=personRepository.findById(id);
        if(person.isPresent())
        {
            Person existingPerson = person.get();
            existingPerson.setFirstName(personDetails.getFirstName());
            existingPerson.setLastName(personDetails.getLastName());
            return personRepository.save(existingPerson);
        }
        return null;
    }
    public void deleteAllPersons()
    {
        personRepository.deleteAll();
    }

    public void deletePerson(Long id)
    {
        personRepository.deleteById(id);
    }

}
