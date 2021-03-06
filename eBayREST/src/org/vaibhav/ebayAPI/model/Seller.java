package org.vaibhav.ebayAPI.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Seller {
	String seller_name;
	String seller_address;
	String seller_contactno;
	String seller_email;
	double avg_rating;
	int pin;
	
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public String getSeller_address() {
		return seller_address;
	}
	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
	}
	public String getSeller_contactno() {
		return seller_contactno;
	}
	public void setSeller_contactno(String seller_contactno) {
		this.seller_contactno = seller_contactno;
	}
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public double getAvg_rating() {
		return avg_rating;
	}
	public void setAvg_rating(double avg_rating) {
		this.avg_rating = avg_rating;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}
