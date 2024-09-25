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
        switch (orientation) {
            case 'N': orientation = 'W'; break;
            case 'W': orientation = 'S'; break;
            case 'S': orientation = 'E'; break;
            case 'E': orientation = 'N'; break;
        }
    }

    public void droite() {
        switch (orientation) {
            case 'N': orientation = 'E'; break;
            case 'E': orientation = 'S'; break;
            case 'S': orientation = 'W'; break;
            case 'W': orientation = 'N'; break;
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }
}
