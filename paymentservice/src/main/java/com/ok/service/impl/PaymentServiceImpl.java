package com.ok.service.impl;

import com.ok.domain.PaymentMethod;
import com.ok.model.PaymentOrder;
import com.ok.payload.dto.BookingDTO;
import com.ok.payload.dto.UserDTO;
import com.ok.payload.response.PaymentLinkResponse;
import com.ok.repo.PaymentOrderRepo;
import com.ok.service.PaymentService;
import com.razorpay.PaymentLink;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	private final PaymentOrderRepo paymentOrderRepo;

	@Value("${stripe.api.key}")
	private String stripeSecretKey;

	@Value("${razorpay.api.key}")
	private String razorpayApiKey;

	@Value("${razorpay.api.secret}")
	private String razorpayApiSecret;

	@Override
	public PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod) {

		Long amount = (long) booking.getTotalPrice();
		PaymentOrder order = new PaymentOrder();
		order.setAmount(amount);
		order.setPaymentMethod(paymentMethod);
		order.setBookingId(booking.getId());
		order.setSalonId(booking.getSalonId());

		PaymentOrder savedOrder = paymentOrderRepo.save(order);

		PaymentLinkResponse paymentLinkResponse = new PaymentLinkResponse();

		if (paymentMethod.equals(PaymentMethod.RAZORPAY)) {

			PaymentLink payment = createRazorpayPaymentLink(
							user,
							savedOrder.getAmount(),
							savedOrder.getId());

			String paymentUrl = payment.get("short_url");

			String paymentUrlId = payment.get("id");

			paymentLinkResponse.setPayment_link_url(paymentUrl);
			paymentLinkResponse.setGetPayment_link_id(paymentUrlId);

			savedOrder.setPaymentLinkId(paymentUrlId);

			paymentOrderRepo.save(savedOrder);
		} else {
			String paymentUrl = createStripePaymentLink(
							user,
							savedOrder.getAmount(),
							savedOrder.getId());

			paymentLinkResponse.setPayment_link_url(paymentUrl);
		}

		return paymentLinkResponse;
	}

	@Override
	public PaymentOrder getPaymentOrderById(Long id) {
		return null;
	}

	@Override
	public PaymentOrder getPaymentOrderByPaymentId(String paymentId) {
		return null;
	}

	@Override
	public PaymentLink createRazorpayPaymentLink(UserDTO user, Long amount, Long orderId) {
		return null;
	}

	@Override
	public String createStripePaymentLink(UserDTO user, Long amount, Long orderId) {
		return "";
	}
}
