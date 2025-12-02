package com.ptit.service;

import com.ptit.service.strategy.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Service quản lý các chiến lược thanh toán.
 * Sử dụng Map để chọn Strategy phù hợp dựa trên key.
 */
@Service
public class PaymentServiceContext {

    private final Map<String, PaymentStrategy> paymentStrategies;

    @Autowired
    public PaymentServiceContext(List<PaymentStrategy> strategies) {
        // Tự động inject tất cả các bean implement PaymentStrategy vào List
        // Sau đó convert sang Map để dễ lookup
        this.paymentStrategies = strategies.stream()
                .collect(Collectors.toMap(PaymentStrategy::getPaymentType, Function.identity()));
    }

    public PaymentStrategy getPaymentStrategy(String paymentType) {
        PaymentStrategy strategy = paymentStrategies.get(paymentType);
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
        return strategy;
    }
}
