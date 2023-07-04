package com.showdomilhao.help;

import com.showdomilhao.question.Question;
import com.showdomilhao.util.ColorHelper;

public class Skip extends Help{

    public Skip() {
        super(3);
    }

    @Override
    public boolean handle(Question question) {
        if (currentCount > 0) {
            currentCount--;

            ColorHelper.console(
                    "<#d7eb00> Você pulou a pergunta, a resposta correta era: <white><bold>%s",
                    question.getCorrectAnswer()
            );

            return true;
        }

        ColorHelper.console(
                "<#d7eb00> Você não tem mais pulos"
        );

        return false;
    }


}
