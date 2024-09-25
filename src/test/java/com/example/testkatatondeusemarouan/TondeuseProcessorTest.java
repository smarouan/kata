package com.example.testkatatondeusemarouan;

import com.example.testkatatondeusemarouan.batch.TondeuseProcessor;
import com.example.testkatatondeusemarouan.model.Tondeuse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TondeuseProcessorTest {

    @Test
    public void testProcessorWithValidInputFirstLine() throws Exception {
        TondeuseProcessor processor = new TondeuseProcessor();

        // Simulation de la première ligne (taille de la grille)
        Tondeuse tondeuse = processor.process("5 5");

        assertNull(tondeuse);
    }

    @Test
    public void testProcessorWithValidInputWithTondeuse() throws Exception {
        // Arrange
        TondeuseProcessor processor = new TondeuseProcessor();

        processor.process("5 5");

        // Acte
        Tondeuse tondeuse = processor.process("1 2 N");

        // Assert
        assertNotNull(tondeuse);
        assertEquals("1 2 N", tondeuse.getPosition().toString());
    }

    @Test
    public void testProcessorWithValidInputWithCommand() throws Exception {
        // Arrange
        TondeuseProcessor processor = new TondeuseProcessor();

        processor.process("5 5");

        // Acte
        processor.process("1 2 N");

        Tondeuse tondeuse = processor.process("GAGAGAGAA");

       // Assert
        assertNotNull(tondeuse);
        assertEquals("1 3 N", tondeuse.getPosition().toString());

    }

}
