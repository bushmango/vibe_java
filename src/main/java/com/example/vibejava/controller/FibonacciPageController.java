package com.example.vibejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Serves a small page that calls the Fibonacci API from the browser.
@Controller
public class FibonacciPageController {

  @GetMapping("/fib")
  public String fibPage() {
    return "fib";
  }
}