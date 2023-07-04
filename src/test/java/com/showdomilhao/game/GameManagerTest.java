package com.showdomilhao.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    private final GameManager gameManager = new GameManager(new Scanner(System.in));

    @Test
    void start() {
        gameManager.start();

        assertTrue(gameManager.hasNext(), "Game has no levels");
    }

}