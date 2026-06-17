package com.example.carpickerdbxampp;

import java.util.ArrayList;
import java.util.List;

public class BrandsList {

    private  List<Brand> brandsList;

    public BrandsList(String ip) {
        brandsList = new ArrayList<>();
        String url=  "http://"+ip+"/multimediaDBServices/getMedia.php";
        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            brandsList = okHttpHandler.getCarData(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBrand(Brand brand) {
        brandsList.add(brand);
    }

    public void addModel(String brandName, String model) {
        for (Brand brand: brandsList)
            if (brand.getBrandName().equals(brandName))
                brand.addModel(model);
    }

    public List<String> getModels(String brandName) {
        for (Brand brand: brandsList)
            if (brand.getBrandName().equals(brandName))
                return brand.getModels();
        return null;
    }
    public List<String> getAllBrandNames() {
        List<String> brands = new ArrayList<>();
        for (Brand brand: brandsList)
            brands.add(brand.getBrandName());
        return brands;
    }
    /**
     * Method added to return CarBrand.Media object when model is provided
     **/
    public Media lookup(String brandName, String model) {
        for (Brand brand: brandsList)
            if (brand.getBrandName().equals(brandName))
                return brand.getMedia(model);
        return null;
    }
}
