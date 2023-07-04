package com.showdomilhao.question;

import java.util.Arrays;

public enum QuestionDifficulty {
    EASY,
    MEDIUM,
    HARD;

    public static QuestionDifficulty findQuestionLevelByName(String name){
        return Arrays.stream(values())
                .filter(questionLevel -> questionLevel.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
