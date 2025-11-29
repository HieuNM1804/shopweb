package com.ptit.entity;

public class Phone extends Product {
        @Override
        public String getProductType() {
            return "Phone";
        }
    private String os;
    private String screenSize;
    // getter/setter
    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }
    public String getScreenSize() { return screenSize; }
    public void setScreenSize(String screenSize) { this.screenSize = screenSize; }
}
