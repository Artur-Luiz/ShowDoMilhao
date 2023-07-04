package com.showdomilhao.help;

import com.showdomilhao.question.Question;

public abstract class Help {


    private final int count;

    protected int currentCount;

    public int getCurrentCount() {
        return currentCount;
    }

    protected Help(int count) {
        this.count = count;
    }

    public abstract boolean handle(Question question);

    public int getCount() {
        return count;
    }

    public void reset(){
        currentCount = count;
    }

}
