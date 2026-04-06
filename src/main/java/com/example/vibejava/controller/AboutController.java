package com.example.vibejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Serves the about page so the route is easy to find for beginners.
@Controller
public class AboutController {

  @GetMapping("/about")
  public String about() {
    return "about";
  }
}