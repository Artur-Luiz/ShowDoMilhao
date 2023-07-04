package com.showdomilhao.game;

import com.showdomilhao.question.QuestionDifficulty;

public class GameLevel {
    private final int level;
    private final int hitPrize;

    private final int quitPrize;

    private final int faultPrize;

    private final QuestionDifficulty difficulty;

    public GameLevel(int level, int hitPrize, int quitPrize, int faultPrize, QuestionDifficulty difficulty) {
        this.level = level;
        this.hitPrize = hitPrize;
        this.quitPrize = quitPrize;
        this.faultPrize = faultPrize;
        this.difficulty = difficulty;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPrize() {
        return hitPrize;
    }

    public int getQuitPrize() {
        return quitPrize;
    }

    public int getFaultPrize() {
        return faultPrize;
    }

    public QuestionDifficulty getDifficulty() {
        return difficulty;
    }
}
