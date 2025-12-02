package com.ptit.service.strategy;

import com.ptit.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class PercentageDiscountStrategy implements DiscountStrategy {

    private static final double DISCOUNT_RATE = 0.1; // 10%

    @Override
    public double calculateDiscount(Order order) {
        if (order.getTotalAmount() == null) return 0.0;
        return order.getTotalAmount() * DISCOUNT_RATE;
    }
}
