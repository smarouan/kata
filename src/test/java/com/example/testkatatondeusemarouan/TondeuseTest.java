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



}
