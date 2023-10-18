package com.shop.user.model;

public class Bill {
	
	private float total;
	private float cgst;
	private float sgst;
	private float finalTotal;
	
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(float total, float cgst, float sgst, float finalTotal) {
		super();
		this.total = total;
		this.cgst = cgst;
		this.sgst = sgst;
		this.finalTotal = finalTotal;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getCgst() {
		return cgst;
	}
	public void setCgst(float cgst) {
		this.cgst = cgst;
	}
	public float getSgst() {
		return sgst;
	}
	public void setSgst(float sgst) {
		this.sgst = sgst;
	}
	public float getFinalTotal() {
		return finalTotal;
	}
	public void setFinalTotal(float finalTotal) {
		this.finalTotal = finalTotal;
	}
	
	
}
