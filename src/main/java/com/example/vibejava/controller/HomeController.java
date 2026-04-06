package com.example.vibejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Serves the main landing page for the website.
@Controller
public class HomeController {

  @GetMapping("/")
  public String home() {
    return "home";
  }
}