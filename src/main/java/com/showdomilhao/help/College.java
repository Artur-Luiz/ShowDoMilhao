package com.showdomilhao.help;

import com.showdomilhao.question.Question;
import com.showdomilhao.util.ColorHelper;
import com.showdomilhao.util.RandomUtils;

import java.util.Map;

public class College extends Help {

    public College() {
        super(1);
    }

    @Override
    public boolean handle(Question question) {

        if (currentCount > 0) {
            currentCount--;

            Map<String, Boolean> answers = question.getAnswers();

            for (int i = 0; i < 5; i++) {

                String answer;
                double random = Math.random() * 100;

                if (random < 60.0) {
                    answer = question.getCorrectAnswer();

                } else {
                    answer = RandomUtils.getRandomElement(answers.entrySet()
                            .stream()
                            .filter(entry -> !entry.getValue())
                            .map(Map.Entry::getKey)
                            .toList()
                    );
                }

                ColorHelper.console(
                        "<#d7eb00> O universitário %d diz que a resposta correta é: <white><bold>%s",
                        i + 1,
                        answer
                );
            }


            return true;
        }

        ColorHelper.console(
                "<#d7eb00> Você não tem mais ajudas dos universitários"
        );

        return false;
    }

}
