package com.paygateway.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ORDER")
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oredrId;
	
	@Column(name = "PAYPAL_ORDER_ID")
	private String paypalOredrId;
	
	@Column(name = "PAYPAL_ORDER_STATUS")
	private long paypalOredrStatus;

	@Column(name = "AMOUNT_PAID")
	private String ammountPaid;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	public String getAmmountPaid() {
		return ammountPaid;
	}

	public void setAmmountPaid(String ammountPaid) {
		this.ammountPaid = ammountPaid;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getOredrId() {
		return oredrId;
	}

	public void setOredrId(long oredrId) {
		this.oredrId = oredrId;
	}

	public String getPaypalOredrId() {
		return paypalOredrId;
	}

	public void setPaypalOredrId(String paypalOredrId) {
		this.paypalOredrId = paypalOredrId;
	}

	public long getPaypalOredrStatus() {
		return paypalOredrStatus;
	}

	public void setPaypalOredrStatus(long paypalOredrStatus) {
		this.paypalOredrStatus = paypalOredrStatus;
	}
	
}
