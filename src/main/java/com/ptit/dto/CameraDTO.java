package com.ptit.dto;
import com.ptit.entity.Product;

public class CameraDTO extends Product {
    private String resolution;
    private String sensorType;
    public String getResolution() { return resolution; }
    public void setResolution(String resolution) { this.resolution = resolution; }
    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
}
