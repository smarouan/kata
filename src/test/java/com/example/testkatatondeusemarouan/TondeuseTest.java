package com.example.testkatatondeusemarouan;

import com.example.testkatatondeusemarouan.model.Position;
import com.example.testkatatondeusemarouan.model.Tondeuse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TondeuseTest {


    @Test
    public void test_tondeuse_cmmand_G_position_N() {
        // Arrange position intial de tondeuse
        Position startPosition = new Position(0, 0, 'N');
        Tondeuse tondeuse = new Tondeuse(startPosition);

        // Act
        char commands = 'G';
        tondeuse.executeCommand(commands, 5,5);

        Position endPosition = tondeuse.getPosition();

        assertEquals('W', endPosition.getOrientation());
    }

    @Test
    public void test_tondeuse_cmmand_G_position_W() {
        // Arrange position intial de tondeuse
        Position startPosition = new Position(0, 0, 'W');
        Tondeuse tondeuse = new Tondeuse(startPosition);

        // Act
        char commands = 'G';  // Ordre tiré de l'exemple
        tondeuse.executeCommand(commands, 5,5);

        Position endPosition = tondeuse.getPosition();

        assertEquals('S', endPosition.getOrientation());
    }

    @Test
    public void test_tondeuse_cmmand_G_position_S() {
        // Arrange
        Position startPosition = new Position(0, 0, 'S');
        Tondeuse tondeuse = new Tondeuse(startPosition);

        // Act
        char commands = 'G';
        tondeuse.executeCommand(commands, 4, 4);

        Position endPosition = tondeuse.getPosition();

        assertEquals('E', endPosition.getOrientation());
    }

    @Test
    public void test_tondeuse_cmmand_G_position_E() {
        // Arrange position intial de tondeuse
        Position startPosition = new Position(0, 0, 'E');
        Tondeuse tondeuse = new Tondeuse(startPosition);

        // Act
        char commands = 'G';  // Ordre tiré de l'exemple
        tondeuse.executeCommand(commands, 3, 4);

        Position endPosition = tondeuse.getPosition();

        assertEquals('N', endPosition.getOrientation());
    }

    @Test
    public void test_tondeuse_cmmand_D_position_N() {
        // Arrange position intial de tondeuse
        Position startPosition = new Position(0, 0, 'N');
        Tondeuse tondeuse = new Tondeuse(startPosition);

        // Act
        char commands = 'D';  // Ordre tiré de l'exemple
        tondeuse.executeCommand(commands, 5,5);

        Position endPosition = tondeuse.getPosition();

        assertEquals('E', endPosition.getOrientation());
    }

    @Test
    public void test_tondeuse_cmmand_D_position_W() {
        // Arrange position intial de tondeuse
        Position startPosition = new Position(0, 0, 'W');
        Tondeuse tondeuse = new Tondeuse(startPosition);

        // Act
        char commands = 'D';  // Ordre tiré de l'exemple
        tondeuse.executeCommand(commands, 5,5);

        Position endPosition = tondeuse.getPosition();

        // Assert
        assertEquals('N', endPosition.getOrientation());
    }

    @Test
    public void test_tondeuse_cmmand_A_position_N() {
        // Arrange position intial de tondeuse
        Position startPosition = new Position(0, 0, 'N');
        Tondeuse tondeuse = new Tondeuse(startPosition);

        // Act
        char commands = 'A';
        tondeuse.executeCommand(commands, 5,5);

        Position endPosition = tondeuse.getPosition();

        // Assert
        assertEquals(1, endPosition.getY());
    }

    @Test
    public void test_tondeuse_cmmand_A_position_S() {
        // Arrange position intial de tondeuse
        Position startPosition = new Position(0, 0, 'S');
        Tondeuse tondeuse = new Tondeuse(startPosition);

        // Act
        char commands = 'A';
        tondeuse.executeCommand(commands, 5,5);

        Position endPosition = tondeuse.getPosition();

        // Assert
        assertEquals(0, endPosition.getY());
    }

    @Test
    public void test_tondeuse_commands() {
        // Arrange position intial de tondeuse
        Position startPosition = new Position(1, 2, 'N');
        Tondeuse tondeuse = new Tondeuse(startPosition);

        // Act
        String commands = "GAGAGAGAA";
        tondeuse.executeCommands(commands, 5, 5);

        Position endPosition = tondeuse.getPosition();

        // Assert
        assertEquals(1, endPosition.getX());
        assertEquals(3, endPosition.getY());
        assertEquals('N', endPosition.getOrientation());
    }




}
