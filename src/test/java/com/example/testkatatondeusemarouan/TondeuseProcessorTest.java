package com.example.testkatatondeusemarouan;

import com.example.testkatatondeusemarouan.batch.TondeuseProcessor;
import com.example.testkatatondeusemarouan.model.Tondeuse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        TondeuseProcessor processor = new TondeuseProcessor();

        // Simulation de la première ligne (taille de la grille)
        processor.process("5 5");

        // Première tondeuse : position initiale
        processor.process("1 2 N");
        // Instructions pour la première tondeuse
        Tondeuse tondeuse1 = processor.process("GAGAGAGAA");

        assertEquals("1 3 N", tondeuse1.getPosition().toString());
    }
}
