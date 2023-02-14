package com.paygateway.paypal.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paygateway.entities.Order;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class PaypalService {
	
	@Autowired
	APIContext apiContext;
	private List<Transaction> transactions;
	
	public Payment createPayment(Order order) throws PayPalRESTException {
		Amount amt = new Amount();
		amt.setCurrency(order.getCurrency());
		amt.setTotal(String.format("%.2f", new BigDecimal(order.getAmmountPaid())
				.setScale(2, RoundingMode.HALF_DOWN).doubleValue()));
		Transaction t = new Transaction();
		t.setAmount(amt);
		
		Payer payer = new Payer();
		payer.setPaymentMethod("UPI");
		
		transactions = new ArrayList<>();
		transactions.add(t);
		
		Payment payment = new Payment();
		payment.setIntent("Intent");
		payment.setPayer(payer);  
		payment.setTransactions(transactions);
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("/cancelUrl");
		redirectUrls.setReturnUrl("/successUrl");
		payment.setRedirectUrls(redirectUrls);
		return payment.create(apiContext);
	}
	
	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
		Payment payment = new Payment();
		payment.setId(paymentId);
		PaymentExecution paymentExecute = new PaymentExecution();
		paymentExecute.setPayerId(payerId);
		return payment.execute(apiContext, paymentExecute);
	}

}
