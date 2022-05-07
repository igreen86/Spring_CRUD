package ru.zelenov.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zelenov.springcourse.service.CalcService;

@Controller
public class WebCalcController {

  private final CalcService calcService;

  WebCalcController(CalcService calcService) {

    this.calcService = calcService;
  }

  @GetMapping("/calc")
  public String calc(@RequestParam(value = "a") Double a,
                     @RequestParam(value = "b") Double b,
                     @RequestParam(value = "action") String action,
                     Model model) {
    model.addAttribute("a", a);
    model.addAttribute("b", b);
    model.addAttribute("action", action);
    model.addAttribute("result", calcService.doAction(a, b, action));
    return "/calc/calc";
  }
}
