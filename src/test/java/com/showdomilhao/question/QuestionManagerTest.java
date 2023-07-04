package com.showdomilhao.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionManagerTest {

    private final QuestionManager questionManager = new QuestionManager();

    @Test
    void getQuestions() {
        assertTrue(questionManager.getQuestions().size() > 0, "Questions list is empty");
    }

    @Test
    void getRandomEasyQuestion() {
        assertNotNull(questionManager.getRandomQuestion(QuestionDifficulty.EASY), "Question is null");
    }

    @Test
    void getRandomMediumQuestion() {
        assertNotNull(questionManager.getRandomQuestion(QuestionDifficulty.MEDIUM), "Question is null");
    }

    @Test
    void getRandomHardQuestion() {
        assertNotNull(questionManager.getRandomQuestion(QuestionDifficulty.HARD), "Question is null");
    }

    @Test
    @BeforeEach
    void setup() {
        questionManager.setup();
        assertTrue(questionManager.getQuestions().size() > 0, "Questions list is empty");
    }

}