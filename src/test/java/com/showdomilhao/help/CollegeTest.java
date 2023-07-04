package com.showdomilhao.help;

import com.showdomilhao.question.Question;
import com.showdomilhao.question.QuestionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollegeTest {

    private final QuestionManager questionManager = new QuestionManager();

    private final College college = new College();

    @Test
    void handle() {

        Question question = questionManager.getQuestions().get(0);

        for (int i = 0; i < 5; i++) {
            college.handle(question);
        }

        assertFalse(college.handle(question));
    }

    @BeforeEach
    void setup() {
        questionManager.setup();
    }

}