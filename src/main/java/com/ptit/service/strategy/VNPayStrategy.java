package com.ptit.service.strategy;

import com.ptit.dto.VNPayRequestDTO;
import com.ptit.service.VNPayService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VNPayStrategy implements PaymentStrategy {

    @Autowired
    private VNPayService vnPayService;

    @Override
    public String pay(Long orderId, long amount, String orderInfo, HttpServletRequest request) {
        VNPayRequestDTO requestDTO = new VNPayRequestDTO();
        requestDTO.setOrderId(String.valueOf(orderId));
        requestDTO.setAmount(amount * 100); // VNPay yêu cầu số tiền * 100
        requestDTO.setOrderInfo(orderInfo);
        
        return vnPayService.createPaymentUrl(requestDTO, request); 
    }

    @Override
    public String getPaymentType() {
        return "VNPAY";
    }
}
