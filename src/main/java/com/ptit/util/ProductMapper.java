package com.ptit.util;

import com.ptit.entity.*;
import com.ptit.dto.*;

public class ProductMapper {
    public static Product toEntity(Object dto) {
        if (dto instanceof WatchDTO d) {
            Watch p = new Watch();
            copyCommon(p, d);
            p.setBrand(d.getBrand());
            p.setStrapMaterial(d.getStrapMaterial());
            return p;
        } else if (dto instanceof LaptopDTO d) {
            Laptop p = new Laptop();
            copyCommon(p, d);
            p.setCpu(d.getCpu());
            p.setRam(d.getRam());
            return p;
        } else if (dto instanceof CameraDTO d) {
            Camera p = new Camera();
            copyCommon(p, d);
            p.setResolution(d.getResolution());
            p.setSensorType(d.getSensorType());
            return p;
        } else if (dto instanceof PhoneDTO d) {
            Phone p = new Phone();
            copyCommon(p, d);
            p.setOs(d.getOs());
            p.setScreenSize(d.getScreenSize());
            return p;
        } else if (dto instanceof PerfumeDTO d) {
            Perfume p = new Perfume();
            copyCommon(p, d);
            p.setFragrance(d.getFragrance());
            p.setBrand(d.getBrand());
            return p;
        } else if (dto instanceof JewelryDTO d) {
            Jewelry p = new Jewelry();
            copyCommon(p, d);
            p.setMaterial(d.getMaterial());
            p.setGemstone(d.getGemstone());
            return p;
        } else if (dto instanceof HatDTO d) {
            Hat p = new Hat();
            copyCommon(p, d);
            p.setColor(d.getColor());
            p.setStyle(d.getStyle());
            return p;
        } else if (dto instanceof TravelBagDTO d) {
            TravelBag p = new TravelBag();
            copyCommon(p, d);
            p.setSize(d.getSize());
            p.setMaterial(d.getMaterial());
            return p;
        } else if (dto instanceof Product p) {
            return p;
        }
        return null;
    }

    public static Object toDTO(Product product) {
        if (product.getCategory() != null && product.getCategory().getName() != null) {
            String cat = product.getCategory().getName();
            switch (cat) {
                case "Đồng hồ đeo tay":
                    WatchDTO w = new WatchDTO();
                    copyCommon(w, product);
                    // TODO: map thuộc tính riêng nếu có
                    return w;
                case "Máy tính xách tay":
                    LaptopDTO l = new LaptopDTO();
                    copyCommon(l, product);
                    return l;
                case "Máy ảnh":
                    CameraDTO c = new CameraDTO();
                    copyCommon(c, product);
                    return c;
                case "Điện thoại":
                    PhoneDTO p = new PhoneDTO();
                    copyCommon(p, product);
                    return p;
                case "Nước hoa":
                    PerfumeDTO pf = new PerfumeDTO();
                    copyCommon(pf, product);
                    return pf;
                case "Nữ trang":
                    JewelryDTO j = new JewelryDTO();
                    copyCommon(j, product);
                    return j;
                case "Nón thời trang":
                    HatDTO h = new HatDTO();
                    copyCommon(h, product);
                    return h;
                case "Túi xách du lịch":
                    TravelBagDTO t = new TravelBagDTO();
                    copyCommon(t, product);
                    return t;
            }
        }
        return product;
    }

    private static void copyCommon(Product to, Product from) {
        to.setId(from.getId());
        to.setName(from.getName());
        to.setImage(from.getImage());
        to.setPublic_id(from.getPublic_id());
        to.setPrice(from.getPrice());
        to.setQuantity(from.getQuantity());
        to.setCreateDate(from.getCreateDate());
        to.setAvailable(from.getAvailable());
        to.setCategory(from.getCategory());
    }
}
