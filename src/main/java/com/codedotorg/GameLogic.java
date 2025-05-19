package com.codedotorg;

public class GameLogic {

    private int left;
    private int right;
    private int guess;
    private int numGuesses;

    /**
     * Initializes the guessing range and first guess.
     */
    public GameLogic() {
        left = 1;
        right = 100;
        guess = (left + right) / 2;
        numGuesses = 1;
    }

    /**
     * Returns the computer's current guess.
     */
    public int getGuess() {
        return guess;
    }

    /**
     * Returns the number of guesses made so far.
     */
    public int getNumGuesses() {
        return numGuesses;
    }

    /**
     * User says their number is higher.
     */
    public void guessHigher() {
        left = guess + 1;
        guess = (left + right) / 2;
        numGuesses++;
    }

    /**
     * User says their number is lower.
     */
    public void guessLower() {
        right = guess - 1;
        guess = (left + right) / 2;
        numGuesses++;
    }
}
