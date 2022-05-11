package ru.zelenov.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    model.addAttribute("person", personDao.getPerson(id));
    return "people/show";
  }

  @GetMapping("/new")
  public String newPerson(@ModelAttribute("person") Person person) {
    return "people/new";
  }

  @PostMapping("")
  public String create(@ModelAttribute("person") Person person) {
    personDao.save(person);
    return "redirect:/people";
  }

  @GetMapping("/{id}/edit")
  public String edit(Model model, @PathVariable int id) {
    model.addAttribute("person", personDao.getPerson(id));
    return "people/edit";
  }

  @PatchMapping("/{id}")
  public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
    personDao.update(id, person);
    return "redirect:/people";
  }
}
