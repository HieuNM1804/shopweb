package com.ptit.service.strategy;

import com.ptit.entity.Order;

/**
 * Strategy Pattern cho hệ thống giảm giá.
 */
public interface DiscountStrategy {
    
    /**
     * Tính toán số tiền được giảm giá.
     * @param order Đơn hàng cần tính toán
     * @return Số tiền được giảm
     */
    double calculateDiscount(Order order);
}
