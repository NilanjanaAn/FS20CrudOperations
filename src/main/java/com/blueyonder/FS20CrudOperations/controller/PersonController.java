package com.blueyonder.FS20CrudOperations.controller;

import com.blueyonder.FS20CrudOperations.model.Person;
import com.blueyonder.FS20CrudOperations.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public String createPerson(@ModelAttribute("person") @Valid Person person, Model model) {
        if (personService.getPersonById(person.getId()).isPresent()) {
            model.addAttribute("duplicateError", "Person with ID " + person.getId() + " already exists");
            return "add_person";
        }

        personService.createPerson(person);
        return getAllPersons(model);
    }

    @GetMapping("/add")
    public String showCreatePerson(Model model) {
        model.addAttribute("person", new Person());
        return "add_person";
    }

    @GetMapping("/search")
    public String showSearchPerson(Model model) {
        model.addAttribute("id", 0L);
        return "search_person";
    }

    @GetMapping
    public String getAllPersons(Model model) {
        List<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "person_list";
    }

    @PostMapping("/search")
    public String getPersonById(@RequestParam Long id, Model model) {
        List<Person> persons = new ArrayList<>();
        Optional<Person> person = personService.getPersonById(id);
        if (person.isPresent()) {
            Person tempPerson = person.get();
            persons.add(tempPerson);
        }
        model.addAttribute("persons", persons);
        return "person_list";
    }

    @PostMapping("/edit/{id}")
    public String showUpdatePerson(@ModelAttribute("id") Long id, @ModelAttribute("firstname") String firstname, @ModelAttribute("lastname") String lastname, Model model) {
        Person person=new Person();
        person.setId(id);
        person.setFirstName(firstname);
        person.setLastName(lastname);
        model.addAttribute("person", person);
        return "edit_person";
    }

    @PutMapping("/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute("person") Person person, Model model) {
        personService.updatePerson(id, person);
        return getPersonById(id, model);
    }

    @DeleteMapping
    public void deleteAllPersons() {
        personService.deleteAllPersons();
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id, Model model) {
        personService.deletePerson(id);
        return getAllPersons(model);
    }
}
