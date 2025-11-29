package com.ptit.dto;
import com.ptit.entity.Product;

public class PhoneDTO extends Product {
    private String os;
    private String screenSize;
    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }
    public String getScreenSize() { return screenSize; }
    public void setScreenSize(String screenSize) { this.screenSize = screenSize; }
}
