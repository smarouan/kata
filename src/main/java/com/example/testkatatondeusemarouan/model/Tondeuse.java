package com.example.testkatatondeusemarouan.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tondeuse {

    private Position position;


    public void executeCommand(char command, int maxX, int maxY) {
        switch (command) {
            case 'A': position.avance(maxX, maxY); break;
            case 'G': position.gauche(); break;
            case 'D': position.droite(); break;
        }

    }

    public void executeCommands(String commands, int maxX, int maxY) {
        for (char command : commands.toCharArray()) {
            executeCommand(command, maxX, maxY);
        }
    }
}
