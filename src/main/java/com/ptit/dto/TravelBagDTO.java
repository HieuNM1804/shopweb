package com.ptit.dto;
import com.ptit.entity.Product;

public class TravelBagDTO extends Product {
    private String size;
    private String material;
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}
