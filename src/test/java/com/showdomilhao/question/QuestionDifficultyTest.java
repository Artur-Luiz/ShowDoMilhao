package com.showdomilhao.question;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionDifficultyTest {

    @Test
    void findQuestionLevelByName() {
        assertEquals(QuestionDifficulty.EASY, QuestionDifficulty.findQuestionLevelByName("easy"));
        assertEquals(QuestionDifficulty.MEDIUM, QuestionDifficulty.findQuestionLevelByName("medium"));
        assertEquals(QuestionDifficulty.HARD, QuestionDifficulty.findQuestionLevelByName("hard"));
        assertNull(QuestionDifficulty.findQuestionLevelByName("invalid"));
    }
}