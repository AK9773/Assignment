package com.zensar.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {
	@Id
	private int couponId;
	private int couponCode;
	private int percentDiscount;
	public Coupon() {
		super();
	}
	public Coupon(int couponId, int couponCode, int percentDiscount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.percentDiscount = percentDiscount;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public int getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(int couponCode) {
		this.couponCode = couponCode;
	}
	public int getPercentDiscount() {
		return percentDiscount;
	}
	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", percentDiscount=" + percentDiscount
				+ "]";
	}
	
	

}
