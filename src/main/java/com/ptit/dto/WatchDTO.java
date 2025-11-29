package com.ptit.dto;
import com.ptit.entity.Product;

public class WatchDTO extends Product {
    private String brand;
    private String strapMaterial;
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getStrapMaterial() { return strapMaterial; }
    public void setStrapMaterial(String strapMaterial) { this.strapMaterial = strapMaterial; }
}
