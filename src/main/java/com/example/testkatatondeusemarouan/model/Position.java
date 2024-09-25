package com.example.testkatatondeusemarouan.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    private int x;

    private int y;

    private char orientation;

    public void avance(int maxX, int maxY) {
        switch (orientation) {
            case 'N': if (y < maxY) y++; break;
            case 'E': if (x < maxX) x++; break;
            case 'S': if (y > 0) y--; break;
            case 'W': if (x > 0) x--; break;
        }

    }

    public void gauche() {
        if(orientation == 'N'){
            orientation = 'W';
        }
    }
}
