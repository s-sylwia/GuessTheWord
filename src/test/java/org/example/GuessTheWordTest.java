package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuessTheWordTest {

    @Test
    public void testGameEnded() {
        // Test sprawdzający, czy gra zakończy się, gdy użytkownik przegra
        GuessTheWord game = new GuessTheWord();
        game.word = "cat";
        game.userWord = new char[] {'_', '_', '_'};
        game.lives = 0;
        assertTrue(game.gameEnded());

        // Test sprawdzający, czy gra zakończy się, gdy użytkownik wygra
        game = new GuessTheWord();
        game.word = "cat";
        game.userWord = new char[] {'c', 'a', 't'};
        game.lives = 2;
        assertTrue(game.gameEnded());

        // Test sprawdzający, że gra nie zakończy się, gdy użytkownik nie wygra ani nie przegrał
        game = new GuessTheWord();
        game.word = "cat";
        game.userWord = new char[] {'c', '_', 't'};
        game.lives = 2;
        assertFalse(game.gameEnded());
    }

    @Test
    public void testCheckLetter() {
        // Test sprawdzający, czy podana litera zostanie dodana do userWord, gdy jest w słowie
        GuessTheWord game = new GuessTheWord();
        game.word = "cat";
        game.userWord = new char[] {'_', '_', '_'};
        game.checkLetter('c');
        assertArrayEquals(new char[] {'c', '_', '_'}, game.userWord);

        // Test sprawdzający, czy życia zostaną odjęte, gdy podana litera nie ma w słowie
        game = new GuessTheWord();
        game.word = "cat";
        game.userWord = new char[] {'_', '_', '_'};
        game.checkLetter('d');
        assertEquals(2, game.lives);

        // Test sprawdzający, czy nie zostaną odjęte życia, gdy podana litera jest w słowie
        game = new GuessTheWord();
        game.word = "cat";
        game.userWord = new char[] {'_', '_', '_'};
        game.checkLetter('c');
        assertEquals(3, game.lives);
    }

}