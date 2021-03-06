package ru.zelenov.spring.dao;

import org.springframework.stereotype.Component;
import ru.zelenov.spring.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
  private static int peopleCount;
  private final List<Person> people;
  private final Object lock = new Object();

  {
    people = new ArrayList<>();
    people.add(new Person(++peopleCount, "John",18, "john@north.no"));
    people.add(new Person(++peopleCount, "Dayneris", 19, "danya@westeros.we"));
    people.add(new Person(++peopleCount, "Sansa", 16, "samsa@north.no"));
    people.add(new Person(++peopleCount, "Robert", 33, "bob@king.gov"));
  }

  public List<Person> getPeople() {
    return people;
  }

  public Person getPerson(int id) {
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

  public void update(int id, Person person) {
    getPerson(id).setName(person.getName());
    getPerson(id).setAge(person.getAge());
    getPerson(id).setEmail(person.getEmail());
  }

  public void delete(int id) {
    people.removeIf(p -> p.getId() == id);
  }
}
