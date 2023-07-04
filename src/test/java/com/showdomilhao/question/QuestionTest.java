package com.showdomilhao.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    private final QuestionManager questionManager = new QuestionManager();

    @Test
    void getAnswers() {
        Question question = questionManager.getQuestions().get(0);

        assertEquals(5, question.getAnswers().size());
        assertEquals(1, question.getAnswers().values().stream().filter(answer -> answer).count());

    }

    @Test
    void getCorrectAnswer() {
        Question question = questionManager.getQuestions().get(0);

        assertEquals(question.getCorrectAnswer(), question.getAnswers().entrySet().stream().filter(Map.Entry::getValue).findFirst().orElseThrow().getKey());
    }

    @BeforeEach
    void setup() {
        questionManager.setup();
    }

}