package com.ptit.service.strategy;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class CODStrategy implements PaymentStrategy {

    @Override
    public String pay(Long orderId, long amount, String orderInfo, HttpServletRequest request) {
        // Thanh toán khi nhận hàng thì không cần gọi API bên thứ 3
        // Trả về trang thành công ngay lập tức
        return "/order/detail/" + orderId;
    }

    @Override
    public String getPaymentType() {
        return "COD";
    }
}
