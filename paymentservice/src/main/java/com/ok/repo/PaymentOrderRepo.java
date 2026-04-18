package com.ok.repo;

import com.ok.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepo extends JpaRepository<PaymentOrder, Long> {

	PaymentOrder findByPaymentLinkId(String paymentLinkId);
}
