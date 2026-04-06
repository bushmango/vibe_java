package com.example.vibejava.controller;

import com.example.vibejava.service.FibonacciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Exposes a small JSON API for Fibonacci values.
@RestController
@RequestMapping("/api")
public class FibonacciApiController {

  private final FibonacciService fibonacciService;

  public FibonacciApiController(FibonacciService fibonacciService) {
    this.fibonacciService = fibonacciService;
  }

  @GetMapping("/fib")
  public ResponseEntity<?> fib(@RequestParam int n) {
    try {
      long value = fibonacciService.calculate(n);
      return ResponseEntity.ok(new FibonacciResponse(n, value));
    } catch (IllegalArgumentException exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ApiErrorResponse(exception.getMessage()));
    }
  }

  private record FibonacciResponse(int n, long value) {
  }

  private record ApiErrorResponse(String error) {
  }
}