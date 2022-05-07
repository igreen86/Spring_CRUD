package ru.zelenov.springcourse.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.zelenov.springcourse.service.CalcService;

@Service
public class CalcServiceImpl implements CalcService {
  Model model;


  @Override
  public Double add(Double a, Double b) {
    return a + b;
  }

  @Override
  public Double subtract(Double a, Double b) {
    return a - b;
  }

  @Override
  public Double multiply(Double a, Double b) {
    return a * b;
  }

  @Override
  public Double divide(Double a, Double b) {
    return a / b;
  }

  @Override
  public String doAction(Double a, Double b, String action) {
    if (action.equals("+")) {
      return String.valueOf(add(a, b));
    }
    if (action.equals("-")) {
      return String.valueOf(subtract(a, b));
    }
    if (action.equals("*")) {
      return String.valueOf(multiply(a, b));
    }
    if (action.equals("/")) {
      return String.valueOf(divide(a, b));
    }
    return "Wrong action!";
  }
}
