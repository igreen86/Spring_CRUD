package ru.zelenov.spring.dao;

import org.springframework.stereotype.Component;
import ru.zelenov.spring.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
  private List<Person> people;
  private static int PEOPLE_COUNT;

  {
    people = new ArrayList<>();
    people.add(new Person(++PEOPLE_COUNT, "John"));
    people.add(new Person(++PEOPLE_COUNT, "Dayneris"));
    people.add(new Person(++PEOPLE_COUNT, "Sansa"));
    people.add(new Person(++PEOPLE_COUNT, "Robert"));
  }

  public List<Person> index() {
    return people;
  }

  public Person show(int id) {
    return people.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElse(null);
  }
}
