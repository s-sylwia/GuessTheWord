package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class GuessTheWordTest {

    GuessTheWord guessTheWord;

    @BeforeEach
    public void setup() {
        guessTheWord = new GuessTheWord();
    }

    @Test
    public void testGameEndedWhenLivesZero() {
        guessTheWord.lives = 0;
        boolean result = guessTheWord.gameEnded();
        Assertions.assertTrue(result, "gameEnded should return true when lives is zero");
    }

    @Test
    public void testGameEndedWhenWordGuessed() {
        guessTheWord.word = "programming";
        guessTheWord.userWord = "programming".toCharArray();
        boolean result = guessTheWord.gameEnded();
        Assertions.assertTrue(result, "gameEnded should return true when the word is guessed");
    }

    @Test
    public void testCheckLetterCorrectLetter() {
        guessTheWord.word = "cat";
        guessTheWord.userWord = "__t".toCharArray();
        guessTheWord.checkLetter('c');
        String expected = "c_t";
        Assertions.assertEquals(expected, String.valueOf(guessTheWord.userWord), "checkLetter should update userWord with the correct letter");
    }

    @Test
    public void testCheckLetterWrongLetter() {
        guessTheWord.word = "car";
        guessTheWord.userWord = "__t".toCharArray();
        guessTheWord.checkLetter('e');
        int expectedLives = 2;
        Assertions.assertEquals(expectedLives, guessTheWord.lives, "checkLetter should decrease lives when the letter is incorrect");
    }

    @Test
    public void testCheckLetterMultipleOccurrences() {
        guessTheWord.word = "programming";
        guessTheWord.userWord = "___________".toCharArray();
        guessTheWord.checkLetter('g');
        String expected = "_g_________";
        Assertions.assertEquals(expected, String.valueOf(guessTheWord.userWord), "checkLetter should update userWord with all occurrences of the letter");

    }
}