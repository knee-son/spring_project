package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GuessingGameService {

    private final Random random = new Random();
    private int numberToGuess;

    public GuessingGameService() {
        startNewGame();
    }

    public void startNewGame() {
        numberToGuess = random.nextInt(100) + 1; // Number between 1 and 100
    }

    public String guess(int number) {
        if (number < 1 || number > 100) {
            return "Guess must be between 1 and 100.";
        }
        if (number == numberToGuess) {
            startNewGame(); // Start a new game
            return "Congratulations! You guessed the number!";
        }
        return number < numberToGuess ? "Too low! Try again." : "Too high! Try again.";
    }
}
