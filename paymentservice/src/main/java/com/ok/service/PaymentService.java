package com.ok.service;

import com.ok.domain.PaymentMethod;
import com.ok.model.PaymentOrder;
import com.ok.payload.dto.BookingDTO;
import com.ok.payload.dto.UserDTO;
import com.ok.payload.response.PaymentLinkResponse;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {

	PaymentLinkResponse createOrder(UserDTO user,
                                BookingDTO booking,
                                PaymentMethod paymentMethod) throws RazorpayException, StripeException;

	PaymentOrder getPaymentOrderById(Long id) throws Exception;

	PaymentOrder getPaymentOrderByPaymentId(String paymentId);

	PaymentLink createRazorpayPaymentLink(UserDTO user,
	                                      Long amount,
	                                      Long orderId) throws RazorpayException;

	String createStripePaymentLink(UserDTO user,
	                               Long amount,
	                               Long orderId) throws StripeException;

	Boolean proceedPayment(PaymentOrder paymentOrder,
	                       String paymentId,
	                       String paymentLinkId) throws RazorpayException;
}
