package com.ok.controller;

import com.ok.domain.PaymentMethod;
import com.ok.model.PaymentOrder;
import com.ok.payload.dto.BookingDTO;
import com.ok.payload.dto.UserDTO;
import com.ok.payload.response.PaymentLinkResponse;
import com.ok.service.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;

	@PostMapping("/create")
	public ResponseEntity<PaymentLinkResponse> createPaymentLink(
					@RequestBody BookingDTO booking,
					@RequestParam PaymentMethod paymentMethod) throws StripeException, RazorpayException {

		UserDTO user = new UserDTO();
		user.setFullName("John Doe");
		user.setEmail("john@email.com");
		user.setId(1L);

		PaymentLinkResponse response = paymentService.createOrder(
						user, booking, paymentMethod);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{paymentOrderId}")
	public ResponseEntity<PaymentOrder> getPaymentByOrderId(
					@PathVariable Long paymentOrderId) throws Exception {

		PaymentOrder response =
						paymentService.getPaymentOrderById(paymentOrderId);

		return ResponseEntity.ok(response);
	}
}
