package com.showdomilhao.question;

import com.showdomilhao.util.RandomUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class QuestionManager {

    private final List<Question> questions = new ArrayList<>();

    private final List<Integer> alreadyUsedQuestions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getRandomQuestion(QuestionDifficulty difficulty) {

        List<Question> validQuestions = questions.stream()
                .filter(question -> question.getDifficulty() == difficulty)
                .filter(question -> !alreadyUsedQuestions.contains(question.getId()))
                .toList();
        Question question = RandomUtils.getRandomElement(validQuestions);

        if (question == null)
            throw new IllegalStateException("No more questions");

        alreadyUsedQuestions.add(question.getId());
        return question;
    }

    public void setup() {

        questions.clear();
        alreadyUsedQuestions.clear();

        try (InputStream resourceAsStream = QuestionManager.class.getClassLoader().getResourceAsStream("Questions.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resourceAsStream), StandardCharsets.UTF_8));
        ) {
            String line;

            int id = 0;

            while ((line = reader.readLine()) != null) {

                // pular comentários
                if (line.startsWith("#"))
                    continue;

                try {

                    String[] splitedLine = line.split(Pattern.quote("|"));

                    QuestionDifficulty level = QuestionDifficulty.findQuestionLevelByName(splitedLine[0].trim());
                    String question = splitedLine[1].trim();

                    String correctAnswer = splitedLine[2].trim();
                    String wrongAnswer1 = splitedLine[3].trim();
                    String wrongAnswer2 = splitedLine[4].trim();
                    String wrongAnswer3 = splitedLine[5].trim();
                    String wrongAnswer4 = splitedLine[6].trim();

                    Map<String, Boolean> answers = Map.of(
                            correctAnswer, true,
                            wrongAnswer1, false,
                            wrongAnswer2, false,
                            wrongAnswer3, false,
                            wrongAnswer4, false
                    );

                    questions.add(new Question(id++, question, level, answers));

                } catch (Exception e) {
                    // kamradt precisa arrumar algumas questões que não obedecem o formato padrão
                    System.out.println("Error while parsing question: " + line);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
