package com.ok.service;

import com.ok.domain.PaymentMethod;
import com.ok.model.PaymentOrder;
import com.ok.payload.dto.BookingDTO;
import com.ok.payload.dto.UserDTO;
import com.ok.payload.response.PaymentLinkResponse;
import com.razorpay.PaymentLink;

public interface PaymentService {

	PaymentLinkResponse createOrder(UserDTO user,
                                BookingDTO booking,
                                PaymentMethod paymentMethod);

	PaymentOrder getPaymentOrderById(Long id);

	PaymentOrder getPaymentOrderByPaymentId(String paymentId);

	PaymentLink createRazorpayPaymentLink(UserDTO user,
	                                      Long amount,
	                                      Long orderId);

	String createStripePaymentLink(UserDTO user,
	                               Long amount,
	                               Long orderId);
}
