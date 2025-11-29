package com.ptit.dto;
import com.ptit.entity.Product;

public class HatDTO extends Product {
    private String color;
    private String style;
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }
}
