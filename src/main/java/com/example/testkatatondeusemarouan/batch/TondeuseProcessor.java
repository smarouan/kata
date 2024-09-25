package com.example.testkatatondeusemarouan.batch;

import com.example.testkatatondeusemarouan.model.Tondeuse;
import org.springframework.batch.item.ItemProcessor;

public class TondeuseProcessor implements ItemProcessor<String, Tondeuse> {


    @Override
    public Tondeuse process(String item) throws Exception {
        String[] dimensions = item.split(" ");
        int maxX = Integer.parseInt(dimensions[0]);
        int maxY = Integer.parseInt(dimensions[1]);
        return null;
    }
}
