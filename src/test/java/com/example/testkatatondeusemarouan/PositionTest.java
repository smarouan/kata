package com.example.testkatatondeusemarouan;

import com.example.testkatatondeusemarouan.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PositionTest {

    @Test
    public void tesPosition() {
        // Arrange
        Position position = new Position(0, 0, 'N');

        // Assert
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals('N', position.getOrientation());
    }

    @Test
    public void test_avance_position_N(){
        // Arrange
        Position position = new Position(0, 0, 'N');

        position.avance(5,5);

        assertEquals(0, position.getX());
        assertEquals(1, position.getY());
        assertEquals('N', position.getOrientation());
    }

    @Test
    public void test_avance_position_S(){
        // Arrange
        Position position = new Position(0, 1, 'S');

        position.avance(5,5);

        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals('S', position.getOrientation());
    }

    @Test
    public void test_avance_position_W(){
        // Arrange
        Position position = new Position(1, 0, 'W');

        position.avance(5,5);

        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals('W', position.getOrientation());
    }

    @Test
    public void test_avance_position_E(){
        // Arrange
        Position position = new Position(0, 0, 'E');

        position.avance(5,5);

        assertEquals(1, position.getX());
        assertEquals(0, position.getY());
        assertEquals('E', position.getOrientation());
    }

    @Test
    public void test_avance_position_N_with_tailleGrille(){
        // Arrange
        Position position = new Position(5, 5, 'N');

        position.avance(5,5);

        assertEquals(5, position.getX());
        assertEquals(5, position.getY());
        assertEquals('N', position.getOrientation());
    }
}
