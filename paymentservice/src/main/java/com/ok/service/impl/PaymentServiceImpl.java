package com.ok.service.impl;

import com.ok.domain.PaymentMethod;
import com.ok.model.PaymentOrder;
import com.ok.payload.dto.BookingDTO;
import com.ok.payload.dto.UserDTO;
import com.ok.payload.response.PaymentLinkResponse;
import com.ok.repo.PaymentOrderRepo;
import com.ok.service.PaymentService;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import netscape.javascript.JSObject;
import org.json.JSONObject;
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
	public PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod) throws RazorpayException {

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
	public PaymentOrder getPaymentOrderById(Long id) throws Exception {

		PaymentOrder paymentOrder = paymentOrderRepo.findById(id).orElse(null);
		if (paymentOrder == null) {
			throw new Exception("Payment order not found");
		}

		return paymentOrder;
	}

	@Override
	public PaymentOrder getPaymentOrderByPaymentId(String paymentId) {

		return paymentOrderRepo.findByPaymentLinkId(paymentId);
	}

	@Override
	public PaymentLink createRazorpayPaymentLink(UserDTO user,
	                                             Long Amount,
	                                             Long orderId) throws RazorpayException {

		Long amount = Amount * 100;

		RazorpayClient razorpay = new RazorpayClient(razorpayApiKey, razorpayApiSecret);

		JSONObject paymentLinkRequest = new JSONObject();
		paymentLinkRequest.put("amount", amount);
		paymentLinkRequest.put("currency", "INR");

		JSONObject customer = new JSONObject();
		customer.put("name", user.getFullName());
		customer.put("email", user.getEmail());

		paymentLinkRequest.put("customer", customer);

		JSONObject notify =  new JSONObject();
		notify.put("email", true);

		paymentLinkRequest.put("notify", notify);

		paymentLinkRequest.put("reminder_enabled", true);

		paymentLinkRequest.put("callback_url",
						"http://localhost:3000/payment-success/" + orderId);

		paymentLinkRequest.put("callback_method", "get");

		PaymentLink paymentLink = razorpay.paymentLink.create(paymentLinkRequest);

		return paymentLink;
	}

	@Override
	public String createStripePaymentLink(UserDTO user, Long amount, Long orderId) {
		return "";
	}
}
