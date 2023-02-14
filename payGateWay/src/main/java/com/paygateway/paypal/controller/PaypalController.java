package com.paygateway.paypal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.paygateway.entities.Order;
import com.paygateway.paypal.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import jakarta.validation.Valid;

@Controller
public class PaypalController {

	@Autowired
	PaypalService paypalService;
	
	public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";
    
    @PostMapping("/pay")
//	public String payment(@ModelAttribute("order") Order order) {
    public String payment(@Valid Order order) {
    	try {
			Payment payment = paypalService.createPayment(order);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
    	return "redirect:/"; // you can return your response OBJ
    }
    
}
