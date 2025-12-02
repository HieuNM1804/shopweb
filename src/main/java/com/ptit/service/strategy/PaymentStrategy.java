package com.ptit.service.strategy;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Strategy Pattern cho hệ thống thanh toán.
 * Cho phép thay đổi phương thức thanh toán linh hoạt tại runtime.
 */
public interface PaymentStrategy {
    
    /**
     * Xử lý thanh toán và trả về URL chuyển hướng (nếu có) hoặc URL kết quả.
     * @param orderId ID của đơn hàng
     * @param amount Số tiền cần thanh toán (VNĐ)
     * @param orderInfo Thông tin đơn hàng
     * @param request HttpServletRequest để lấy thông tin client (IP, URL trả về)
     * @return URL để redirect người dùng
     */
    String pay(Long orderId, long amount, String orderInfo, HttpServletRequest request);

    /**
     * Trả về tên loại thanh toán để định danh
     */
    String getPaymentType();
}
