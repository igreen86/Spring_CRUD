package ru.zelenov.spring.dao;

import org.springframework.stereotype.Component;
import ru.zelenov.spring.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
  private final List<Person> people;
  private static int peopleCount;
  private final Object lock = new Object();

  {
    people = new ArrayList<>();
    people.add(new Person(++peopleCount, "John"));
    people.add(new Person(++peopleCount, "Dayneris"));
    people.add(new Person(++peopleCount, "Sansa"));
    people.add(new Person(++peopleCount, "Robert"));
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

  public void save(Person person) {
    synchronized (lock) {
      person.setId(++peopleCount);
    }
    people.add(person);
  }
}
