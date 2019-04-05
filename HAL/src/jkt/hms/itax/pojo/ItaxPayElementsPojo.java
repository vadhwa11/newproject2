package jkt.hms.itax.pojo;

import java.math.BigDecimal;

public class ItaxPayElementsPojo {
	
	String section;
	String payElement;
	BigDecimal amount;
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getPayElement() {
		return payElement;
	}
	public void setPayElement(String payElement) {
		this.payElement = payElement;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	

}
