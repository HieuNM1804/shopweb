package com.ptit.service;

import com.ptit.service.strategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private List<DiscountStrategy> discountStrategies;

    /**
     * Tính toán giảm giá tốt nhất cho đơn hàng (ví dụ: lấy mức giảm giá cao nhất)
     */
    public double calculateBestDiscount(com.ptit.entity.Order order) {
        double maxDiscount = 0.0;
        for (DiscountStrategy strategy : discountStrategies) {
            double discount = strategy.calculateDiscount(order);
            if (discount > maxDiscount) {
                maxDiscount = discount;
            }
        }
        return maxDiscount;
    }
}
