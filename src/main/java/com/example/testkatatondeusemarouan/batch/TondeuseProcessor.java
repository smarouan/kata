package com.example.testkatatondeusemarouan.batch;

import com.example.testkatatondeusemarouan.model.Position;
import com.example.testkatatondeusemarouan.model.Tondeuse;
import org.springframework.batch.item.ItemProcessor;

public class TondeuseProcessor implements ItemProcessor<String, Tondeuse> {

   private int maxX;
    private int maxY;
    private boolean isFirstLine = true;

    private Tondeuse currentTondeuse;

    @Override
    public Tondeuse process(String item) throws Exception {
        if(isFirstLine) {
            String[] dimensions = item.split(" ");
            maxX = Integer.parseInt(dimensions[0]);
            maxY = Integer.parseInt(dimensions[1]);
            isFirstLine = false;
            return null;
        }

        if(currentTondeuse == null) {
            String[] parts = item.split(" ");
            Position position = new Position(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2].charAt(0));
            currentTondeuse = new Tondeuse(position);
            return null;
        } else {
        currentTondeuse.executeCommands(item, maxX, maxY);
        Tondeuse processedTondeuse = currentTondeuse;
        currentTondeuse = null;
        return processedTondeuse;
    }

    }
}
