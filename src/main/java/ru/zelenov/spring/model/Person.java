package ru.zelenov.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  private int id;

  @NotEmpty(message = "Name must not be blank!")
  @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters long!")
  private String name;

  @Min(value = 18, message = "You must be at least 18 years old")
  @Max(value = 150, message = "Max age is 150")
  private int age;

  @NotEmpty(message = "Email must not be blank!")
  @Email(message = "Email should be valid!")
  private String email;
}

