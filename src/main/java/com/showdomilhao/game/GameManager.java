package com.showdomilhao.game;

import com.showdomilhao.help.College;
import com.showdomilhao.help.Help;
import com.showdomilhao.help.Skip;
import com.showdomilhao.question.Question;
import com.showdomilhao.question.QuestionDifficulty;
import com.showdomilhao.question.QuestionManager;
import com.showdomilhao.util.ColorHelper;
import com.showdomilhao.util.NumberHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

public class GameManager {
    private final Map<Integer, GameLevel> levels = new HashMap<>();

    private final QuestionManager questionManager = new QuestionManager();

    private final Help college = new College();

    private final Help skip = new Skip();

    private final Scanner scanner;

    private Question currentQuestion;

    private List<String> answers;

    private int currentLevel;

    public GameManager(Scanner scanner) {
        this.scanner = scanner;
        setupLevels();
    }

    public void start() {
        college.reset();
        skip.reset();
        questionManager.setup();
        currentLevel = 0;

    }

    public boolean hasNext() {
        return levels.containsKey(currentLevel + 1);
    }

    public boolean next() {
        currentLevel++;
        rollQuestion();
        return processInput();
    }

    private void rollQuestion() {
        GameLevel level = levels.get(currentLevel);
        currentQuestion = questionManager.getRandomQuestion(level.getDifficulty());
        answers = new ArrayList<>(currentQuestion.getAnswers().keySet());
        Collections.shuffle(answers);

        ColorHelper.console(
                """
                        <white>|⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊⚊
                        <#d7eb00>| Pergunta Valendo %d
                                        
                        <white><bold>| %s
                                        
                        <white>1. %s
                        <white>2. %s
                        <white>3. %s
                        <white>4. %s
                        <white>5. %s
                                        
                        <#00ff04>Mande <white>"c"</white> para pedir ajuda aos universitarios! Restam: %d <white> |    <#00ff04>Mande <white>"p"</white> para pular a pergunta! Restam: %d
                        <#fa0217>Mande <white>"q"</white> para sair com %d!
                                        
                        <#ff0303> Caso erre a pergunta, saira com %d!
                                        
                                        
                        <#00b3ff>Digite o numero correspondente da alternativa:
                        """,
                level.getHitPrize(),
                currentQuestion.getQuestion(),
                answers.get(0),
                answers.get(1),
                answers.get(2),
                answers.get(3),
                answers.get(4),
                college.getCurrentCount(),
                skip.getCurrentCount(),
                level.getQuitPrize(),
                level.getFaultPrize()
        );
    }

    public boolean processInput() {
        String input = scanner.next();

        if (NumberHelper.isInteger(input)) {
            int questionId = Integer.parseInt(input);
            if (questionId < 1 || questionId > 5) {
                ColorHelper.console(
                        "<#d7eb00> Digite um numero entre 1 e 5!"
                );
                return processInput();
            }
            String answer = answers.get(questionId - 1);

            if (!currentQuestion.getCorrectAnswer().equals(answer)) {
                ColorHelper.console(
                        """
                                <#d7eb00> Voce perdeu e saiu com %d!
                                """,
                        levels.get(currentLevel).getFaultPrize()
                );
                return true;
            }

            return false;
        } else {
            switch (input) {
                case "c" -> {
                    college.handle(currentQuestion);
                    return processInput();
                }
                case "p" -> {
                    if (skip.handle(currentQuestion)) {
                        rollQuestion();
                    }
                    return processInput();
                }
                case "q" -> {
                    ColorHelper.console(
                            """
                                    <#d7eb00> Voce saiu com %d!
                                    """,
                            levels.get(currentLevel).getQuitPrize()
                    );
                    return true;
                }
                default -> {
                    ColorHelper.console(
                            "<#d7eb00> Digite um numero entre 1 e 5!"
                    );
                    return processInput();
                }
            }
        }
    }

    public void win() {
        ColorHelper.console(
                """
                        <#d7eb00> Voce ganhou o jogo e saiu com %d!
                        """,
                levels.get(currentLevel).getHitPrize()
        );
    }

    private void setupLevels() {
        try (InputStream resourceAsStream = QuestionManager.class.getClassLoader().getResourceAsStream("Score.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resourceAsStream), StandardCharsets.UTF_8))
        ) {
            String line;

            int id = 1;

            while ((line = reader.readLine()) != null) {

                // pular comentários
                if (line.startsWith("#"))
                    continue;

                String[] splitedLine = line.split(Pattern.quote("|"));

                int hitPrize = Integer.parseInt(splitedLine[0].trim());
                int quitPrize = Integer.parseInt(splitedLine[1].trim());
                int faultPrize = Integer.parseInt(splitedLine[2].trim());
                QuestionDifficulty difficulty = QuestionDifficulty.findQuestionLevelByName(splitedLine[3].trim());

                levels.put(id++, new GameLevel(id, hitPrize, quitPrize, faultPrize, difficulty));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
