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
            y++;
        }
        if(orientation == 'S'){
            y--;
        }
        if(orientation == 'W'){
            x--;
        }
        if(orientation == 'E'){
            x++;
        }

    }
}
