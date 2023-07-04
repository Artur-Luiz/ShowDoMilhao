package com.showdomilhao.help;

import com.showdomilhao.question.Question;
import com.showdomilhao.question.QuestionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkipTest {

    private final QuestionManager questionManager = new QuestionManager();

    private final Skip skip = new Skip();

    @Test
    void handle() {

        Question question = questionManager.getQuestions().get(0);

        for (int i = 0; i < 5; i++) {
            skip.handle(question);
        }

        assertFalse(skip.handle(question));
    }

    @BeforeEach
    void setup() {
        questionManager.setup();
    }
}