package com.example.vibejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Serves the contact page using a simple MVC controller.
@Controller
public class ContactController {

  @GetMapping("/contact")
  public String contact() {
    return "contact";
  }
}