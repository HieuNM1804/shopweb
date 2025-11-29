package com.ptit.entity;

public class Hat extends Product {
        @Override
        public String getName() {
            return super.getName() + " (Hat)";
        }
    private String color;
    private String style;
    // getter/setter
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }
}
