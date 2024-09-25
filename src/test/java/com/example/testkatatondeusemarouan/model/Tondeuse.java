package com.example.testkatatondeusemarouan.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tondeuse {

    private Position position;


    public void executeCommand(char commands, int maxX, int maxY) {
        if(commands == 'G'){
            position.gauche();
        }

    }
}
