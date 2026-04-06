package com.example.vibejava.service;

import org.springframework.stereotype.Service;

// Keeps the Fibonacci logic in one place so controllers stay simple.
@Service
public class FibonacciService {

  private static final int MAX_INDEX = 92;

  public long calculate(int n) {
    if (n < 0 || n > MAX_INDEX) {
      throw new IllegalArgumentException("n must be between 0 and " + MAX_INDEX);
    }

    if (n < 2) {
      return n;
    }

    long previous = 0;
    long current = 1;

    for (int index = 2; index <= n; index++) {
      long next = previous + current;
      previous = current;
      current = next;
    }

    return current;
  }
}