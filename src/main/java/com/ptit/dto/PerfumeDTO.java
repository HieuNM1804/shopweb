package com.ptit.dto;
import com.ptit.entity.Product;

public class PerfumeDTO extends Product {
    private String fragrance;
    private String brand;
    public String getFragrance() { return fragrance; }
    public void setFragrance(String fragrance) { this.fragrance = fragrance; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
}
