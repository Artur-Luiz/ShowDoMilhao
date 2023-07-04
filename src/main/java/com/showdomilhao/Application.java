package com.showdomilhao;

import com.showdomilhao.game.GameManager;
import com.showdomilhao.util.ColorHelper;

import java.util.Scanner;

public class Application {

    private static final Scanner SCANNER = new Scanner(System.in);

    private final GameManager gameManager = new GameManager(SCANNER);


    public void start() {

        ColorHelper.console(
                """
                        <#d7eb00>Bem-vindo ao Show do Milhão!
                        <#00b3ff>Para jogar, basta responder as perguntas corretamente.
                        <white>Digite "1" para iniciar o jogo!
                                        
                        <#d7eb00>Boa sorte!
                                        
                        <#00b3ff>Desenvolvido por: <white>Artur, Augusto e Gustavo
                        """);

        while (!SCANNER.next().equals("1")) {
        }

        gameManager.start();

        boolean lost = false;

        while (gameManager.hasNext()) {
            if (gameManager.next()) {
                lost = true;
                break;
            }
        }

        if (!lost) {
            gameManager.win();
        }

        SCANNER.close();

    }


}
