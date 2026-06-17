package com.example.carpickerdbxampp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Brand {

    private final String brandName;
    private final List<String> modelsList;
    private final HashMap<String ,Media> media =new HashMap<>();


    public Brand(String brandName, String models, String imageUrls) {
        this.brandName = brandName;
        modelsList = Arrays.asList(models.split(","));
        List<String> imageUrlsList = Arrays.asList(imageUrls.split(","));
        for (int i = 0; i < modelsList.size(); i++) {
            media.put(modelsList.get(i), new Media(imageUrlsList.get(i)));
        }
    }
    public Media getMedia(String key){
        return this.media.get(key);
    }


    public String getBrandName() {
        return brandName;
    }

    public List<String> getModels() {
        return modelsList;
    }

    public void addModel(String model) {
        modelsList.add(model);
    }
}
