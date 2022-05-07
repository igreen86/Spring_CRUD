package ru.zelenov.springcourse.service;

import org.springframework.stereotype.Component;

@Component
public interface CalcService {
  Double add(Double a, Double b);
  Double subtract(Double a, Double b);
  Double multiply(Double a, Double b);
  Double divide(Double a, Double b);

  String doAction(Double a, Double b, String action);
}
