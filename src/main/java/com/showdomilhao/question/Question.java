package com.showdomilhao.question;

import java.util.Map;
import java.util.Objects;

public class Question {
    private final int id;
    private final String question;
    private final QuestionDifficulty level;
    private final Map<String, Boolean> answer;

    public Question(int id, String question, QuestionDifficulty level, Map<String, Boolean> answer) {
        this.id = id;
        this.question = question;
        this.level = level;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public QuestionDifficulty getDifficulty() {
        return level;
    }

    public Map<String, Boolean> getAnswers() {
        return answer;
    }

    public String getCorrectAnswer() {
        return answer.entrySet().stream().filter(Map.Entry::getValue).findFirst().orElseThrow().getKey();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && level == question1.level && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, level, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", level=" + level +
                ", answer=" + answer +
                '}';
    }
}
