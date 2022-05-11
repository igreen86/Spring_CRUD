package ru.zelenov.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.zelenov.spring.dao.PersonDao;
import ru.zelenov.spring.model.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
  private static final String PERSON_ATTR_NAME = "person";
  private static final String REDIRECT_TO_PEOPLE = "redirect:/people";
  private final PersonDao personDao;

  public PeopleController(PersonDao personDao) {
    this.personDao = personDao;
  }


  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("people", personDao.getPeople());
    return "people/index";
  }

  @GetMapping("/{id}")
  public String show(@PathVariable("id") int id, Model model) {
    model.addAttribute(PERSON_ATTR_NAME, personDao.getPerson(id));
    return "people/show";
  }

  @GetMapping("/new")
  public String newPerson(@ModelAttribute(PERSON_ATTR_NAME) Person person) {

    return "people/new";
  }

  @PostMapping("")
  public String create(@ModelAttribute(PERSON_ATTR_NAME) Person person) {
    if (person.getName().isBlank()) {
      return "people/new_blank_name";
    }
    personDao.save(person);
    return REDIRECT_TO_PEOPLE;
  }

  @GetMapping("/{id}/edit")
  public String edit(Model model, @PathVariable int id) {
    model.addAttribute(PERSON_ATTR_NAME, personDao.getPerson(id));
    return "people/edit";
  }

  @PatchMapping("/{id}")
  public String update(@ModelAttribute(PERSON_ATTR_NAME) Person person, @PathVariable("id") int id) {
    personDao.update(id, person);
    return REDIRECT_TO_PEOPLE;
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") int id) {
    personDao.delete(id);
    return REDIRECT_TO_PEOPLE;
  }

  @GetMapping("/{id}/delete")
  public String deleteForm(Model model, @PathVariable("id") int id) {
    model.addAttribute(PERSON_ATTR_NAME, personDao.getPerson(id));
    return "people/delete";
  }
}
