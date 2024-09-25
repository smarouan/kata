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
        if(orientation == 'N'){
            if (y < maxY) y++;
        }
        if(orientation == 'S'){
            if (y > 0) y--;
        }
        if(orientation == 'W'){
            if (x > 0) x--;
        }
        if(orientation == 'E'){
            if(x < maxX) x++;
        }

    }
}
